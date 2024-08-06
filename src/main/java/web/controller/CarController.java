package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private final CarService carServiceImpl;
    @Autowired
    public CarController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping()
    public String printCars(ModelMap model,@RequestParam(value = "count", defaultValue = "5") Integer count) {
        model.addAttribute("cars", carServiceImpl.getCarByCount(count));
        return "cars";
    }
}
