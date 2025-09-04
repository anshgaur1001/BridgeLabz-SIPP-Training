// Base interface for promotion logic
interface Promotion<T> {
    double applyDiscount(T customer, double bookingAmount);
}

//Customer Types
class RegularCustomer {
    String name;
    int loyaltyPoints;

    public RegularCustomer(String name, int loyaltyPoints) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }
}

class PremiumCustomer {
    String name;
    int membershipYears;

    public PremiumCustomer(String name, int membershipYears) {
        this.name = name;
        this.membershipYears = membershipYears;
    }
}

class CorporateCustomer {
    String companyName;
    int employeeCount;

    public CorporateCustomer(String companyName, int employeeCount) {
        this.companyName = companyName;
        this.employeeCount = employeeCount;
    }
}

//Promotion Strategies
class RegularPromotion implements Promotion<RegularCustomer> {
    public double applyDiscount(RegularCustomer customer, double bookingAmount) {
        double discount = bookingAmount * 0.05; // 5% discount
        if (customer.loyaltyPoints > 100) {
            discount += bookingAmount * 0.02; // extra 2%
        }
        return bookingAmount - discount;
    }
}

class PremiumPromotion implements Promotion<PremiumCustomer> {
    public double applyDiscount(PremiumCustomer customer, double bookingAmount) {
        double discount = bookingAmount * 0.15; // 15%
        if (customer.membershipYears > 5) {
            discount += bookingAmount * 0.05; // extra 5%
        }
        return bookingAmount - discount;
    }
}

class CorporatePromotion implements Promotion<CorporateCustomer> {
    public double applyDiscount(CorporateCustomer customer, double bookingAmount) {
        double discount = (customer.employeeCount > 50)
                ? bookingAmount * 0.20   // 20%
                : bookingAmount * 0.10;  // 10%
        return bookingAmount - discount;
    }
}

// Generic Booking Engine
class HotelBookingEngine<T> {
    private Promotion<T> promotion;

    HotelBookingEngine(Promotion<T> promotion) {
        this.promotion = promotion;
    }

    double calculateFinalAmount(T customer, double bookingAmount) {
        return promotion.applyDiscount(customer, bookingAmount);
    }
}

public class HotelBookingDemo {
    public static void main(String[] args) {
        RegularCustomer rc = new RegularCustomer("Alice", 120);
        PremiumCustomer pc = new PremiumCustomer("Bob", 6);
        CorporateCustomer cc = new CorporateCustomer("TechCorp", 75);

        HotelBookingEngine<RegularCustomer> regEngine =
                new HotelBookingEngine<>(new RegularPromotion());
        System.out.println("Final bill for Regular Customer: " +
                regEngine.calculateFinalAmount(rc, 10000));

        HotelBookingEngine<PremiumCustomer> premEngine =
                new HotelBookingEngine<>(new PremiumPromotion());
        System.out.println("Final bill for Premium Customer: " +
                premEngine.calculateFinalAmount(pc, 20000));

        HotelBookingEngine<CorporateCustomer> corpEngine =
                new HotelBookingEngine<>(new CorporatePromotion());
        System.out.println("Final bill for Corporate Customer: " +
                corpEngine.calculateFinalAmount(cc, 50000));
    }
}
