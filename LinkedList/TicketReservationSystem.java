package Day2;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
	private Ticket head = null;
    private Ticket tail = null;
    private int count = 0;

    // Add ticket at end
    public void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }

        count++;
        System.out.println("Ticket booked successfully.");
    }

    // Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;

                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    previous.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = previous;
                }

                count--;
                System.out.println("Ticket ID " + ticketId + " removed.");
                break;
            }

            previous = current;
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("Ticket ID not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No booked tickets.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n--- Booked Tickets ---");

        do {
            System.out.println("ID: " + temp.ticketId + ", Name: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer name or movie name
    public void searchTicket(String key) {
        if (head == null) {
            System.out.println("No booked tickets.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        System.out.println("\n--- Search Results for \"" + key + "\" ---");

        do {
            if (temp.customerName.equalsIgnoreCase(key) || temp.movieName.equalsIgnoreCase(key)) {
                System.out.println("ID: " + temp.ticketId + ", Name: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No matching tickets found.");
    }

    // Count total booked tickets
    public void totalTickets() {
        System.out.println("Total booked tickets: " + count);
    }
    
    //main method for testing
    public static void main(String[] args) {
    	
    }
}
