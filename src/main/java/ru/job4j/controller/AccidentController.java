package ru.job4j.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepository;

@Controller
@RequestMapping("/accident")
@SessionAttributes(types = Accident.class)
public class AccidentController {
    @GetMapping
    public ModelAndView accidentPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("modelAccident",new Accident());
        model.setViewName("accident");
        return model;
    }

    @PostMapping
    public String fillForm(@ModelAttribute("modelAccident")Accident accident){
        AccidentRepository.getINSTANCE().add(accident);
        return "redirect:/police";
    }

}
