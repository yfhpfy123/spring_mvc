package web.repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface Dao {

    List<User> findAll();

    User findOne(int id);

    @Transactional
    void save(User user);

    @Transactional
    void update(int id, User updatedUser);

    @Transactional
    void delete(int id);
}
