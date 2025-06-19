import java.util.HashSet;
public class Question25{
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }
    public static boolean checkUniqueness(int[] otps) {
        HashSet<Integer> set = new HashSet<>();
        for (int otp : otps) set.add(otp);
        return set.size() == otps.length;
    }
    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        System.out.println("All OTPs unique? " + checkUniqueness(otps));
    }
}
