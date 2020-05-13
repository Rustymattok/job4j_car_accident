package ru.job4j.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentRepository;
import ru.job4j.service.AccidentStore;

@Controller
@RequestMapping("/accident")
@SessionAttributes(types = Accident.class)
public class AccidentController {
    private final AccidentStore accidentStore;
    @Autowired
    public AccidentController(AccidentStore accidentStore) {
        this.accidentStore = accidentStore;
    }

    @GetMapping
    public ModelAndView accidentPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("modelAccident",new Accident());
        model.setViewName("accident");
        return model;
    }

    @PostMapping
    public String fillForm(@ModelAttribute("modelAccident")Accident accident){
        accidentStore.add(accident);
       // AccidentRepository.getINSTANCE().add(accident);
        return "redirect:/police";
    }

}
