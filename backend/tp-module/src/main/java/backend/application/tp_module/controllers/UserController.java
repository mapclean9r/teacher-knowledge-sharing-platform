package backend.application.tp_module.controllers;

import backend.application.tp_module.models.dto.UserDto;
import backend.application.tp_module.models.entities.User;
import backend.application.tp_module.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        UserDto dto = UserDto.builder()
                .userName(currentUser.getFullName())
                .email(currentUser.getEmail())
                .createdAt(currentUser.getCreatedAt())
                .build();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> allUsers() {
        List <User> users = userService.allUsers();

        List<UserDto> dto = users.stream().map(
                user ->
                    UserDto.builder()
                            .userName(user.getFullName())
                            .email(user.getEmail())
                            .createdAt(user.getCreatedAt())
                            .build()
        )
                .toList();

        return ResponseEntity.ok(dto);
    }

}