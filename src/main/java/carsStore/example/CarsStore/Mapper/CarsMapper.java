package carsStore.example.CarsStore.Mapper;


import carsStore.example.CarsStore.DTO.CarDTO;
import carsStore.example.CarsStore.Model.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarsMapper {

    public CarModel map(CarDTO carDTO) {
        CarModel carModel = new CarModel();

        carModel.setId(carDTO.getId());
        carModel.setCarName(carDTO.getCarName());
        carModel.setModel(carDTO.getModel());
        carModel.setYear(carDTO.getYear());
        carModel.setCondition(carDTO.getCondition());

        return carModel;
    }

    public CarDTO map(CarModel carModel) {
        CarDTO carDTO = new CarDTO();

        carDTO.setId(carModel.getId());
        carDTO.setCarName(carModel.getCarName());
        carDTO.setModel(carModel.getModel());
        carDTO.setYear(carModel.getYear());
        carDTO.setCondition(carModel.getCondition());

        return carDTO;
    }

}
