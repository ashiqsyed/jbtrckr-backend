package com.ashiqsyed.jbtrckr.service;

import com.ashiqsyed.jbtrckr.dto.UserDTO;
import com.ashiqsyed.jbtrckr.mapper.UserMapper;
import com.ashiqsyed.jbtrckr.model.User;
import com.ashiqsyed.jbtrckr.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return UserMapper.toDto(user);
        return user;

    }

    public UserDTO insertUser(String username, String email, String password) {
        if (userRepo.existsByEmail(email)) {
            throw new IllegalArgumentException("There is already a user with this email.");
        }
        if (userRepo.existsByUsername(username)) {
            throw new IllegalArgumentException("There is already a user with this username.");
        }
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, email, hashedPassword);
//        return userRepo.save(user);
        return UserMapper.toDto(userRepo.save(user));

    }
}
