package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {

    private static int CAR_COUNT;
    List<Car> cars = new ArrayList<>();

    {

        Car car1 = new Car(++CAR_COUNT, "Vaz", 2121, "blue");
        Car car2 = new Car(++CAR_COUNT, "Bmw", 740, "red");
        Car car3 = new Car(++CAR_COUNT, "Mers", 555, "yellow");
        Car car4 = new Car(++CAR_COUNT, "Audi", 777,"black");
        Car car5 = new Car(++CAR_COUNT, "Porsh", 911,"white");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    public List<Car> index() {
        return cars;
    }

}
