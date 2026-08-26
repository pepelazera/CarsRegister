package carsStore.example.CarsStore.Controller;

import carsStore.example.CarsStore.DTO.CarDTO;
import carsStore.example.CarsStore.Service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> CarsRegister(@RequestBody CarDTO carDTO) {
        CarDTO newCarDTO =  carService.createCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The car has been successfully added. Name: " + newCarDTO.getCarName() + " || Model: " + newCarDTO.getModel());
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<String> CarsUpdate(@PathVariable Long id, @RequestBody CarDTO carDTOUpdated) {
        carService.updateCarById(id, carDTOUpdated);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("The car with id (" + id + ") has been successfully updated");
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<String> CarsPatch(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        carService.patchCar(id, carDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Car information with id (" + id +") has been successfully changed");
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteCarById(@PathVariable Long id) {
        if (carService.listCarsById(id) != null) {
            carService.deleteCarsById(id);
            return ResponseEntity.ok()
                    .body("The car with id (" + id + ") has been successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with id (" + id + ") doesn't exist");
        }
    }
}
