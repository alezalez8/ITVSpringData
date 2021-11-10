package itvdn.todolist.controllers;

import itvdn.todolist.domain.Todo;
import itvdn.todolist.domain.User;
import itvdn.todolist.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/todo")
    public ResponseEntity<Todo> testMapping(@RequestBody Todo todo) {
        String message = "todo";
        System.out.println(message);
        return new ResponseEntity(todo, HttpStatus.OK);
    }


}
