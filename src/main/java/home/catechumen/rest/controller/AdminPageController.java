package home.catechumen.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/adminpage")
public class AdminPageController {

    @GetMapping
    public String adminPage() {
        return "adminpage";
    }
}
