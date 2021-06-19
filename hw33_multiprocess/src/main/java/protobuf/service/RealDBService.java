package protobuf.service;

import protobuf.model.User;

import java.util.List;

public interface RealDBService {
    User saveUser(String firstName, String lastName);
    List<User> findAllUsers();
}
