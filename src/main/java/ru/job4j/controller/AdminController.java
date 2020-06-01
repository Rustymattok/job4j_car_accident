package ru.job4j.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepo;
import java.util.List;

@Controller
@RequestMapping(value ="/admin",produces = {"application/xml; charset=UTF-8"})
public class AdminController {
    private UserRepo userRepo;

    @Autowired
    public AdminController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String showPage(Model model){
        List<User> userList = userRepo.findAll();
        model.addAttribute("users",userList);
        return "adminpanel";
    }

    @GetMapping ("{id}")
    public String userEdit(@PathVariable Long id, Model model){
        User user = userRepo.findUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "edituser";
    }

    @PostMapping
    public String userSave(@ModelAttribute("user") User user){
        User userForm = userRepo.findUserById(user.getId());
        userForm.getRoles().clear();
        userForm.setRoles(user.getRoles());
        userRepo.save(userForm);
        return "redirect:/admin";
    }

}
