package com.Project.VendorProject.controllerTest;

import com.Project.VendorProject.api.UserApi;
import com.Project.VendorProject.controller.UserController;
import com.Project.VendorProject.model.User;
import com.Project.VendorProject.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest

public class UserControllerTest {

    @Mock
    private UserApi userApi;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetData()
    {
        User users=new User("deepsi@gmail.com","Deepsi","1","namakkal");
        List<User> users1=new ArrayList<>();
        users1.add(users);
        when(userService.getRecord()).thenReturn(users1);

        List<User> users2=userController.getData(users1);
        assertEquals(users1,users2);
    }
    @Test
    void testSaveUser()
    {
        User users=new User("deepsi@gmail.com","Deepsi","1","namakkal");
        when(userService.saveUserData(users)).thenReturn(users);

        User users1=userController.saveUser(users);
        assertEquals(users,users1);
    }

    @Test
    void testUpdateUser()
    {
        String email_id="deepsi@gmail.com";
        User user=new User("deepsi@gmail.com","Deepsi","1","namakkal");
        when(userService.updateUserData(email_id,user)).thenReturn(user);

        User user1=userController.updateUser(email_id,user);

        assertEquals(user,user1);

    }

    @Test
    void testDeleteUser()
    {
        String email_id="deepsi@gmail.com";
        when(userService.deleteUserData(email_id)).thenReturn("Successfully deleted");

        String actual=userController.deleteUser(email_id);
        when(userApi.deleteUser(email_id)).thenReturn(actual);

        assertEquals("Successfully deleted",actual);

    }
}
