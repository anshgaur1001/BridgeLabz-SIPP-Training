// Node representing a Bus Stop
class BusStop {
    String name;
    BusStop next;

    public BusStop(String name) {
        this.name = name;
        this.next = null;
    }
}

// LinkedList for Bus Route
class BusRoute {
    private BusStop head;

    // Insert at end
    public void addStop(String name) {
        BusStop newStop = new BusStop(name);
        if (head == null) {
            head = newStop;
            return;
        }
        BusStop temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStop;
    }

    // Insert after a specific stop
    public void insertAfter(String prevStopName, String newStopName) {
        BusStop temp = head;
        while (temp != null && !temp.name.equals(prevStopName)) {
            temp = temp.next;
        }
        if (temp != null) {
            BusStop newStop = new BusStop(newStopName);
            newStop.next = temp.next;
            temp.next = newStop;
        } else {
            System.out.println("Stop " + prevStopName + " not found.");
        }
    }

    // Delete a stop
    public void removeStop(String stopName) {
        if (head == null) return;

        if (head.name.equals(stopName)) {
            head = head.next;
            return;
        }

        BusStop temp = head;
        while (temp.next != null && !temp.next.name.equals(stopName)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Stop " + stopName + " not found.");
        }
    }

    // Search for a stop
    public boolean searchStop(String stopName) {
        BusStop temp = head;
        while (temp != null) {
            if (stopName.equals(temp.name)) return true;
            temp = temp.next;
        }
        return false;
    }

    // Display full route
    public void displayRoute() {
        BusStop temp = head;
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Demo
public class BusRouteNavigator {
    public static void main(String[] args) {
        BusRoute route = new BusRoute();

        // Initial route
        route.addStop("Depot");
        route.addStop("Main Street");
        route.addStop("City Mall");
        route.addStop("Hospital");
        route.addStop("Airport");

        System.out.println("Initial Route:");
        route.displayRoute();

        // Insert University after City Mall
        System.out.println("\nAdding University after City Mall:");
        route.insertAfter("City Mall", "University");
        route.displayRoute();

        // Remove Hospital
        System.out.println("\nRemoving Hospital due to road closure:");
        route.removeStop("Hospital");
        route.displayRoute();

        // Search for Airport
        System.out.println("\nSearching for Airport:");
        System.out.println(route.searchStop("Airport") ? "✅ Airport is on the route." : "❌ Airport not found.");
    }
}
