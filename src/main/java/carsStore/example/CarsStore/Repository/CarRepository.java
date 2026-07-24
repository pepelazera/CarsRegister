package carsStore.example.CarsStore.Repository;

import carsStore.example.CarsStore.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long> {

}
