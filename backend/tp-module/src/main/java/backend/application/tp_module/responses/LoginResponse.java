package backend.application.tp_module.responses;

import backend.application.tp_module.models.dto.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;
    private UserDto user;
    private long expiresIn;
}