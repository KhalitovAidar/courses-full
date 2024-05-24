package ru.itis.service;

import ru.itis.dto.JwtAuthenticationResponseDTO;
import ru.itis.dto.SignInDTO;
import ru.itis.dto.SignUpDTO;
import ru.itis.enums.Role;
import ru.itis.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponseDTO signUp(SignUpDTO signUpDTO) {
        User user = User.builder()
                .username(signUpDTO.getUsername())
                .email(signUpDTO.getEmail())
                .password(signUpDTO.getPassword())
                .role(Role.ROLE_USER)
                .build();

        userService.create(user);

        String jwtToken = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDTO(jwtToken);
    }

    public JwtAuthenticationResponseDTO signIn(SignInDTO signInDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInDTO.getUsername(),
                        signInDTO.getPassword()
                )
        );

        // TODO var it's bad practice
        var user = userService.userDetailsService().loadUserByUsername(signInDTO.getUsername());
        String jwtToken = jwtService.generateToken(user);

        return new JwtAuthenticationResponseDTO(jwtToken);
    }
}
