package itvdn.todolist.controllers;

import itvdn.todolist.domain.Todo;
import itvdn.todolist.domain.User;
import itvdn.todolist.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result = userService.createUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User result = userService.getUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
