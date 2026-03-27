package backend.application.tp_module.controllers;

import backend.application.tp_module.models.dto.LoginUserDto;
import backend.application.tp_module.models.dto.RegisterUserDto;
import backend.application.tp_module.models.dto.UserDto;
import backend.application.tp_module.models.entities.User;
import backend.application.tp_module.responses.LoginResponse;
import backend.application.tp_module.services.AuthenticationService;
import backend.application.tp_module.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        UserDto user = UserDto.builder()
                .email(authenticatedUser.getEmail())
                .userName(authenticatedUser.getEmail())
                .build();


        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse.builder()
                .token(jwtToken)
                .user(user)
                .expiresIn(jwtService.getExpirationTime())
                .build();

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User fetchedUserData = authenticationService.findByEmail(authentication.getName());

        UserDto user = UserDto.builder()
                .userName(fetchedUserData.getFullName())
                .email(fetchedUserData.getEmail())
                .createdAt(fetchedUserData.getCreatedAt())
                .build();

        return ResponseEntity.ok(user);
    }
}
