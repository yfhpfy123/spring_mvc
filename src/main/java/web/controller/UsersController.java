package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
public class UsersController {


    private UserService userService;
    @Autowired
    public void setUsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @GetMapping("users/{id}")
    public String show(int id, ModelMap model) {
        model.addAttribute("user", userService.findOne(id));
        return "users/show";
    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("users/{id}/edit")
    public String edit(ModelMap model, int id) {
        model.addAttribute("user", userService.findOne(id));
        return "users/edit";
    }
    @PostMapping("users/{id}")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User updatedUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.update(id, updatedUser);
        return "redirect:/users";
    }
    @PostMapping("users/{id}/delete")
    public String delete(int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
