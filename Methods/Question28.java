import java.util.Arrays;
public class Question28{
    public static int countDigits(int n) {
        return Integer.toString(n).length();
    }
    public static int[] toDigitArray(int n) {
        String s = Integer.toString(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }
    public static int[] reverseArray(int[] arr) {
        int[] rev = arr.clone();
        for (int i = 0; i < rev.length / 2; i++) {
            int temp = rev[i];
            rev[i] = rev[rev.length - 1 - i];
            rev[rev.length - 1 - i] = temp;
        }
        return rev;
    }
    public static boolean isPalindrome(int n) {
        int[] digits = toDigitArray(n);
        return Arrays.equals(digits, reverseArray(digits));
    }
    public static boolean isDuckNumber(int n) {
        String s = Integer.toString(n);
        return s.indexOf('0') > 0;
    }
    public static void main(String[] args) {
        int num = 1210;
        System.out.println("Digits count: " + countDigits(num));
        System.out.println("Is Palindrome: " + isPalindrome(num));
        System.out.println("Is Duck: " + isDuckNumber(num));
    }
}
