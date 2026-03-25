/**
 * Use Case 7:Add-On Service Selection
 */

import java.util.*;

public class BookMyStayApp {

    static class AddOnService {
        private String serviceName;
        private double cost;

        public AddOnService(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        public String getServiceName() {
            return serviceName;
        }

        public double getCost() {
            return cost;
        }
    }

    static class AddOnServiceManager {

        private Map<String, List<AddOnService>> servicesByReservation;

        public AddOnServiceManager() {
            servicesByReservation = new HashMap<>();
        }

        public void addService(String reservationId, AddOnService service) {
            servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
            servicesByReservation.get(reservationId).add(service);
        }

        public double calculateTotalServiceCost(String reservationId) {
            double total = 0;

            List<AddOnService> services = servicesByReservation.get(reservationId);

            if (services != null) {
                for (AddOnService s : services) {
                    total += s.getCost();
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        String reservationId = "Single-1";

        AddOnServiceManager manager = new AddOnServiceManager();
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1000);

        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
