package ru.itis.service;

import ru.itis.enums.Role;
import ru.itis.models.User;
import ru.itis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private User save(User user) {
        return userRepository.save(user);
    }

    public User create(User user) {
        // TODO: AOP
        if (userRepository.existsByUsername(user.getUsername())) {
            // throw
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            // throw
        }

        return save(user);
    }

    public User getByUsername(String username) {
        // TODO throw
        return userRepository.findByUsername(username)
                .orElseThrow();
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}
