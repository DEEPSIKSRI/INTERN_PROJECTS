package com.Project.VendorProject.service.implementation;

import com.Project.VendorProject.exception.ResourceNotFoundException;
import com.Project.VendorProject.model.User;
import com.Project.VendorProject.repository.UserRepository;
import com.Project.VendorProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getRecord() {
    return userRepository.findAll();
}
     @Override
     public User saveUserData(User user)
        {
            return userRepository.save(user);
        }

        @Override
        public User updateUserData(String email_id, User user)
        {
            User oldUser=userRepository.findById(email_id).orElseThrow(()->new ResourceNotFoundException("User not found"));
            oldUser.setEmp_No(user.getEmp_No());
            oldUser.setEmail_id(user.getEmail_id());
            oldUser.setName(user.getName());
            oldUser.setDesignation(user.getDesignation());
            return userRepository.save(oldUser);

        }

    @Override
    public String deleteUserData(String emailId) {
         userRepository.deleteById(emailId);
         return "Successfully deleted";
    }
}

