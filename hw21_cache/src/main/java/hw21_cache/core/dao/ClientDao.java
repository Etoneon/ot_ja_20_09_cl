package hw21_cache.core.dao;

import hw21_cache.core.model.Client;
import hw21_cache.core.sessionmanager.SessionManager;

import java.util.Optional;

public interface ClientDao {
    Optional<Client> findById(long id);
    //List<Client> findAll();

    long insert(Client client);

    //void update(Client client);
    //long insertOrUpdate(Client client);

    SessionManager getSessionManager();
}
