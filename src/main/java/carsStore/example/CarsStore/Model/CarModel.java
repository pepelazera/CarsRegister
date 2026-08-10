package carsStore.example.CarsStore.Model;

import carsStore.example.CarsStore.Enums.Condition;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_CarRegisters")
public class CarModel {

    public CarModel(Long id, String carName, String model, Integer year, Condition condition) {
        this.id = id;
        CarName = carName;
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
    private String CarName;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "Condition")
    private Condition condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
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
