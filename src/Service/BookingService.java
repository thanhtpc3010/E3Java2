package Service;

import Entity.Booking;
import Entity.roomType;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.List;

public class BookingService implements IGeneral<Booking> {
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public void add(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public Booking getById(String id) {
        return bookings.stream()
                .filter(b -> String.valueOf(b.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        bookings.removeIf(b -> String.valueOf(b.getId()).equals(id));
    }

    @Override
    public List<Booking> getAll() {
        return bookings;
    }

    public double calculateRevenueByRoomType(roomType roomType) {
        return bookings.stream()
                .filter(b -> b.getRoomid().getRoomType() == roomType)
                .mapToDouble(b -> {
                    long hours = java.time.Duration.between(b.getCheckIn(), b.getCheckOut()).toHours();
                    return hours * b.getRoomid().getPrice_per_hour();
                })
                .sum();
    }
}

