package home.catechumen.rest.controller;


import home.catechumen.rest.config.exceptionhandler.UserNotFoundException;
import home.catechumen.rest.model.User;
import home.catechumen.rest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserRestController {

    UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getUserInfo(Principal principal){
        if (principal != null) {
            return  userService.findByUserName(principal.getName());
        } else {
            throw new UserNotFoundException("Not registered");
        }
    }
}
