package cinema.services;

import cinema.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RoomService_price {
    public static final int ROOM_END = 9;
    public static final int ROOM_START = 9;
    public static final int PRICE_SEAT = 10;
    public static final int PRICE_SEAT1 = 8;
    List<seat_price> available_seats = new ArrayList<>();
    List<Boolean> check = new ArrayList<>();
    List<room_token> token = new ArrayList<>();

    public RoomService_price() {
        for (int r = 1; r <= ROOM_END; r++) {
            for (int c = 1; c <= ROOM_END; c++) {
                if (r <= 4)
                    available_seats.add(new seat_price(r, c, PRICE_SEAT));
                else
                    available_seats.add(new seat_price(r, c, PRICE_SEAT1));
                check.add(false);
                token.add(new room_token(UUID.randomUUID()));
            }
        }
    }

    public room_price getRoom_price() {
        return new room_price(ROOM_START, ROOM_END, available_seats);
    }

    public seat_price get_roo_price(seat s) throws ResponseStatusException {

        for (int i = 0; i < available_seats.size(); i++) {
            if (s.getRow() == available_seats.get(i).getRow() && s.getColumn() == available_seats.get(i).getColumn() && check.get(i) == false) {
                check.set(i, true);
                return available_seats.get(i);
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "xyz");

    }

    public boolean checkBounds(seat s) {
        return s.getRow() <= ROOM_END && s.getRow() >= 1 && s.getColumn() <= ROOM_END && s.getColumn() >= 1;
    }

    public seat_purchase get_room_price(seat s) {
        for (int i = 0; i < available_seats.size(); i++) {
            if (s.getRow() == available_seats.get(i).getRow() && s.getColumn() == available_seats.get(i).getColumn() && check.get(i) == false) {
                token.set(i, new room_token(UUID.randomUUID()));
                check.set(i, true);
                return new seat_purchase(token.get(i).getToken(), available_seats.get(i));
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "xyz");
    }

    public returned_ticket get_room_token(room_token s) {

        for (int i = 0; i < token.size(); i++) {
            if (token.get(i).getToken().equals(s.getToken()) && check.get(i) == true) {
                check.set(i, false);
                return new returned_ticket(available_seats.get(i));
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "xyz");
    }

    public income getstats(String password) {
        if (password.equals("super_secret")) {
            int current_income = 0;
            int number_of_available_seats = 0;
            int number_of_purchased_tickets = 0;
            for (int i = 0; i < check.size(); i++) {
                if (check.get(i) == false)
                    number_of_available_seats++;
                else {
                    current_income += available_seats.get(i).getPrice();
                    number_of_purchased_tickets++;
                }
            }
            return new income(current_income, number_of_available_seats, number_of_purchased_tickets);
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "xyz");
    }
}

