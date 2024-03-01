package com.capstone.sample_project.service.serviceImpl;

import com.capstone.sample_project.dto.ResponseDto;
import com.capstone.sample_project.entity.Skills;
import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.exception.Exception.UserNotFoundException;
import com.capstone.sample_project.repository.SkillsRepository;
import com.capstone.sample_project.repository.UserRepository;
import com.capstone.sample_project.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity< ResponseDto > getSkills ( ) {
        List<Skills> skills=skillsRepository.findAll () ;
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Retrived All the Skills",skills) );

    }

    @Override
    public ResponseEntity<ResponseDto> addSkills( Skills skills ) {
         skillsRepository.save ( skills );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Skills are Saved Successfully!",skills) );
    }

    @Override
    public ResponseEntity<ResponseDto> addUserId ( Skills skills , String userEmail ) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userEmail);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            skills.setUserId(user);
             skillsRepository.save(skills);
            return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"UserId are Saved in Skills Information Successfully!",skills) );

        } else {
            throw new UserNotFoundException ("User with email " + userEmail + " not found");
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteAllSkills ( ) {
        skillsRepository.deleteAll ();
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Skills Record is Deleted",null));
    }

    @Override
    public ResponseEntity<ResponseDto> deleteSkillsById ( Integer skillsId ) {
        skillsRepository.deleteById ( skillsId );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDto (HttpStatus.OK,"Skills Record is Deleted Based on skills_Id",null));
    }
}
