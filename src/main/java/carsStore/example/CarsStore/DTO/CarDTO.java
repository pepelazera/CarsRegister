package carsStore.example.CarsStore.DTO;

import carsStore.example.CarsStore.Enums.Condition;

public class CarDTO {

    public CarDTO(Long id, String carName, String model, Integer year, Condition condition) {
        this.id = id;
        this.carName = carName;
        this.model = model;
        this.year = year;
        this.condition = condition;
    }

    public CarDTO() {
    }

    private Long id;
    private String carName;
    private String model;
    private Integer year;
    private Condition condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
