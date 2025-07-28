import java.util.Date;
import java.text.SimpleDateFormat;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "PolicyNumber : " + policyNumber + ", Name : " + policyholderName +
               ", Expiry : " + sdf.format(expiryDate) + ", Type : " + coverageType +
               ", Premium : " + premiumAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Policy) {
            Policy p = (Policy) o;
            return this.policyNumber.equals(p.getPolicyNumber());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}