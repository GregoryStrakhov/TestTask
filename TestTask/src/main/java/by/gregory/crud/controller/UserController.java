package by.gregory.crud.controller;

import by.gregory.crud.model.User;
import by.gregory.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") User user) {
        if (user.getId() == 0) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        this.userService.removeUser(id);

        return "redirect:/user";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }

    @RequestMapping("edit/{userName}")
    public String editBook(@PathVariable("userName") String userName, Model model) {
        model.addAttribute("user", this.userService.getUserByName(userName));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }


}
