package com.shop.demo.service;

import com.shop.demo.model.User;
import com.shop.demo.model.Role;
import com.shop.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //make user.login unique because of exception (two the same login)
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByLogin(login);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(),
                    user.getPassword(),
                    convertAuthorities(user.getRoles())
            );
        } else {
            throw new UsernameNotFoundException("User not found");

        }

       /* User user = userRepository.findByLogin(login);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        } else {
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(),
                    user.getPassword(),
                    convertAuthorities(user.getRoles()));
        }*/
    }

    private Set<GrantedAuthority> convertAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return authorities;
    }
}
