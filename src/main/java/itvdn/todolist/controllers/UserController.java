package itvdn.todolist.controllers;

import itvdn.todolist.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService)  {
        this.userService = userService;
    }

    @GetMapping(path = "/create_table")
    public ResponseEntity<String> getTest() {
        userService.createTableUser();
        return new ResponseEntity<>("Table has been created", HttpStatus.OK);
    }


}
