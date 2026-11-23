package carsStore.example.CarsStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // localhost:8080/ -> redirects to the car list page
    @GetMapping("/")
    public String home() {
        return "redirect:/cars/ui/list";
    }
}
