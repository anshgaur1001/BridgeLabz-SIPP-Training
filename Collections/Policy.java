import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;

    Policy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber : " + policyNumber +
               ", Name : " + policyholderName +
               ", Expiry : " + expiryDate;
    }
}