package hw18_jdbc.jdbc.dao;


import hw18_jdbc.jdbc.DbExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hw18_jdbc.core.dao.ClientDao;
import hw18_jdbc.core.dao.ClientDaoException;
import hw18_jdbc.core.model.Client;
import hw18_jdbc.core.sessionmanager.SessionManager;
import hw18_jdbc.jdbc.sessionmanager.SessionManagerJdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Optional;

// этот класс не должен быть в домашней работе
public class ClientDaoJdbc implements ClientDao {
    private static final Logger logger = LoggerFactory.getLogger(ClientDaoJdbc.class);

    private final SessionManagerJdbc sessionManager;
    private final DbExecutor<Client> dbExecutor;

    public ClientDaoJdbc(SessionManagerJdbc sessionManager, DbExecutor <Client> dbExecutor) {
        this.sessionManager = sessionManager;
        this.dbExecutor = dbExecutor;
    }

    @Override
    public Optional<Client> findById(long id) {
        try {
            return dbExecutor.executeSelect(getConnection(), "select id, name from client where id  = ?",
                    id, rs -> {
                        try {
                            if (rs.next()) {
                                return new Client(rs.getLong("id"), rs.getString("name"));
                            }
                        } catch (SQLException e) {
                            logger.error(e.getMessage(), e);
                        }
                        return null;
                    });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public long insert(Client client) {
        try {
            return dbExecutor.executeInsert(getConnection(), "insert into client(name) values (?)",
                    Collections.singletonList(client.getName()));
        } catch (Exception e) {
            throw new ClientDaoException(e);
        }
    }

    @Override
    public SessionManager getSessionManager() {
        return sessionManager;
    }

    private Connection getConnection() {
        return sessionManager.getCurrentSession().getConnection();
    }
}
