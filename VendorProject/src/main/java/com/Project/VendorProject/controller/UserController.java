package com.Project.VendorProject.controller;

import com.Project.VendorProject.api.UserApi;
import com.Project.VendorProject.model.User;
import com.Project.VendorProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserApi{
    @Autowired
    UserApi userApi;
    @Autowired
    UserService userService;

   @Override
   public List<User> getData(List<User> users2)
   {
     return userService.getRecord();
   }

    @Override
    public User saveUser(User user) {
        return userService.saveUserData(user);
    }
    @Override
    public User updateUser(String email_id,User user)
 {
     return userService.updateUserData(email_id,user);
 }
    @Override
    public String deleteUser(String email_id)
 {
     return userService.deleteUserData(email_id);
 }
}
