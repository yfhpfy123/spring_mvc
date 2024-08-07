package web.service;

import web.model.User;

public interface UserService {
    User findOne(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
