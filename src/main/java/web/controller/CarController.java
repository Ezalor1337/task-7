package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;



@Controller
public class CarController {
    @Autowired
    private CarService carService;



    @GetMapping("/cars")
    public String showCars(@RequestParam(defaultValue = "0") Integer count, Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "CarIndex";
    }

    @GetMapping("/saveCars")
    public String saveCars(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CarAdd";
    }

    @PostMapping
    public String addCar(@ModelAttribute("car") Car car) {
        carService.getCar(car);
        return "redirect:/";
    }
}
