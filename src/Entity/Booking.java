package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private int id;
    private Room roomid;
    private Customer cusid;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Booking(int id, Room roomid, Customer cusid, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.roomid = roomid;
        this.cusid = cusid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoomid() {
        return roomid;
    }

    public void setRoomid(Room roomid) {
        this.roomid = roomid;
    }

    public Customer getCusid() {
        return cusid;
    }

    public void setCusid(Customer cusid) {
        this.cusid = cusid;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", roomid=" + roomid +
                ", cusid=" + cusid +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
