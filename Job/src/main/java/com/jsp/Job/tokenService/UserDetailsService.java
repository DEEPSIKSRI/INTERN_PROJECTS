package com.jsp.Job.tokenService;

import com.jsp.Job.entity.User;
import com.jsp.Job.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        User user = userRepository.findByUsername ( username );

        Set < GrantedAuthority > authorities = new HashSet <> ( );
        authorities.add ( new SimpleGrantedAuthority ( "ROLE" + user.getRole ( ) ) );

        return org.springframework.security.core.userdetails.User.withUsername ( user.getUsername ( ) )
                .password ( user.getPassword ( ) )
                .authorities ( authorities )
                .accountExpired ( true )
                .credentialsExpired ( true )
                .credentialsExpired ( true )
                .disabled ( true )
                .build ( );
    }
}