package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userServiceImpl;

    @Autowired
    public UsersController(UserService userService) {
        this.userServiceImpl = userService;
    }
    @GetMapping("/users")
    public String findAll(ModelMap model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "users";
    }

    @GetMapping("/user")
    public String findOne(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("user", userServiceImpl.findOne(id));
        return "user";
    }

    @GetMapping("users/new")
    public String save(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users/save")
    public String save(@ModelAttribute User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String update(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("user", userServiceImpl.findOne(id));
        return "edit";
    }

    @PostMapping("/users/update")
    public String update(@ModelAttribute User user) {
        userServiceImpl.update(user.getId(), user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String delete(@RequestParam("id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }


}
