package cinema.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class seat_purchase {
    private UUID token;
    private seat_price ticket;
    public seat_purchase(UUID token,seat_price ticket) {
        this.token = token;
        this.ticket = ticket;
    }


    public seat_price getTicket() {
        return ticket;
    }



    public void setTicket(seat_price ticket) {
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
