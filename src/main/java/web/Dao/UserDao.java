package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
