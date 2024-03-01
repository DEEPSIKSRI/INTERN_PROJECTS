package com.Project.VendorProject.seviceTest;

import com.Project.VendorProject.model.User;
import com.Project.VendorProject.repository.UserRepository;
import com.Project.VendorProject.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void testGetRecord()
    {

        User users=new User("deepsi@gmail.com","Deepsi","1","namakkal");
        List<User> users1=new ArrayList<>();
        users1.add(users);
        when(userRepository.findAll()).thenReturn(users1);
        System.out.println("Expected-->"+users);

        List<User> users2=userServiceImpl.getRecord();
        System.out.println("actual-->"+users2);
        assertEquals(users1,users2);
    }

    @Test
    void testSaveUserData()
    {
        User users=new User("deepsi@gmail.com","Deepsi","1","namakkal");
        when(userRepository.save(users)).thenReturn(users);
        System.out.println("Expected-->"+users);

        User user=userServiceImpl.saveUserData(users);
        System.out.println("actual-->"+user);

        assertEquals(users,user);
    }

    @Test
    void testUpdateUserData()
    {
        String email_id="deepsi@gmail.com";
        User users=new User("deepsi@gmail.com","Deepsi","1","namakkal");
        User users1=new User("deepsi@gmail.com","Deepsika","1","namakkal");
        when(userRepository.findById(email_id)).thenReturn(Optional.of(users));
        when(userServiceImpl.updateUserData(email_id,users)).thenReturn(users1);

        User user1=userServiceImpl.updateUserData(email_id,users1);
        System.out.println("User"+user1);
        assertEquals(users1,user1);
    }

    @Test
    void testDeleteUser()
    {
        String email_id="deepsi@gmail.com";
        String expected="Successfully deleted";

        String actual=userServiceImpl.deleteUserData(email_id);

        assertEquals(expected,actual);

    }
}
