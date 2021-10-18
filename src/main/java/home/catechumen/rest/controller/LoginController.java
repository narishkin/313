package home.catechumen.rest.controller;


import home.catechumen.rest.service.RoleServiceImpl;
import home.catechumen.rest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class LoginController {

//    private final UserServiceImpl userService;
//    private final RoleServiceImpl roleService;
//
//    @Autowired
//    public CommonController(UserServiceImpl userService, RoleServiceImpl roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }


//    @GetMapping("/user")
//    public String userPage(Model model, Principal principal) {
//        List<User> users = userService.getAll();
//        model.addAttribute("users", users);
//        if (principal != null) {
//            Collection<? extends GrantedAuthority> authorities =
//                    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//            model.addAttribute("userinfo", principal.getName());
//            model.addAttribute("userRoles", authorities);
//            List<Role> listRoles = roleService.getAll();
//            model.addAttribute("listRoles", listRoles);
//        }
//        return "user";
//    }

}

