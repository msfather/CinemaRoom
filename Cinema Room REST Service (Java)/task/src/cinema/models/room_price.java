package cinema.models;

import lombok.Data;

import java.util.List;
public class room_price {
    private int total_rows;
    private int total_columns;
    private List<seat_price> available_seats;

    public room_price(int total_rows, int total_columns, List<seat_price> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<seat_price> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<seat_price> available_seats) {
        this.available_seats = available_seats;
    }
}
