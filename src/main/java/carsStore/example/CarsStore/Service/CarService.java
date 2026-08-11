package carsStore.example.CarsStore.Service;

import carsStore.example.CarsStore.Model.CarModel;

import carsStore.example.CarsStore.Repository.CarRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // GET and GET with id
    public List<CarModel> listCars() {
        return carRepository.findAll();
    }

    public List<CarModel> listCarsById(Long id) {
        return carRepository.findAllById(Collections.singleton(id));
    }

    // POST
    public CarModel createCar(CarModel carModel) {
        return carRepository.save(carModel);
    }

    // PUT and PATCH

    // DELETE with id
    public void deleteCarsById(Long id) {
        carRepository.deleteById(id);
    }

}
