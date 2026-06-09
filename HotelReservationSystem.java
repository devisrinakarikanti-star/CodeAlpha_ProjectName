import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean available;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }
}

class Reservation {
    String customerName;
    int roomNumber;

    Reservation(String customerName, int roomNumber) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 3000));
        rooms.add(new Room(202, "Deluxe", 3000));
        rooms.add(new Room(301, "Suite", 5000));

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println(" HOTEL RESERVATION SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    viewReservations();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }

    static void displayRooms() {

        System.out.println("\nAvailable Rooms");

        System.out.println("-------------------------------------");
        System.out.println("Room\tCategory\tPrice");
        System.out.println("-------------------------------------");

        for (Room room : rooms) {
            if (room.available) {
                System.out.println(room.roomNumber + "\t"
                        + room.category + "\t\t₹"
                        + room.price);
            }
        }
    }

    static void bookRoom() {

        System.out.print("Enter Customer Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo && room.available) {

                System.out.println("\nPayment Amount: ₹" + room.price);
                System.out.println("Payment Successful!");

                room.available = false;

                reservations.add(
                        new Reservation(name, roomNo));

                System.out.println("Room Booked Successfully!");
                return;
            }
        }

        System.out.println("Room Not Available!");
    }

    static void cancelReservation() {

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        for (Reservation r : reservations) {

            if (r.roomNumber == roomNo) {

                reservations.remove(r);

                for (Room room : rooms) {
                    if (room.roomNumber == roomNo) {
                        room.available = true;
                    }
                }

                System.out.println("Reservation Cancelled!");
                return;
            }
        }

        System.out.println("Reservation Not Found!");
    }

    static void viewReservations() {

        System.out.println("\nCurrent Reservations");

        if (reservations.isEmpty()) {
            System.out.println("No Reservations Found!");
            return;
        }

        System.out.println("--------------------------------");
        System.out.println("Customer Name\tRoom No");
        System.out.println("--------------------------------");

        for (Reservation r : reservations) {
            System.out.println(r.customerName
                    + "\t\t" + r.roomNumber);
        }
    }
}