package carsStore.example.CarsStore;

import carsStore.example.CarsStore.DTO.CarDTO;
import carsStore.example.CarsStore.Enums.Condition;
import carsStore.example.CarsStore.Service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cars/ui")
public class CarControllerUi {

    private final CarService carService;

    public CarControllerUi(CarService carService) {
        this.carService = carService;
    }

    // localhost:8080/cars/ui/list

    @GetMapping("/list")
    public String CarsList(Model model) {
        List<CarDTO> carDTOS = carService.listCars();
        model.addAttribute("cars",carDTOS);
        return "listCars";
    }

    @GetMapping("/list/{id}")
    public String CarsListId(@PathVariable Long id, Model model) {
        CarDTO carDTO = carService.listCarsById(id);

        if (carDTO != null) {
            model.addAttribute("cars", carDTO);
            return "carDetails";
        } else {
            model.addAttribute("message", "Car not found");
            return "listCars";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        CarDTO carDTO = carService.listCarsById(id);

        if (carDTO == null) {
            return "redirect:/cars/ui/list";
        }

        model.addAttribute("car", carDTO);
        model.addAttribute("conditions", Condition.values());
        return "carEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") CarDTO carDTO) {
        carService.updateCarById(id, carDTO);
        return "redirect:/cars/ui/list/" + id;
    }

    @PostMapping("/save")
    public String saveCars(@ModelAttribute CarDTO carDTO, RedirectAttributes redirectAttributes) {
        carService.createCar(carDTO);
        redirectAttributes.addFlashAttribute("message", "Car not found");
        return "redirect:/cars/ui/list";
    }

    @GetMapping("/delete/{id}")
    public String DeleteCarById(@PathVariable Long id) {
        carService.deleteCarsById(id);
        return "redirect:/cars/ui/list";
    }

    @GetMapping("/new")
    public String newCarForm(Model model) {
        model.addAttribute("car", new CarDTO());
        model.addAttribute("conditions", Condition.values());
        return "carNew";
    }

    @PostMapping("/new")
    public String createCar(@ModelAttribute("car") CarDTO carDTO) {
        CarDTO saved = carService.createCar(carDTO);
        return "redirect:/cars/ui/list/" + saved.getId();
    }
}
