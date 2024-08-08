package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }
    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDaoImpl.findOne(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDaoImpl.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User updatedUser) {
        userDaoImpl.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       userDaoImpl.delete(id);
    }
}
