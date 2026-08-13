package carsStore.example.CarsStore.Service;

import carsStore.example.CarsStore.DTO.CarDTO;
import carsStore.example.CarsStore.Mapper.CarsMapper;
import carsStore.example.CarsStore.Model.CarModel;

import carsStore.example.CarsStore.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarsMapper carsMapper;

    public CarService(CarRepository carRepository, CarsMapper carsMapper) {
        this.carRepository = carRepository;
        this.carsMapper = carsMapper;
    }

    // GETs
    public List<CarDTO> listCars() {
        List<CarModel> carModels = carRepository.findAll();
        return carModels.stream()
                .map(carsMapper::map)
                .collect(Collectors.toList());
    }

    public CarDTO listCarsById(Long id) {
        Optional<CarModel> carId = carRepository.findById(id);
        return carId.map(carsMapper::map).orElse(null);
    }

    // POST
    public CarDTO createCar(CarDTO carDTO) {
        CarModel carModel = carsMapper.map(carDTO);
        carModel = carRepository.save(carModel);
        return carsMapper.map(carModel);
    }

    // PUT and PATCH
    public CarDTO updateCarById(Long id, CarDTO carDTO) {
        Optional<CarModel> carModels = carRepository.findById(id); // It's used like an if/else loop
        if (carModels.isPresent()) { // The "isPresent" is used when we need to know if one information is in the local
            CarModel carModelUpdated = carsMapper.map(carDTO); // Here, I did a mapper of my DTO
            carModelUpdated.setId(id); // I override the id fo
            CarModel carsSaved = carRepository.save(carModelUpdated); // Here, I will override and save the data of the cars
            return carsMapper.map(carsSaved); // and here, will be returned the mapper of carsSaved
        }
        return null; // If the user put an id that not exist, the application will be return null
    }

    // DELETE with id
    public void deleteCarsById(Long id) {
        carRepository.deleteById(id);
    }

}
