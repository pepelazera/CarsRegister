package carsStore.example.CarsStore.Controller;

import carsStore.example.CarsStore.Model.CarModel;
import carsStore.example.CarsStore.Service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    CarService carService;

    // GET
    @GetMapping("/list")
    public CarModel CarsList(@RequestBody CarModel carModel) {
        return null;
    }

    @GetMapping("/list/{id}")
    public void CarsListId(@PathVariable Long id) {
    }

    // POST
    @PostMapping("/register")
    public CarModel CarsRegister(@RequestBody CarModel carModel) {
        return null;
    }

    // UPDATE
    @PutMapping("/update")
    public CarModel CarsUpdate(@RequestBody CarModel carModel) {
        return null;
    }

    @PatchMapping("/patch")
    public CarModel CarsPatch(@RequestBody CarModel carModel) {
        return null;
    }

    // DELETE
    public void DeleteCarById(@PathVariable Long id) {
    }
}
