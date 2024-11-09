package Service;

import Entity.Room;
import Entity.roomType;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.List;

public class RoomService implements IGeneral<Room> {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public void add(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getById(String id) {
        return rooms.stream()
                .filter(room -> room.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        rooms.removeIf(room -> room.getId().equals(id));
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    public List<Room> getRoomsByType(roomType roomType) {
        List<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType() == roomType) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }
}

