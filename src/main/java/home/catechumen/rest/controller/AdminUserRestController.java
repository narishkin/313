package home.catechumen.rest.controller;


import home.catechumen.rest.config.exceptionhandler.UserNotFoundException;
import home.catechumen.rest.model.User;
import home.catechumen.rest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class AdminUserRestController {

    private final UserService userService;

    public AdminUserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> showAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{userid}")
    public User showUserById(@PathVariable("userid") Long userid) {
        User user = userService.getById(userid);
        if (user == null) {
            throw new UserNotFoundException("User not found, id: " + userid);
        }
        return user;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid) {
        User user = userService.getById(userid);
        if (user == null) {
            throw new UserNotFoundException("no users found, id:" + userid);
        }
        userService.delete(userid);
    }
}
