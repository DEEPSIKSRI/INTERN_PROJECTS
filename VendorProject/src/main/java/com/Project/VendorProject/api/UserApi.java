package com.Project.VendorProject.api;

import com.Project.VendorProject.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public interface UserApi {
    @GetMapping(value = "/get")
     List<User> getData(List<User> users2);

    @PostMapping("/save")
    User saveUser(@RequestBody User user);

    @PutMapping("/update/{email_id}")
    User updateUser(@PathVariable (value = "email_id") String email_id,
                    @RequestBody User user);

    @DeleteMapping("/delete/{email_id}")
    String deleteUser(@PathVariable (value = "email_id") String email_id);


}
