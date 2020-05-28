package ru.job4j.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.model.User;
import ru.job4j.service.AccidentService;

@Controller
@RequestMapping("/accident")
@SessionAttributes(types = Accident.class)
public class AccidentController {
    private  AccidentService accidentStore;

    @Autowired
    public AccidentController(AccidentService accidentStore) {
        this.accidentStore = accidentStore;
    }

    @GetMapping
    public String accidentPage(Model model){
        model.addAttribute("modelAccident", new Accident());
        return "accident";
    }

    @PostMapping
    public String fillForm(@ModelAttribute("modelAccident")Accident accident){
        User user = (User) org.springframework.security.core.context.SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        accident.setAuthor(user);
        accidentStore.add(accident);
        return "redirect:/police";
    }

}
