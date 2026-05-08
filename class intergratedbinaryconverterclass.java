import java.util.Scanner;
import java.util.Arrays;

public class IntegratedBinaryConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter an integer number: ");
        int userNumber = input.nextInt();

      
        int[] binaryArray = convertToBinaryArray(userNumber);
        System.out.println("Part (b) - Array Representation: " + Arrays.toString(binaryArray));

        
        String binaryString = convertToBinaryString(userNumber);
        System.out.println("Part (c) - String Representation: " + binaryString);
        
        
        System.out.println("\n--- Verification of Test Cases ---");
        verifyTestCase(32);
        verifyTestCase(27);
        verifyTestCase(26);
    }

   
    public static int[] convertToBinaryArray(int n) {
        if (n == 0) return new int[]{0};

      
        int length = (int) (Math.log(n) / Math.log(2)) + 1;
        int[] binaryArray = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            binaryArray[i] = n % 2;
            n = n / 2;
        }
        return binaryArray;
    }

   
    public static String convertToBinaryString(int n) {
        if (n == 0) return "0";

        StringBuilder binaryBuilder = new StringBuilder();
        int temp = n;
        while (temp > 0) {
            int remainder = temp % 2;
            binaryBuilder.insert(0, remainder);
            temp = temp / 2;
        }
        return binaryBuilder.toString();
    }

   
    public static void verifyTestCase(int testNum) {
        System.out.println("Input: " + testNum + " | Binary Output: " + convertToBinaryString(testNum));
    }
}
