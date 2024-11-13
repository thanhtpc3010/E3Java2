package Service;

import Entity.Booking;
import Entity.roomType;
import IGeneric.IGeneral;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService implements IGeneral<Booking> {

    private Map<Integer, Booking> bookingMap = new HashMap<>();

    @Override
    public void create(Booking booking) {
        bookingMap.put(booking.getId(), booking);
        System.out.println("Đã tạo đặt phòng: " + booking);
    }

    @Override
    public Booking read(int id) {
        return bookingMap.get(id);
    }

    @Override
    public void update(Booking booking) {
        bookingMap.put(booking.getId(), booking);
        System.out.println("Đã cập nhật đặt phòng: " + booking);
    }

    @Override
    public void delete(int id) {
        bookingMap.remove(id);
        System.out.println("Đã xóa đặt phòng với ID: " + id);
    }

    // Phương thức thống kê doanh thu theo roomType trong năm 2023
    public Map<roomType, Double> getRevenueByRoomTypeIn2023() {
        return bookingMap.values().stream()
                .filter(booking -> booking.getCheckIn().getYear() == 2023)  // Lọc các booking trong năm 2023
                .collect(Collectors.groupingBy(
                        booking -> booking.getRoomid().getRoomType(),
                        Collectors.summingDouble(booking -> {
                            // Tính doanh thu cho mỗi booking
                            double hours = booking.getCheckOut().getHour() - booking.getCheckIn().getHour();
                            return hours * booking.getRoomid().getPrice_per_hour(); // Doanh thu = số giờ * giá phòng mỗi giờ
                        })
                ));
    }
    public Map<roomType, Double> getRevenueByRoomType() {
        return bookingMap.values().stream()
                .collect(Collectors.groupingBy(
                        booking -> booking.getRoomid().getRoomType(),  // Nhóm theo roomType
                        Collectors.summingDouble(booking -> {  // Tính tổng doanh thu cho mỗi loại phòng
                            double hours = booking.getCheckOut().getHour() - booking.getCheckIn().getHour();
                            return hours * booking.getRoomid().getPrice_per_hour();
                        })
                ));
    }

    // Phương thức tìm loại phòng có doanh thu lớn nhất trong năm 2023
    public roomType getRoomTypeWithHighestRevenueIn2023() {
        Map<roomType, Double> revenueByRoomType = getRevenueByRoomTypeIn2023();

        // Tìm kiếm roomType có doanh thu lớn nhất
        return revenueByRoomType.entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Lấy entry có giá trị lớn nhất
                .map(Map.Entry::getKey)  // Lấy key (roomType)
                .orElse(null); // Trả về null nếu không có dữ liệu
    }
}
