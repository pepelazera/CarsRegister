package carsStore.example.CarsStore.Controller;

import carsStore.example.CarsStore.Model.CarModel;
import carsStore.example.CarsStore.Repository.CarRepository;
import carsStore.example.CarsStore.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // GET
    @GetMapping("/list")
    public CarModel CarsList(@RequestBody CarModel carModel) {
        return (CarModel) carRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public CarModel CarsListId(@PathVariable Long id) {
        return null;
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
