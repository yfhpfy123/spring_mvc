package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.Dao;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final Dao userDao;

    @Autowired
    public UserServiceImpl(Dao rep) {
        this.userDao = rep;
    }
    
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Override
    public User findOne(int id) {
        User user = userDao.findOne(id);
        return user;
    }
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        userDao.save(updatedUser);
    }
    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

}
