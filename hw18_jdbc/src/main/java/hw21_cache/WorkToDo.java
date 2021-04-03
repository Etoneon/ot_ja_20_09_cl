package hw21_cache;

import hw21_cache.core.model.Account;
import hw21_cache.core.service.DBServiceMapperImpl;
import hw21_cache.jdbc.DbExecutor;
import hw21_cache.jdbc.DbExecutorImpl;
import hw21_cache.jdbc.dao.ClientDaoJdbc;
import hw21_cache.jdbc.mapper.EntitySQLMetaData;
import hw21_cache.jdbc.mapper.EntitySQLMetaDataImpl;
import hw21_cache.jdbc.mapper.JdbcMapperImpl;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hw21_cache.core.dao.ClientDao;
import hw21_cache.core.model.Client;
import hw21_cache.core.service.DbServiceClientImpl;
import hw21_cache.demo.DataSourceDemo;

import hw21_cache.jdbc.mapper.JdbcMapper;
import hw21_cache.jdbc.sessionmanager.SessionManagerJdbc;

import javax.sql.DataSource;
import java.util.Optional;


public class WorkToDo  {

    private static final Logger logger = LoggerFactory.getLogger(WorkToDo.class);

    public static void main(String[] args) {
// Общая часть
        var dataSource = new DataSourceDemo();
        flywayMigrations(dataSource);
        var sessionManager = new SessionManagerJdbc(dataSource);

// Работа с пользователем
        DbExecutor <Client> dbExecutor = new DbExecutorImpl<>();
        JdbcMapper<Client> jdbcMapperClient = new JdbcMapperImpl<>(sessionManager, dbExecutor);
        JdbcMapper<Account> jdbcMapperAccount = new JdbcMapperImpl<>(sessionManager, dbExecutor);
        EntitySQLMetaData <Client> sqlMetaDataClient = new EntitySQLMetaDataImpl<>(Client.class);
        EntitySQLMetaData <Account> sqlMetaDataAccount = new EntitySQLMetaDataImpl<>(Account.class);
        ClientDao clientDao = new ClientDaoJdbc(sessionManager, dbExecutor);

// Код дальше должен остаться, т.е. clientDao должен использоваться
        var dbServiceClient = new DbServiceClientImpl(clientDao);
        var id = dbServiceClient.saveClient(new Client(0, "dbServiceClient"));
        Optional<Client> clientOptional = dbServiceClient.getClient(id);

        clientOptional.ifPresentOrElse(
                client -> logger.info("created client, name:{}", client.getName()),
                () -> logger.info("client was not created")
        );

// новая работа с клиентом

        var dbServiceMapperCli = new DBServiceMapperImpl(jdbcMapperClient);
        dbServiceMapperCli.saveObject(new Client(1000, "dbServiceClient",50));
        Client client = (Client) dbServiceMapperCli.getObject(1000,Client.class);

        if (client!=null){logger.info("created client, name:{}", client.getName());}
        else {logger.info("client was not created");}

// Работа со счетом
        var dbServiceMapperAcc = new DBServiceMapperImpl(jdbcMapperAccount);
        dbServiceMapperAcc.saveObject(new Account("fg23r", "saving", 50.3F));
        Account account = (Account) dbServiceMapperAcc.getObject("fg23r", Account.class);

        if (account!=null){logger.info("created account, type:{}", account.getType());}
        else {logger.info("account was not created");}

    }

    private static void flywayMigrations(DataSource dataSource) {
        logger.info("db migration started...");
        var flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:/db/migration")
                .load();
        flyway.migrate();
        logger.info("db migration finished.");
        logger.info("***");
    }

}
