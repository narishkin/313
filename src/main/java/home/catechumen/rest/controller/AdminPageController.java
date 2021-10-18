package home.catechumen.rest.controller;

import home.catechumen.rest.model.Role;
import home.catechumen.rest.model.User;
import home.catechumen.rest.service.RoleServiceImpl;
import home.catechumen.rest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/adminpage")
public class AdminPageController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;


    @Autowired
    public AdminPageController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping
    public String userList(Model model, Principal principal, User user) {
//        List<User> users = userService.getAll();
//        UserRolesDTO userRolesDTO = new UserRolesDTO();
//        model.addAttribute("users", users);
        if (principal != null) {
            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            String s = principal.getName();
            model.addAttribute("userinfo", s);
            model.addAttribute("userRoles", authorities);
            List<Role> listRoles = roleService.getAll();
            model.addAttribute("listRoles", listRoles);
//            model.addAttribute("userRolesDTO", userRolesDTO);
        }
        return "adminpage";
    }

}
