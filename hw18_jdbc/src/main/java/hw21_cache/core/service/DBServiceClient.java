package hw21_cache.core.service;

import hw21_cache.core.model.Client;

import java.util.Optional;

public interface DBServiceClient {

    long saveClient(Client client);

    Optional<Client> getClient(long id);

    //List<Client> findAll();
}
