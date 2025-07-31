package org.example.projectname.service;

import lombok.RequiredArgsConstructor;
import org.example.projectname.dto.UserRequest;
import org.example.projectname.dto.UserResponse;
import org.example.projectname.entity.User;
import org.example.projectname.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse save(UserRequest userRequest){
        User savedUser = userRepository.save(new User(userRequest.getUsername(),userRequest.getPassword()));
        return new UserResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword());
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> dtos = new ArrayList<>();

        for (User user : users) {
            UserResponse userResponse = new UserResponse(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword()
            );
            dtos.add(userResponse);
        }
        return dtos;
    }

    @Transactional
    public UserResponse findUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 userID가 없습니다.")
        );
        return new UserResponse(user.getId(), user.getUsername(), user.getPassword());
    }

    @Transactional
    public UserResponse update(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 userID가 없습니다.")
        );
        user.update(userRequest.getUsername(), userRequest.getPassword());
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    @Transactional
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalArgumentException("해당하는 userID가 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
