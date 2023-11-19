package web.Dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCars(int count);

    void getCar(Car car);
}


