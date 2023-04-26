package cinema.models;

import java.util.ArrayList;
import java.util.List;

public class returned_ticket {
    seat_price returned_ticket;

    public seat_price getReturned_ticket() {
        return returned_ticket;
    }

    public returned_ticket(seat_price returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public void setReturned_ticket(seat_price returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
