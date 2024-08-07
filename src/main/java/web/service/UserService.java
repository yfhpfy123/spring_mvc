package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long id);
}
