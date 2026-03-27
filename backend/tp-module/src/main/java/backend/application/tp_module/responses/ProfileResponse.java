package backend.application.tp_module.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {
    private String username;
    private long expiresIn;
}