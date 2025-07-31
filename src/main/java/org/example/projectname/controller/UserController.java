package org.example.projectname.controller;

import lombok.RequiredArgsConstructor;
import org.example.projectname.dto.UserRequest;
import org.example.projectname.dto.UserResponse;
import org.example.projectname.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userService.findUsers();
    }

    @GetMapping("/users/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    @PutMapping("/users/{userId}")
    public UserResponse updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        return userService.update(userId, userRequest);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
