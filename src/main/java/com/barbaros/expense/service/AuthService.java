package com.barbaros.expense.service;

import com.barbaros.expense.dto.LoginDTO;
import com.barbaros.expense.dto.RegisterDTO;
import com.barbaros.expense.model.User;
import com.barbaros.expense.repository.UserRepository;
import com.barbaros.expense.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String register(RegisterDTO request) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(request.getUsername()));
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(LoginDTO request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
