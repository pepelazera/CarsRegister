package carsStore.example.CarsStore.Service;

import carsStore.example.CarsStore.DTO.CarDTO;
import carsStore.example.CarsStore.Mapper.CarsMapper;
import carsStore.example.CarsStore.Model.CarModel;

import carsStore.example.CarsStore.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private CarsMapper carsMapper;

    public CarService(CarRepository carRepository, CarsMapper carsMapper) {
        this.carRepository = carRepository;
        this.carsMapper = carsMapper;
    }

    // GET and GET with id
    public List<CarModel> listCars(CarModel carModel) {
        return carRepository.findAll();
    }

    public List<CarModel> listCarsById(Long id) {
       return carRepository.findAllById(Collections.singleton(id));
    }

    // POST
    public CarDTO createCar(CarDTO carDTO) {
        CarModel carModel = new CarsMapper().map(carDTO);
        carModel = carRepository.save(carModel);
        return carsMapper.map(carModel);
    }

    // PUT and PATCH
    public CarModel updateCarById(Long id, CarModel carModel) {
        if (carRepository.existsById(id)) {
            carModel.setId(id);
            return carRepository.save(carModel);
        }
        return null;
    }

    // DELETE with id
    public void deleteCarsById(Long id) {
        carRepository.deleteById(id);
    }

}
