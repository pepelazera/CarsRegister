package carsStore.example.CarsStore.Controller;

import carsStore.example.CarsStore.DTO.CarDTO;
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
    public List<CarDTO> CarsList() {
        return carService.listCars();
    }

    @GetMapping("/list/{id}")
    public CarDTO CarsListId(@PathVariable Long id) {
        return carService.listCarsById(id);
    }

    // POST
    @PostMapping("/register")
    public CarDTO CarsRegister(@RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public CarDTO CarsUpdate(@PathVariable Long id, @RequestBody CarDTO carModelUpdated) {
        return carService.updateCarById(id, carModelUpdated);
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
