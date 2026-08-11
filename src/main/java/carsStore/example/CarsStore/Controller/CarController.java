package carsStore.example.CarsStore.Controller;

import carsStore.example.CarsStore.Model.CarModel;
import carsStore.example.CarsStore.Service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // GET
    @GetMapping("/list")
    public List<CarModel> CarsList() {
        return carService.listCars();
    }

    @GetMapping("/list/{id}")
    public List<CarModel> CarsListId(@PathVariable Long id) {
        return carService.listCarsById(id);
    }

    // POST
    @PostMapping("/register")
    public CarModel CarsRegister(@RequestBody CarModel carModel) {
        return carService.createCar(carModel);
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
    @DeleteMapping("/delete/{id}")
    public void DeleteCarById(@PathVariable Long id) {
        carService.deleteCarsById(id);
    }
}
