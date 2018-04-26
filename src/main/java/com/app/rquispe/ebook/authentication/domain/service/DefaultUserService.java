package com.app.rquispe.ebook.authentication.domain.service;

import com.app.rquispe.ebook.authentication.domain.model.Role;
import com.app.rquispe.ebook.authentication.domain.model.User;
import com.app.rquispe.ebook.authentication.domain.repository.RoleRepository;
import com.app.rquispe.ebook.authentication.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class DefaultUserService implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.addRoles(Arrays.asList(userRole));
        return userRepository.save(user);
    }
}
