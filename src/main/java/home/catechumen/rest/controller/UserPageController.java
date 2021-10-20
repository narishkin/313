package home.catechumen.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userpage")
public class UserPageController {

    @GetMapping
    public String userPage(){
        return "adminpage";
    }
}
