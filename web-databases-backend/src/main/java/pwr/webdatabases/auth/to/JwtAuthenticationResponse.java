package pwr.webdatabases.auth.to;

import pwr.webdatabases.auth.data.model.Role;

public class JwtAuthenticationResponse {

    private String token;
    private Long userId;
    private Role role;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
