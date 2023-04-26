package cinema.models;

import lombok.Data;

import java.util.List;

@Data
public class room {
    private int total_rows;
    private int total_columns;
    private List<seat> available_seats;

    public room(int total_rows, int total_columns, List<seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
    }
}
