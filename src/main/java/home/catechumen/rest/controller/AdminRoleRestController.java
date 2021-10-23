package home.catechumen.rest.controller;


import home.catechumen.rest.model.Role;
import home.catechumen.rest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleRestController {

    private final RoleService roleService;

    @Autowired
    public AdminRoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> showAllRoles(){
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

}
