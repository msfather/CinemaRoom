package cinema.controller;

import cinema.models.*;
import cinema.services.RoomService;
import cinema.services.RoomService_price;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.UUID;

@RestController
public class SeatController {
    private final RoomService roomService;
    private  final RoomService_price roomService_price;
    public SeatController(RoomService roomService, RoomService_price roomServicePrice) {
        this.roomService = roomService;
        this.roomService_price = roomServicePrice;
    }

   /*@GetMapping("/seats")
    public room getRoom() {
    return roomService.getRoom();
    }
*/
    @GetMapping("/seats")
    public  room_price getRoom_price(){
        return roomService_price.getRoom_price();
    }
 /*
    @PostMapping("/purchase")
    public ResponseEntity<?> get_roo_price(@RequestBody seat st){
        if(!roomService_price.checkBounds(st)){
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
        try{
            seat_price sp = roomService_price.get_roo_price(st);return new ResponseEntity<>(sp, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        }
    }
*/
    @PostMapping("/purchase")
    public ResponseEntity<?> get_room_purchase(@RequestBody seat st){
        if(!roomService_price.checkBounds(st)){
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
        try {
            seat_purchase s = roomService_price.get_room_price(st);
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/return")
    public ResponseEntity<?>  get_room_token(@RequestBody room_token token){
       // returned_ticket s=roomService_price.get_room_token(token);
        try{
            returned_ticket s=roomService_price.get_room_token(token);
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/stats")
    public ResponseEntity<?>getstats(@RequestParam (required = false) String password){
        if(password==null)
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
            try {
                income s = roomService_price.getstats(password);
                return new ResponseEntity<>(s, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
            }
    }
}
