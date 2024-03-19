package com.example.JWT.JWT.controller;

import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/security")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @GetMapping
    public ResponseEntity<String> showData() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/get")
    public List<JwtModel> getRecord()
    {
        return tokenService.recordGet();
    }
    @PostMapping("/save")
    public JwtModel saveRecord(@RequestBody JwtModel jwtModel)
    {
        return tokenService.recordSave(jwtModel);
    }

    @PutMapping("/update/{user_id}")
    public JwtModel updateRecord(@PathVariable(value = "user_id") Integer user_id,
                                 @RequestBody JwtModel jwtModel)
    {
        return tokenService.recordUpdate(user_id,jwtModel);
    }

    @DeleteMapping("/delete/{user_id}")
    public String deleteData(@PathVariable(value = "user_id") Integer user_id)
    {
        return tokenService.recordDelete(user_id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll()
    {
        return tokenService.deleteAll();
    }
}