package com.example.blogger.controller;

import com.example.blogger.entity.Role;
import com.example.blogger.entity.User;
import com.example.blogger.payload.JWTAuthResponse;
import com.example.blogger.payload.LoginDto;
import com.example.blogger.payload.SignUpDto;
import com.example.blogger.repository.RoleRepository;
import com.example.blogger.repository.UserRepository;
import com.example.blogger.security.JwtTokenProvider;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Getter
@Setter
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;



    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto
                                                                    loginDto) {
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTAuthResponse(token));

    }
        @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email id exist :"+signUpDto.getEmail(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepository.existsByUsername(signUpDto.getUsername())){
                return new ResponseEntity<>("Username exist :"+signUpDto.getUsername(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        User savedUser = userRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }
}
