import model.Airplane;
import model.Seat;
import model.SeatType;

public class SeatManager {

    public String returnSeat(Airplane airplane){

        //se o avião estiver totalmente vazio, retorna o primeiro assento
        if(airplane.getSeatList().stream().allMatch(Seat::isAvailable)) return "1A";

        //retorna a primeira janela disponivel caso já tenha algum assento ocupado
        for(Seat seat:airplane.getSeatList()) {
            if(seat.getType() == SeatType.WINDOW && seat.isAvailable()) return seat.getId();
        }

        //retorna o assento do corretor da primeira fila quando não existir janela disponível
        if(airplane.getSeatList().stream().noneMatch(seat -> (seat.getType().equals(SeatType.WINDOW) && seat.isAvailable()))
        && airplane.getSeatList().stream().allMatch(seat -> (seat.getType().equals(SeatType.AISLE) && seat.isAvailable()))) return "1B";

        //retorna o primeiro assento livre depois que todas as janelas estao ocupadas e o 1B também
        for(Seat seat:airplane.getSeatList()) {
            if(seat.isAvailable()) return seat.getId();
        }

        return "0";
    }
}
