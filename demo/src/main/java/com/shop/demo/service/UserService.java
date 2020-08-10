package com.shop.demo.service;

import com.shop.demo.model.User;
import com.shop.demo.model.Role;
import com.shop.demo.repository.UserRepository;
import com.shop.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        Set<Role> defaultRole = new HashSet<>();
        defaultRole.add(roleRepository.findByName(DEFAULT_ROLE));
        user.setRoles(defaultRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
