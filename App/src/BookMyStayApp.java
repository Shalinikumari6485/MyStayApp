/**
 * Use Case 6:Reservation Confirmation & Room Allocation
 */

import java.util.*;

public class BookMyStayApp {
    static class Reservation {
        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
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
        public int getAvailable(String type) {
            return availability.getOrDefault(type, 0);
        }
        public void decrease(String type) {
            availability.put(type, availability.get(type) - 1);
        }
    }

    static class BookingRequestQueue {
        private Queue<Reservation> queue = new LinkedList<>();

        public void add(Reservation r) {
            queue.offer(r);
        }

        public Reservation next() {
            return queue.poll();
        }

        public boolean hasRequests() {
            return !queue.isEmpty();
        }
    }

    static class RoomAllocationService {

        private Set<String> allocatedRoomIds = new HashSet<>();
        private Map<String, Integer> roomCounters = new HashMap<>();

        public void allocateRoom(Reservation r, RoomInventory inventory) {
            String type = r.getRoomType();
            if (inventory.getAvailable(type) > 0) {

                String roomId = generateRoomId(type);

                allocatedRoomIds.add(roomId);
                inventory.decrease(type);

                System.out.println("Booking confirmed for Guest: "
                        + r.getGuestName() + ", Room ID: " + roomId);
            } else {
                System.out.println("No rooms available for " + type + " for Guest: " + r.getGuestName());
            }
        }
        private String generateRoomId(String type) {
            int count = roomCounters.getOrDefault(type, 0) + 1;
            roomCounters.put(type, count);
            return type + "-" + count;
        }
    }

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.add(new Reservation("Abhi", "Single"));
        queue.add(new Reservation("Subha", "Single"));
        queue.add(new Reservation("Vanmathi", "Suite"));

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();
        while (queue.hasRequests()) {
            Reservation r = queue.next();
            service.allocateRoom(r, inventory);
        }
    }
}
