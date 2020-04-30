package ru.job4j.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;
/**
 * Controller for police.jsp.
 */
@Controller
@RequestMapping(value ="/police",produces = {"application/xml; charset=UTF-8"})
@SessionAttributes(types = Accident.class)
public class IndexController {
    @GetMapping
    public String showPolice(Model model){
        model.addAttribute("test","myText");
        model.addAttribute("object", AccidentService.getINSTANCE().accidewtList());
        return "police";
    }
}
