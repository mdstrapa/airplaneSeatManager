package model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private List<Seat> seatList;

    public Airplane(){
        this.seatList = new ArrayList<>();
        for(int c = 1;c < 15;c++){
            this.seatList.add(new Seat(SeatType.WINDOW,c + "A",true));
            this.seatList.add(new Seat(SeatType.AISLE,c + "B",true));
            this.seatList.add(new Seat(SeatType.AISLE,c + "C",true));
            this.seatList.add(new Seat(SeatType.WINDOW,c + "D",true));
        }
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
