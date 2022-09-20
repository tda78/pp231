package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

@Controller
public class UserController {
    UserService service;

    public UserService getService() {
        return service;
    }
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/users")
    public String printCars(Model model){
        model.addAttribute("users",service.readUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newCar(){
        return "new";
    }
}
