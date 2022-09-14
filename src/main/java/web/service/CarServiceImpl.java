package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static List<Car> cars;

    static {
        cars = new ArrayList<Car>();
        cars.add(new Car("audi", 12, "white"));
        cars.add((new Car("ford", 3, "black")));
        cars.add((new Car("reno", 13, "gray")));
        cars.add((new Car("ferrary", 4, "red")));
        cars.add((new Car("rolls-roys", 2, "pink")));
    }

    public List<Car> getCars(int count) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(cars.get(i));
        }
        return result;
    }
}
