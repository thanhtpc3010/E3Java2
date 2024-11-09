import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.roomType;
import Service.BookingService;
import Service.CustomerService;
import Service.RoomService;

import java.time.LocalDate;
import java.time.LocalDateTime;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RoomService roomService = new RoomService();
        CustomerService customerService = new CustomerService();
        BookingService bookingService = new BookingService();
        Scanner scanner = new Scanner(System.in);

        // Thêm dữ liệu mẫu cho Room, Customer và Booking
        roomService.add(new Room("RS001", roomType.S, 8));
        roomService.add(new Room("RD001", roomType.D, 12));

        customerService.add(new Customer("001", "Mr. Linus Tovaldo", "84125325346457"));
        customerService.add(new Customer("002", "Mr. Bill", "91124235346467"));

        boolean exit = false;
        while (!exit) {
            System.out.println("=== MENU ===");
            System.out.println("1. Add Booking");
            System.out.println("2. Find Customer Booking");
            System.out.println("3. Calculate Revenue by RoomType");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String cusId = scanner.nextLine();
                    Customer customer = customerService.getById(cusId);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    System.out.print("Enter Room ID: ");
                    String roomId = scanner.nextLine();
                    Room room = roomService.getById(roomId);
                    if (room == null) {
                        System.out.println("Room not available!");
                        break;
                    }

                    System.out.print("Enter Check-in DateTime (yyyy-MM-dd HH:mm): ");
                    LocalDateTime checkIn = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));
                    System.out.print("Enter Check-out DateTime (yyyy-MM-dd HH:mm): ");
                    LocalDateTime checkOut = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));

                    int bookingId = bookingService.getAll().size() + 1;
                    Booking booking = new Booking(bookingId, room, customer, checkIn, checkOut);
                    bookingService.add(booking);
                    System.out.println("Booking created: " + booking);
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String cusName = scanner.nextLine();
                    System.out.print("Enter Customer Phone: ");
                    String cusPhone = scanner.nextLine();

                    bookingService.getAll().stream()
                            .filter(b -> b.getCusid().getCusName().equalsIgnoreCase(cusName) &&
                                    b.getCusid().getCusPhone().equals(cusPhone))
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Room Type (SINGLE, DOUBLE, QUEEN, TRIPLE, QUAD): ");
                    roomType roomType = Entity.roomType.valueOf(scanner.nextLine().toUpperCase());
                    double revenue = bookingService.calculateRevenueByRoomType(roomType);
                    System.out.println("Total revenue for " + roomType + " rooms: $" + revenue);
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
        scanner.close();
    }
}
