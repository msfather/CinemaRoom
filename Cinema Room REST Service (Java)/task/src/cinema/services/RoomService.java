package cinema.services;

import cinema.models.room;
import cinema.models.seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    public static final int ROOM_END = 9;
    public static final int ROOM_START = 9;


    public room getRoom() {
        List<seat> available_seats = new ArrayList<>();
        for (int r = 1; r <= ROOM_END; r++) {
            for (int c = 1; c <= ROOM_END; c++) {
                if(r<=4)
                    available_seats.add(new seat(r, c));
                else
                    available_seats.add(new seat(r, c));
            }
        }
        return new room(ROOM_START, ROOM_END, available_seats);
    }

}
