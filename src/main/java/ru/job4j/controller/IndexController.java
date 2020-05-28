package ru.job4j.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.service.AccidentService;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Controller for police.jsp.
 */
@Controller
@RequestMapping(value ="/police",produces = {"application/xml; charset=UTF-8"})
@SessionAttributes(types = Accident.class)
public class IndexController {
    private final AccidentService accidentStore;

    @Autowired
    public IndexController(AccidentService accidentStore) {
        this.accidentStore = accidentStore;
    }
    /**
     * This controller show data accident.
     * If role of user - user he can see only his own accidents.
     * If rile of user - admin he can see all accidents.
     * @param model - send to jsp page data.
     * @return - link for jsp.
     */
    @GetMapping
    public String showPolice(Model model){
        User user = (User) org.springframework.security.core.context.SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        List<Accident> listAccidentShow = new LinkedList<>();
        if(user.getAuthorities().contains(Role.USER)){
            listAccidentShow = accidentStore.findAllByAuthor(user);
        }
        if(user.getAuthorities().contains(Role.ADMIN)){
            listAccidentShow = accidentStore.get();
        }
        model.addAttribute("object",listAccidentShow);
        model.addAttribute("user",user);
        model.addAttribute("roleValidation",Role.ADMIN);
        return "police";
    }
}
