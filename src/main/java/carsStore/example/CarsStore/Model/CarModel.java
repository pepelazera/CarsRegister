package carsStore.example.CarsStore.Model;

import carsStore.example.CarsStore.Enums.Condition;
import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "tb_cars")
@ToString
public class CarModel {

    public CarModel(Long id, String carName, String model, Integer year, Condition condition) {
        this.id = id;
        this.carName = carName;
        this.model = model;
        this.year = year;
        this.condition = condition;
    }

    public CarModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String carName;

    @Column(name = "model")
    private String model;

    @Column(name = "car_year")
    private Integer year;

    @Column(name = "condition")
    @Enumerated(EnumType.STRING)
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
