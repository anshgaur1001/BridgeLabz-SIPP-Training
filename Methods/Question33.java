import java.util.Arrays;
public class Question33{
    public static int countDigits(int number) {
        return Integer.toString(number).length();
    }
    public static int[] getDigitsArray(int number) {
        String s = String.valueOf(number);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d * d;
        return sum;
    }
    public static boolean isHarshad(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int d : digits) sum += d;
        return number % sum == 0;
    }
    public static int[][] digitFrequencyArray(int number) {
        int[] digits = getDigitsArray(number);
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;      // digit
            result[i][1] = freq[i]; // frequency
        }
        return result;
    }
    public static void main(String[] args) {
        int number = 378;
        System.out.println("Digit Count: " + countDigits(number));
        System.out.println("Sum of Squares: " + sumOfSquares(getDigitsArray(number)));
        System.out.println("Is Harshad: " + isHarshad(number));
        int[][] freqArr = digitFrequencyArray(number);
        System.out.println("Digit - Frequency");
        for (int[] row : freqArr) {
            if (row[1] > 0)
                System.out.println(row[0] + " - " + row[1]);
        }
    }
}
