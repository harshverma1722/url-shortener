package com.url.shortener.service;

import com.url.shortener.models.User;
import com.url.shortener.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository; // This repository will do the job of interacting with User model
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // This method loads the user data from the database and converts it into object that spring security will understand
        User user = userRepository.findByUsername(username) // findByUsername will be automatically provided by the Jpa
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: "+ username));
        return UserDetailsImpl.build(user);


    }
}
