public class Question31{
    public static int countDigits(int number) {
        return Integer.toString(number).length();
    }
    public static int[] getDigitsArray(int number) {
        String str = Integer.toString(number);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }
    public static boolean isDuckNumber(int number) {
        String str = Integer.toString(number);
        return str.contains("0") && str.charAt(0) != '0';
    }
    public static boolean isArmstrong(int number) {
        int[] digits = getDigitsArray(number);
        int n = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        return sum == number;
    }
    public static int[] findTwoLargest(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }
    public static int[] findTwoSmallest(int[] digits) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < first) {
                second = first;
                first = d;
            } else if (d < second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }
    public static void main(String[] args) {
        int number = 153;
        System.out.println("Digit Count: " + countDigits(number));
        int[] digits = getDigitsArray(number);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.println("Is Duck: " + isDuckNumber(number));
        System.out.println("Is Armstrong: " + isArmstrong(number));
        int[] largest = findTwoLargest(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);
        int[] smallest = findTwoSmallest(digits);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
    }
}
