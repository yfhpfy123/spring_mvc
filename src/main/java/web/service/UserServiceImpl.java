package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository rep) {
        this.userRepository = rep;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User findOne(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
    @Override
    @Transactional
    public void update(int id,User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }
    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
