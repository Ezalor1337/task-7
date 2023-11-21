package web.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}


