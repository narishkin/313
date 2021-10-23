package home.catechumen.rest.controller;

import home.catechumen.rest.config.exceptionhandler.UserNotFoundException;
import home.catechumen.rest.model.User;
import home.catechumen.rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> showAllUsers() {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/{userid}")
    public ResponseEntity<User> showUserById(@PathVariable("userid") Long userid) {
        User user = userService.getById(userid);
        if (user == null) {
            throw new UserNotFoundException("User not found, id: " + userid);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        System.out.println(user);
        userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userid") Long userid) {
        User user = userService.getById(userid);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
