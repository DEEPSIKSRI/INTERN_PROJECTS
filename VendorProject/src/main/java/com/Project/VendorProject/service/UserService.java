package com.Project.VendorProject.service;
import com.Project.VendorProject.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
     List<User> getRecord();

     User saveUserData(User user);

     User updateUserData(String email_id,User user);

     String deleteUserData(String emailId);
}
