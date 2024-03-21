package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.User;
import com.jsp.Job.repository.UserRepository;
import com.jsp.Job.repository.service.UserServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRepoServiceImpl implements UserServiceRepo {

    private final UserRepository userRepository;
    @Override
    public boolean existsByUsername ( String username ) {
       return userRepository.existsByUsername ( username );
    }

    @Override
    public void save ( User user ) {
      userRepository.save ( user );
    }

    @Override
    public User findByUsername ( String username ) {
        return userRepository.findByUsername ( username );
    }

    @Override
    public List<User> findAll ( ) {
       return userRepository.findAll ();
    }

    @Override
    public void deleteAll ( ) {
         userRepository.deleteAll ();
    }

    @Override
    public User deleteByUsername ( String username ) {
        return userRepository.deleteByUsername(username);
    }
}