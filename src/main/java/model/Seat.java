package model;

public class Seat {
    private SeatType type;
    private String id;
    private boolean available;

    public Seat(SeatType type, String id, boolean available) {
        this.type = type;
        this.id = id;
        this.available = available;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
