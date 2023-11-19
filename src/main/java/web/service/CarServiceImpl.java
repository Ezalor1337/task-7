package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.CarDao;
import web.model.Car;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public List<Car> getCars(int count) {
        return carDao.getCars(count);
    }

    @Transactional
    @Override
    public void getCar(Car car) {
        carDao.getCar(car);
    }
}
