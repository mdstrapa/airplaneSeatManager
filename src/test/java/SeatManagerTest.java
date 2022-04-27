import model.Airplane;
import model.Seat;
import model.SeatType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatManagerTest {

    SeatManager seatManager = new SeatManager();

    @Test
    public void should_Return_First_Window_Available_Empty_Airplane(){
        Airplane airplane = new Airplane();

        String seat = seatManager.returnSeat(airplane);

        assertEquals("1A",seat);
    }

    private Airplane makeOneWindowAvailable(Airplane airplane){
        for (Seat seat:airplane.getSeatList()) {
            if(seat.getType() == SeatType.WINDOW && !seat.getId().equals("8A")) seat.setAvailable(false);
        }
        return airplane;
    }



    @Test
    public void should_Return_Last_Window_Available(){
        Airplane airplane = new Airplane();
        makeOneWindowAvailable(airplane);

        String seat = seatManager.returnSeat(airplane);

        assertEquals("8A",seat);
    }

    private Airplane makeNoWindowAvailable(Airplane airplane){
        for (Seat seat:airplane.getSeatList()) {
            if(seat.getType() == SeatType.WINDOW) seat.setAvailable(false);
        }
        return airplane;
    }

    @Test
    public void should_Return_First_Aisle_Available(){
        Airplane airplane = new Airplane();
        makeNoWindowAvailable(airplane);

        String seat = seatManager.returnSeat(airplane);

        assertEquals("1B",seat);
    }

    private Airplane makeOneSeatAvailable(Airplane airplane){
        for (Seat seat:airplane.getSeatList()) {
            if(!seat.getId().equals("6C")) seat.setAvailable(false);
        }
        return airplane;
    }

    @Test
    public void should_Return_Last_Available_Seat(){
        Airplane airplane = new Airplane();
        makeOneSeatAvailable(airplane);

        String seat = seatManager.returnSeat(airplane);

        assertEquals("6C",seat);
    }

    private Airplane makeNoSeatAvailable(Airplane airplane){
        for (Seat seat:airplane.getSeatList()) {
            seat.setAvailable(false);
        }
        return airplane;
    }

    @Test
    public void should_Return_Seat_Not_Available_Full_Airplane(){
        Airplane airplane = new Airplane();
        makeNoSeatAvailable(airplane);

        String seat = seatManager.returnSeat(airplane);

        assertEquals("0",seat);
    }
}