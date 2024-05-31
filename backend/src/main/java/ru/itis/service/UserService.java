package ru.itis.service;

import jakarta.transaction.Transactional;
import ru.itis.dto.UserDTO;
import ru.itis.enums.Role;
import ru.itis.mapper.UserMapper;
import ru.itis.models.User;
import ru.itis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDto)
                .toList();
    }

    @Transactional
    public void deleteByUsername(String userName) {
        userRepository.deleteByUsername(userName);
    }

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
