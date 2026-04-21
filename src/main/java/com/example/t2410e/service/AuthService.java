package com.example.t2410e.service;

import com.example.t2410e.dto.auth.LoginReq;
import com.example.t2410e.dto.auth.LoginResponse;
import com.example.t2410e.dto.auth.RegisterReq;
import com.example.t2410e.entity.User;
import com.example.t2410e.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public Boolean register(RegisterReq input){
        User user = new User();
        user.setEmail(input.getEmail());
        user.setFullName(input.getFullName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        userRepository.save(user);
        return Boolean.TRUE;
    }

    public User authenticate(LoginReq input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        User user = userRepository.findByEmail(input.getEmail());
        if(user == null)
            throw new UsernameNotFoundException("" +
                    "Email or password is not correct");
        return user;
    }

    public LoginResponse login(LoginReq input){
        User user = authenticate(input);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse lg = new LoginResponse();
        lg.setToken(jwtToken);
        return lg;
    }
}
