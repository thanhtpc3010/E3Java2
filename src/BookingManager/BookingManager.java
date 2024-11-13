package BookingManager;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.roomType;
import Service.BookingService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BookingManager {

    private static Scanner scanner = new Scanner(System.in);
    private static BookingService bookingService = new BookingService();

    // Phương thức để tạo một Booking mới
    public static void createBooking() {
        System.out.print("Nhập tên khách hàng: ");
        String customerName = scanner.nextLine();

        System.out.print("Nhập số điện thoại khách hàng: ");
        String customerPhone = scanner.nextLine();

        // Chọn loại phòng
        roomType roomType = selectRoomType();

        // Nhập giá mỗi giờ
        System.out.print("Nhập giá mỗi giờ cho phòng: ");
        double pricePerHour = scanner.nextDouble();
        scanner.nextLine(); // Clear newline

        // Tạo đối tượng Room và Customer
        Room room = new Room(1, roomType, pricePerHour);
        Customer customer = new Customer(1, customerName, customerPhone);

        // Nhập thời gian check-in và check-out
        System.out.print("Nhập thời gian check-in (YYYY-MM-DD HH:MM): ");
        String checkInStr = scanner.nextLine();
        LocalDateTime checkIn = LocalDateTime.parse(checkInStr.replace(" ", "T"));

        System.out.print("Nhập thời gian check-out (YYYY-MM-DD HH:MM): ");
        String checkOutStr = scanner.nextLine();
        LocalDateTime checkOut = LocalDateTime.parse(checkOutStr.replace(" ", "T"));

        // Tạo Booking và lưu trữ thông qua BookingService
        Booking booking = new Booking(1, room, customer, checkIn, checkOut);
        bookingService.create(booking);
    }

    // Phương thức để chọn loại phòng (RoomType)
    public static roomType selectRoomType() {
        System.out.println("Chọn loại phòng:");
        for (roomType type : roomType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống sau khi nhập số

        switch (choice) {
            case 1:
                return roomType.S;
            case 2:
                return roomType.D;
            case 3:
                return roomType.Qe;
            case 4:
                return roomType.Q;
            case 5:
                return roomType.T;
            default:
                System.out.println("Lựa chọn không hợp lệ, mặc định chọn Single.");
                return roomType.S;
        }
    }

    // Phương thức để hiển thị thống kê doanh thu theo roomType
    public static void displayRevenueByRoomType() {
        bookingService.getRevenueByRoomType().forEach((roomType, revenue) -> {
            System.out.println(roomType + ": " + revenue + " VND");
        });
    }

    // Phương thức để hiển thị loại phòng có doanh thu lớn nhất trong năm 2023
    public static void displayRoomTypeWithHighestRevenueIn2023() {
        roomType roomType = bookingService.getRoomTypeWithHighestRevenueIn2023();

        if (roomType != null) {
            System.out.println("Loại phòng có doanh thu lớn nhất trong năm 2023 là: " + roomType);
        } else {
            System.out.println("Không có dữ liệu doanh thu cho năm 2023.");
        }
    }
}
