package web.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Car> getCars(int count) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car");
        query.setMaxResults(count);
        return query.getResultList();
    }

    @Override
    public void getCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
