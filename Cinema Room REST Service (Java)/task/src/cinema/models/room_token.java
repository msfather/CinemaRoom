package cinema.models;

import lombok.Data;

import java.util.UUID;

public class room_token {
    private UUID token;

    public UUID getToken() {
        return token;
    }
    public room_token() {
    }
    public room_token(UUID token) {
        this.token = token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
