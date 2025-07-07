package com.ashiqsyed.jbtrckr.controller;

import com.ashiqsyed.jbtrckr.config.JwtUtility;
import com.ashiqsyed.jbtrckr.dto.AuthResponse;
import com.ashiqsyed.jbtrckr.dto.LoginAuthRequest;
import com.ashiqsyed.jbtrckr.dto.SignupAuthRequest;
import com.ashiqsyed.jbtrckr.dto.UserDTO;
import com.ashiqsyed.jbtrckr.mapper.UserMapper;
import com.ashiqsyed.jbtrckr.model.User;
import com.ashiqsyed.jbtrckr.repository.UserRepository;
import com.ashiqsyed.jbtrckr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupAuthRequest req) {
//        User savedUser = userService.insertUser(user.getUsername(), user.getEmail(), user.getPassword());
            userService.insertUser(req.getUsername(), req.getEmail(), req.getPassword());
//        return ResponseEntity.ok(new UserDTO(savedUser.getEmail(), savedUser.getPassword(), savedUser.getId()));
        return ResponseEntity.status(201).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginAuthRequest req) {

        //checks if user even exists. if it doesn't then say incorrect login information
        User user = userService.getUserByEmail(req.getEmail());

        //user exists but now checking passwords. if passwords don't match, throw error
        if (user == null || !passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Login Information");
        }
        String token = jwtUtility.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername()));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> me(Authentication auth) {
        User user = (User) auth.getPrincipal();
        UserDTO userDto = UserMapper.toDto(user);
        return ResponseEntity.ok(new UserDTO(user.getEmail(), user.getPassword(), user.getId()));
    }
}
