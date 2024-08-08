package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private UserDaoImpl() {

    }

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findOne(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User updatedUser) {
        User user = findOne(id);

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User user = findOne(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
