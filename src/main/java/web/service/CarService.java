package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

import static web.model.Car.carList;

@Service
public class CarService {

    public CarService() {

    }

    public List<Car> getCarByCount(Integer count) {
        if (carList.isEmpty()) {
            carList.add(new Car("BMW", 3, "White"));
            carList.add(new Car("Audi", 5, "Black"));
            carList.add(new Car("Mercedes", 6, "Red"));
            carList.add(new Car("Nissan", 7, "Blue"));
            carList.add(new Car("Toyota", 8, "Green"));
        }
        if (count > carList.size() || count < 0 || count == null) {
            count = carList.size();
        }
        List<Car> cars = carList.subList(0, count);
        return cars;
    }
}
