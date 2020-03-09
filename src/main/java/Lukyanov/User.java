package Lukyanov;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String fio;
    private Role role;
    public enum Role{ADMIN, USER, MODERATOR}
}
