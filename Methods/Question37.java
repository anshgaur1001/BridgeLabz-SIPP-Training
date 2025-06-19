import java.util.Random;
import java.util.Scanner;
public class Question37{
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10);
        return matrix;
    }
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                transpose[i][j] = matrix[j][i];
        return transpose;
    }
    public static int determinant2x2(int[][] matrix) {
        if (matrix.length == 2 && matrix[0].length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            throw new IllegalArgumentException("Matrix must be 2x2.");
        }
    }
    public static int determinant3x3(int[][] matrix) {
        if (matrix.length == 3 && matrix[0].length == 3) {
            int a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
            int d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
            int g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];
            return a * (e * i - f * h)
                 - b * (d * i - f * g)
                 + c * (d * h - e * g);
        } else {
            throw new IllegalArgumentException("Matrix must be 3x3.");
        }
    }
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = createRandomMatrix(rows, cols);
        System.out.println("\nOriginal Matrix:");
        displayMatrix(matrix);
        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(matrix));
        if (rows == 2 && cols == 2) {
            int det2x2 = determinant2x2(matrix);
            System.out.println("\nDeterminant of 2x2 matrix: " + det2x2);
        }
        if (rows == 3 && cols == 3) {
            int det3x3 = determinant3x3(matrix);
            System.out.println("\nDeterminant of 3x3 matrix: " + det3x3);
        }
    }
}
