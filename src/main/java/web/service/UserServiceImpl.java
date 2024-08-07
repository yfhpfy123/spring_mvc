package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.Dao;
import web.repository.UserDao;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private Dao userDao;

    @Autowired
    public void setUserServiceImpl(UserDao dao) {
        this.userDao = dao;
        System.out.println("userServiceImpl created");
    }
    
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        if (userDao != null) {
            users = userDao.findAll();
            System.out.println("user dao not null");
            return users;
        } else {
            users.add(new User("null", "null", 0));
            System.out.println("user dao null");
            return users;
        }
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
