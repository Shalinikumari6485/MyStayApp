/**
 * Use Case 9: Error Handling & Validation
 */

import java.util.*;
public class BookMyStayApp {
    static class InvalidBookingException extends Exception {
        public InvalidBookingException(String message) {
            super(message);
        }
    }

    static class RoomInventory {
        private Map<String, Integer> availability;
        public RoomInventory() {
            availability = new HashMap<>();
            availability.put("Single", 2);
            availability.put("Double", 1);
            availability.put("Suite", 1);
        }
        public boolean isValidRoomType(String type) {
            return availability.containsKey(type);
        }
    }

    static class ReservationValidator {
        public void validate(String guestName, String roomType, RoomInventory inventory)
                throws InvalidBookingException {

            if (guestName == null || guestName.trim().isEmpty()) {
                throw new InvalidBookingException("Guest name cannot be empty.");
            }
            if (!inventory.isValidRoomType(roomType)) {
                throw new InvalidBookingException("Invalid room type selected.");
            }
        }
    }
    static class BookingRequestQueue {
        private Queue<String> queue = new LinkedList<>();

        public void add(String request) {
            queue.offer(request);
        }
    }

    public static void main(String[] args) {

        System.out.println("Booking Validation");
        Scanner scanner = new Scanner(System.in);
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String type = scanner.nextLine();
            validator.validate(name, type, inventory);
            bookingQueue.add(name + " - " + type);

            System.out.println("Booking request added successfully.");

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
