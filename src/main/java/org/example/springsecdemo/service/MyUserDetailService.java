package org.example.springsecdemo.service;

import org.example.springsecdemo.model.User;
import org.example.springsecdemo.model.UserPrinciple;
import org.example.springsecdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user==null){
            System.out.println("Sytem 404");
            throw new UsernameNotFoundException("Sytem 404");
        }
        return new UserPrinciple(user);
    }
}
