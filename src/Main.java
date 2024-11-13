import java.util.Scanner;

import BookingManager.BookingManager;

public class Main {
    private static Scanner Scanner = new Scanner(System.in);
    private static BookingManager bookingManager = new BookingManager();

    public static void main(String[] args) {
        // Hiển thị menu lựa chọn
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Tạo đặt phòng mới");
            System.out.println("2. Thống kê doanh thu theo roomType");
            System.out.println("3. Hiển thị loại phòng có doanh thu lớn nhất trong năm 2023");
            System.out.println("4. Thoát");
            System.out.print("Chọn một chức năng: ");

            // Đọc lựa chọn từ người dùng
            choice = Scanner.nextInt();
            Scanner.nextLine(); // Đọc dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    // Tạo đặt phòng mới
                    System.out.println("Tạo đặt phòng mới...");
                    BookingManager.createBooking();
                    break;

                case 2:
                    // Thống kê doanh thu theo roomType
                    System.out.println("Thống kê doanh thu theo roomType...");
                    BookingManager.displayRevenueByRoomType();
                    break;

                case 3:
                    // Hiển thị loại phòng có doanh thu lớn nhất trong năm 2023
                    System.out.println("Hiển thị loại phòng có doanh thu lớn nhất trong năm 2023...");
                    BookingManager.displayRoomTypeWithHighestRevenueIn2023();
                    break;

                case 4:
                    // Thoát
                    System.out.println("Thoát khỏi chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 4);  // Lặp lại menu cho đến khi chọn "Thoát"
    }
}
