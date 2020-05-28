package ru.job4j.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepo;
import java.util.Collections;

@Controller
@RequestMapping(value ="/registration",produces = {"application/xml; charset=UTF-8"})
public class RegistrationController {
    private final UserRepo userRepo;

    @Autowired
    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getLinkRegistr(Model model){
        model.addAttribute("modelUser", new User());
        return "registration";
    }

    @PostMapping
    public String loginForm(@ModelAttribute ("modelUser") User user, Model model){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }

//    @Autowired
//    public TestSimulate(UserService userService, SecurityService securityService, UserValidator userValidator) {
//        this.userService = userService;
//        this.securityService = securityService;
//        this.userValidator = userValidator;
//    }
//
//    @GetMapping
//    public String registration(Model model){
//        model.addAttribute("userForm",new User());
//        return "registration";
//    }
//
//    @PostMapping
//    public  String registration(@ModelAttribute("userForm") User userForm, Model model){
////        userValidator.validate(userForm,bindingResult);
////        if(bindingResult.hasErrors()){
////            return "registration";
////        }
//        userService.save(userForm);
//        securityService.autoLogin(userForm.getUsername(),userForm.getConfirmPassword());
//        return "redirect:/";
//    }

}
