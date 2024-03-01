package com.capstone.sample_project.tokenService;

import com.capstone.sample_project.entity.User;
import com.capstone.sample_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername ( String username ) throws     UsernameNotFoundException {
        User user = userRepository.findByEmail (  username );

        Set < GrantedAuthority > authorities = new HashSet <> (  );
        authorities.add ( new SimpleGrantedAuthority ( "ROLE_" +user.getRole ()) );

        return org.springframework.security.core.userdetails.User.withUsername ( user.getEmail () )
                .password ( user.getPassword () )
                .authorities ( authorities )
                .accountExpired ( true )
                .credentialsExpired ( true )
                .credentialsExpired ( true )
                .disabled ( true )
                .build ();
    }
}
