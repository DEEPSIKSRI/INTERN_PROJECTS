package com.example.JWT.JWT;
import com.example.JWT.JWT.controller.TokenController;
import com.example.JWT.JWT.model.JwtModel;
import com.example.JWT.JWT.model.Role;
import com.example.JWT.JWT.repository.UserRepository;
import com.example.JWT.JWT.service.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class JwtApplicationTests {


}

