package carsStore.example.CarsStore.Service;

import carsStore.example.CarsStore.Model.CarModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CarService {

    // GET and GET with id
    public ResponseEntity<CarModel> create(CarModel carModel) {
       return ResponseEntity.ok(carModel);
    }



    // POST

    // PUT and PATCH

    // DELETE with id

}
