package com.stage.insertMarks.service;

import com.stage.insertMarks.dto.UserDto;
import com.stage.insertMarks.entity.Role;
import com.stage.insertMarks.entity.User;
import com.stage.insertMarks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long idUser) {
        return userRepository.findById(idUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByIdentifier(String identifier) {
        return userRepository.findByIdentifier(identifier);
    }
    public List<UserDto> getStudents(int grade) {
        var students = userRepository.findByRoleAndGrade(Role.STUDENT, grade);
        var users = new ArrayList<UserDto>();

        students.forEach(
                user -> users.add(buildUserDto(user))
        );

        return users;
    }


    public UserDto buildUserDto(User user) {
        return UserDto
                .builder()
                .idUser(user.getIdUser())
                .email(user.getEmail())
                .role(user.getRole().name())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .identifier(user.getIdentifier())
                .idGrade(user.getIdGrade())
                .build();
    }
}
