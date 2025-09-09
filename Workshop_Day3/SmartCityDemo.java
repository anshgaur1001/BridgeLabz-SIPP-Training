import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class SmartCityDemo {

    static class Location {
        final String name;
        final double lat;
        final double lon;
        Location(String name, double lat, double lon) {
            this.name = name;
            this.lat = lat;
            this.lon = lon;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    static class Trip {
        final String serviceId;
        final String route;
        final Location from;
        final Location to;
        final LocalDateTime departure;
        final double fare;
        final boolean isPeak;
        final boolean emergency;
        Trip(String serviceId, String route, Location from, Location to, LocalDateTime departure, double fare, boolean isPeak, boolean emergency) {
            this.serviceId = serviceId;
            this.route = route;
            this.from = from;
            this.to = to;
            this.departure = departure;
            this.fare = fare;
            this.isPeak = isPeak;
            this.emergency = emergency;
        }
        @Override
        public String toString() {
            return String.format("%s [%s] %s -> %s @%s ₹%.2f%s",
                    serviceId, route, from, to, departure.toLocalTime(), fare, emergency ? " (EMER)" : "");
        }
    }

    interface GeoUtils {
        static double calculateDistance(Location a, Location b) {
            double dx = a.lat - b.lat;
            double dy = a.lon - b.lon;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(Location from, Location to, boolean peak);
    }

    interface EmergencyService { }

    interface TransportService extends GeoUtils {
        String getServiceId();
        String getType();
        List<Trip> getActiveTrips();
        default void printServiceDetails() {
            System.out.println("Service: " + getServiceId() + " Type: " + getType());
            System.out.println("Active trips:");
            getActiveTrips().forEach(System.out::println);
        }
        static long countActiveTrips(TransportService svc) {
            return svc.getActiveTrips().size();
        }
    }

    static class BusService implements TransportService {
        private final String id;
        private final List<Trip> trips;
        BusService(String id, List<Trip> trips) {
            this.id = id;
            this.trips = new ArrayList<>(trips);
        }
        public String getServiceId() { return id; }
        public String getType() { return "BUS"; }
        public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }
        @Override
        public void printServiceDetails() {
            System.out.println("=== BUS SERVICE ===");
            TransportService.super.printServiceDetails();
        }
    }

    static class MetroService implements TransportService {
        private final String id;
        private final List<Trip> trips;
        MetroService(String id, List<Trip> trips) {
            this.id = id;
            this.trips = new ArrayList<>(trips);
        }
        public String getServiceId() { return id; }
        public String getType() { return "METRO"; }
        public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }
    }

    static class TaxiService implements TransportService {
        private final String id;
        private final List<Trip> trips;
        private final FareCalculator fareCalculator;
        TaxiService(String id, List<Trip> trips, FareCalculator fareCalculator) {
            this.id = id;
            this.trips = new ArrayList<>(trips);
            this.fareCalculator = fareCalculator;
        }
        public String getServiceId() { return id; }
        public String getType() { return "TAXI"; }
        public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }
        public double computeFare(Location from, Location to, boolean peak) {
            return fareCalculator.calculateFare(from, to, peak);
        }
    }

    static class AmbulanceService implements TransportService, EmergencyService {
        private final String id;
        private final List<Trip> trips;
        AmbulanceService(String id, List<Trip> trips) {
            this.id = id;
            this.trips = new ArrayList<>(trips);
        }
        public String getServiceId() { return id; }
        public String getType() { return "AMBULANCE"; }
        public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }
        @Override
        public void printServiceDetails() {
            System.out.println("!!! EMERGENCY SERVICE: " + id + " !!!");
            TransportService.super.printServiceDetails();
        }
    }

    static class FerryService implements TransportService {
        private final String id;
        private final List<Trip> trips;
        FerryService(String id, List<Trip> trips) {
            this.id = id;
            this.trips = new ArrayList<>(trips);
        }
        public String getServiceId() { return id; }
        public String getType() { return "FERRY"; }
        public List<Trip> getActiveTrips() { return Collections.unmodifiableList(trips); }
    }

    static Location A = new Location("Terminal A", 12.9716, 77.5946);
    static Location B = new Location("Terminal B", 12.9352, 77.6245);
    static Location C = new Location("Central Park", 12.9580, 77.5919);

    static List<Trip> sampleTrips(String svcId, String route, boolean emergencyFlag) {
        LocalDateTime now = LocalDateTime.now();
        return Arrays.asList(
                new Trip(svcId, route, A, B, now.plusMinutes(5), 30.0, true, emergencyFlag),
                new Trip(svcId, route, B, C, now.plusMinutes(20), 25.0, false, emergencyFlag),
                new Trip(svcId, route, A, C, now.plusMinutes(40), 45.0, false, emergencyFlag)
        );
    }

    static Optional<Trip> bookTrip(List<TransportService> services, Location from, Location to, Comparator<Trip> preference) {
        return services.stream()
                .flatMap(svc -> svc.getActiveTrips().stream())
                .filter(t -> t.from.name.equals(from.name) && t.to.name.equals(to.name))
                .sorted(preference)
                .findFirst();
    }

    static void displayDashboard(List<TransportService> services) {
        System.out.println("\n--- DASHBOARD: Active Services ---");
        services.forEach(svc -> {
            System.out.println("Service Header -> " + svc.getServiceId() + " (" + svc.getType() + ")");
            svc.getActiveTrips().forEach(System.out::println);
        });
    }

    static void generateReports(List<Trip> allTrips) {
        System.out.println("\n--- REVENUE & ANALYTICS ---");
        Map<String, Double> revenueByRoute = allTrips.stream()
                .collect(Collectors.groupingBy(
                        t -> t.route,
                        Collectors.summingDouble(t -> t.fare)
                ));
        System.out.println("Revenue by route: " + revenueByRoute);
        Map<Boolean, List<Trip>> partitionPeak = allTrips.stream()
                .collect(Collectors.partitioningBy(t -> t.isPeak));
        System.out.println("Peak trips count: " + partitionPeak.get(true).size()
                + ", Non-peak count: " + partitionPeak.get(false).size());
        DoubleSummaryStatistics stats = allTrips.stream()
                .collect(Collectors.summarizingDouble(t -> t.fare));
        System.out.println("Fare stats -> count: " + stats.getCount()
                + ", sum: " + stats.getSum()
                + ", avg: " + stats.getAverage()
                + ", min: " + stats.getMin()
                + ", max: " + stats.getMax());
        Map<String, Long> topRoutes = allTrips.stream()
                .collect(Collectors.groupingBy(t -> t.route, Collectors.counting()));
        topRoutes.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(e -> System.out.println("Top route: " + e.getKey() + " -> " + e.getValue() + " trips"));
    }

    static void prioritizeEmergencies(List<TransportService> services) {
        System.out.println("\n--- EMERGENCY PRIORITIZATION ---");
        services.stream()
                .filter(svc -> svc instanceof EmergencyService)
                .forEach(svc -> System.out.println("PRIORITIZE: " + svc.getServiceId() + " (" + svc.getType() + ")"));
    }

    public static void main(String[] args) {
        BusService bus1 = new BusService("BUS-101", sampleTrips("BUS-101", "A->B", false));
        MetroService metro1 = new MetroService("METRO-RED", sampleTrips("METRO-RED", "B->C", false));
        FareCalculator taxiFare = (from, to, peak) -> {
            double base = 50.0;
            double dist = GeoUtils.calculateDistance(from, to);
            double perKm = 10.0;
            double peakMultiplier = peak ? 1.5 : 1.0;
            return base + perKm * dist * peakMultiplier;
        };
        TaxiService taxi1 = new TaxiService("TAXI-500", sampleTrips("TAXI-500", "A->C", false), taxiFare);
        AmbulanceService amb1 = new AmbulanceService("AMB-1", sampleTrips("AMB-1", "A->B", true));
        FerryService ferry1 = new FerryService("FERRY-7", sampleTrips("FERRY-7", "C->A", false));
        List<TransportService> allServices = Arrays.asList(bus1, metro1, taxi1, amb1, ferry1);

        System.out.println("--- BOOKING FLOW ---");
        Comparator<Trip> earliestDeparture = Comparator.comparing(t -> t.departure);
        Comparator<Trip> lowestFare = Comparator.comparingDouble(t -> t.fare);
        Optional<Trip> booked = bookTrip(allServices, A, B, earliestDeparture.thenComparing(lowestFare));
        booked.ifPresent(t -> System.out.println("Booked trip: " + t));
        if (!booked.isPresent()) System.out.println("No available trip found for requested route/time.");

        displayDashboard(allServices);

        List<Trip> flattenedTrips = allServices.stream()
                .flatMap(svc -> svc.getActiveTrips().stream())
                .collect(Collectors.toList());
        generateReports(flattenedTrips);

        System.out.println("\n--- NEW SERVICE ADDED: " + ferry1.getServiceId() + " (" + ferry1.getType() + ") ---");

        prioritizeEmergencies(allServices);

        System.out.println("\n--- QUICK LOG OF SERVICE IDS ---");
        allServices.stream().map(TransportService::getServiceId).forEach(System.out::println);

        Trip sampleTaxiTrip = taxi1.getActiveTrips().get(0);
        double computedFare = taxi1.computeFare(sampleTaxiTrip.from, sampleTaxiTrip.to, sampleTaxiTrip.isPeak);
        System.out.printf("\nTaxi dynamic fare computed for %s: ₹%.2f%n", sampleTaxiTrip, computedFare);
    }
}
