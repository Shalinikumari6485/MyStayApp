/**
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 */

import java.util.*;

public class BookMyStayApp {
    static class Reservation {
        String guestName;
        String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }
    }
    static class BookingRequestQueue {
        private Queue<Reservation> queue = new LinkedList<>();

        public void addRequest(Reservation r) {
            queue.offer(r);
        }
        public Reservation getNextRequest() {
            return queue.poll();
        }
        public boolean hasRequests() {
            return !queue.isEmpty();
        }
    }
    static class RoomInventory {
        private Map<String, Integer> rooms = new HashMap<>();

        public RoomInventory() {
            rooms.put("Single", 3);
            rooms.put("Double", 2);
            rooms.put("Suite", 1);
        }

        public boolean isAvailable(String type) {
            return rooms.get(type) > 0;
        }

        public void allocate(String type) {
            rooms.put(type, rooms.get(type) - 1);
        }

        public void showInventory() {
            System.out.println("\nRemaining Inventory:");
            for (String type : rooms.keySet()) {
                System.out.println(type + ": " + rooms.get(type));
            }
        }
    }

    static class RoomAllocationService {
        private Map<String, Integer> counters = new HashMap<>();

        public String allocateRoom(Reservation r, RoomInventory inventory) {
            if (!inventory.isAvailable(r.roomType)) {
                return null;
            }
            inventory.allocate(r.roomType);
            counters.put(r.roomType, counters.getOrDefault(r.roomType, 0) + 1);
            int id = counters.get(r.roomType);
            return r.roomType + "-" + id;
        }
    }

    static class ConcurrentBookingProcessor implements Runnable {
        private BookingRequestQueue queue;
        private RoomInventory inventory;
        private RoomAllocationService service;
        public ConcurrentBookingProcessor(
                BookingRequestQueue queue,
                RoomInventory inventory,
                RoomAllocationService service) {
            this.queue = queue;
            this.inventory = inventory;
            this.service = service;
        }

        @Override
        public void run() {

            while (true) {
                Reservation r;
                synchronized (queue) {
                    if (!queue.hasRequests()) break;
                    r = queue.getNextRequest();
                }
                synchronized (inventory) {
                    String roomId = service.allocateRoom(r, inventory);
                    if (roomId != null) {
                        System.out.println("Booking confirmed for Guest: "
                                + r.guestName + ", Room ID: " + roomId);
                    } else {
                        System.out.println("No rooms available for " + r.guestName);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Concurrent Booking Simulation");

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Double"));
        queue.addRequest(new Reservation("Kural", "Suite"));
        queue.addRequest(new Reservation("Subha", "Single"));

        Thread t1 = new Thread(new ConcurrentBookingProcessor(queue, inventory, service));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(queue, inventory, service));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        inventory.showInventory();
    }
}
