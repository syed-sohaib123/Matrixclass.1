import java.util.Scanner;

public class Matrixclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
System.out.print("Enter the dimension of the square matrix (n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
int mainDiagonalSum = 0;
        int reverseDiagonalSum = 0;

        System.out.println("\n--- Results ---");

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
if (j == (n - 1 - i)) {
                    reverseDiagonalSum += matrix[i][j];
                }
            }
            System.out.println("Sum of Row " + (i + 1) + ": " + rowSum);
            System.out.println("Sum of Column " + (i + 1) + ": " + colSum);
        }

        System.out.println("----------------");
        System.out.println("Sum of Main Diagonal: " + mainDiagonalSum);
        System.out.println("Sum of Reverse Diagonal: " + reverseDiagonalSum);
        
        sc.close();
    }
}