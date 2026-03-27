package backend.application.tp_module.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDto {
    private String email;
    private String userName;
    private Date createdAt;
}