package net.codejava.service;

import net.codejava.details.MyUserDetails;
import net.codejava.entity.User;
import net.codejava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userByUsername = userRepository.getUserByUsername(username);
        if (userByUsername == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(userByUsername);
    }
}
