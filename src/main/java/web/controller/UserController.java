package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("usersList", service.index());
        return "users/index";
    }


//    @GetMapping("/{id}")
//    public String showById(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("user", service.showById(id));
//        return "users/show";
//    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }


    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/users";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.deleteUserById(id);
        return "redirect:/users";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", service.showById(id));
        return "users/edit";
    }


    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        service.updateUser(user, id);
        return "redirect:/users";
    }
}