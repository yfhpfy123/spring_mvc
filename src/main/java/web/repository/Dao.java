package web.repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface Dao {

    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
