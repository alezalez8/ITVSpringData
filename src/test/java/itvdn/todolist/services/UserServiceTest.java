package itvdn.todolist.services;


import itvdn.todolist.domain.PlainObjects.UserPojo;
import itvdn.todolist.domain.User;
import itvdn.todolist.services.interfaces.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private final String EMAIL = "email";
    private final String PASSWORD = "password";

    private ApplicationContext applicationContext;
    private IUserService userService;

    @Before
    public void init() {
        this.applicationContext = new ClassPathXmlApplicationContext("/mainTest.xml");
        this.userService = applicationContext.getBean("userService", IUserService.class);
    }

    @After
    public void cleanDB() {
        userService.getAllUsers().forEach(userPojo -> userService.deleteUser(userPojo.getId()));
    }

    @Test
    public void createUserTest() {
        User newUser = new User();
        newUser.setEmail(EMAIL);
        newUser.setPassword(PASSWORD);

        UserPojo actual = userService.createUser(newUser);

        assertEquals(EMAIL, actual.getEmail());
        assertEquals(PASSWORD, actual.getPassword());
        assertNotNull(actual.getId());
    }

    @Test
    public void deleteUserTest() {
        User newUser = new User();
        newUser.setEmail(EMAIL);
        newUser.setPassword(PASSWORD);

        UserPojo actual = userService.createUser(newUser);
        List<UserPojo> userAfterCreate = userService.getAllUsers();
        assertEquals(1, userAfterCreate.size());

        userService.deleteUser(actual.getId());

       // userService.getAllUsers().forEach(userPojo -> userService.deleteUser(userPojo.getId()));
        List<UserPojo> userListAfterDelete = userService.getAllUsers();
        assertEquals(0, userListAfterDelete.size());

    }


}
