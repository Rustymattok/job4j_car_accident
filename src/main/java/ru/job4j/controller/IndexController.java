package ru.job4j.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.service.AccidentService;
/**
 * Controller for police.jsp.
 */
@Controller
@RequestMapping("/police")
public class IndexController {
    @GetMapping
    public String showPolice(Model model){
        model.addAttribute("test","myText");
        model.addAttribute("object", AccidentService.getINSTANCE().accidewtList());
        return "police";
    }
}
