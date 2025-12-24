package com.Unique.SpringSecurityApp3.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Unique.SpringSecurityApp3.Entity.User;
import com.Unique.SpringSecurityApp3.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository uRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user=uRepository.findByUsername(username)
                  .orElseThrow(()->new UsernameNotFoundException("User not Found"));

            return
               org.springframework.security.core.userdetails.User
                          .withUsername(user.getUsername())
                          .password(user.getPassword()) 
                          .roles("USER")
                          .build(); 
    }

}
