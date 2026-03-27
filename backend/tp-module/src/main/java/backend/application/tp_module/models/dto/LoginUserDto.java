package backend.application.tp_module.models.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;
}