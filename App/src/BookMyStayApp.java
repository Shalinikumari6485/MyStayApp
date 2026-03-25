/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 */

import java.util.*;

public class BookMyStayApp {
    static class RoomInventory {
        private Map<String, Integer> availability;

        public RoomInventory() {
            availability = new HashMap<>();
            availability.put("Single", 5);
            availability.put("Double", 3);
            availability.put("Suite", 2);
        }

        public void incrementRoom(String type) {
            availability.put(type, availability.get(type) + 1);
        }

        public int getAvailability(String type) {
            return availability.get(type);
        }
    }

    static class CancellationService {

        private Stack<String> releasedRoomIds;
        private Map<String, String> reservationRoomTypeMap;
        public CancellationService() {
            releasedRoomIds = new Stack<>();
            reservationRoomTypeMap = new HashMap<>();
        }
        public void registerBooking(String reservationId, String roomType) {
            reservationRoomTypeMap.put(reservationId, roomType);
        }
        public void cancelBooking(String reservationId, RoomInventory inventory) {
            if (!reservationRoomTypeMap.containsKey(reservationId)) {
                System.out.println("Invalid reservation ID.");
                return;
            }

            String roomType = reservationRoomTypeMap.get(reservationId);

            releasedRoomIds.push(reservationId);
            inventory.incrementRoom(roomType);
            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
            reservationRoomTypeMap.remove(reservationId);
        }
        public void showRollbackHistory() {
            System.out.println("\nRollback History (Most Recent First):");
            for (String id : releasedRoomIds) {
                System.out.println("Released Reservation ID: " + id);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();
        service.registerBooking("Single-1", "Single");
        service.cancelBooking("Single-1", inventory);
        service.showRollbackHistory();
        System.out.println("\nUpdated Single Room Availability: " +
                inventory.getAvailability("Single"));
    }
}

