package ru.job4j.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    public String userSave(
            @RequestParam("userId") Long id,
            @RequestParam Map<String, String> form,
            @RequestParam String username){
        User user = userRepo.findUserById(id);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
        return "redirect:/admin";

    }



}
