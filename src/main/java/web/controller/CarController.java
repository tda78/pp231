package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    CarService service = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String printCars(Model model, @RequestParam (value = "count", required = false) Integer count){
        if (count == null || count > 5) {
            count = 5;
        }
        List<Car> cars = service.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
