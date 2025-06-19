public class Question24{
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = (int)(Math.random() * 101) + 150;
        }
        return heights;
    }
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int h : arr) sum += h;
        return sum;
    }
    public static double getMean(int[] arr) {
        return getSum(arr) / (double)arr.length;
    }
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int h : arr) min = Math.min(min, h);
        return min;
    }
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int h : arr) max = Math.max(max, h);
        return max;
    }
    public static void main(String[] args) {
        int[] heights = generateHeights(11);
        System.out.println("Shortest: " + getMin(heights));
        System.out.println("Tallest: " + getMax(heights));
        System.out.println("Mean: " + getMean(heights));
    }
}
