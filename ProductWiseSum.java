import java.util.HashMap;
import java.util.Map;

public class ProductWiseSum {
    public static void main(String[] args) {
        
        String[][] salesData = {
            {"Apple",  "150.00"},
            {"Banana", "80.00"},
            {"Apple",  "200.00"},
            {"Orange", "120.00"},
            {"Banana", "95.00"},
            {"Orange", "60.00"},
            {"Apple",  "175.00"},
            {"Mango",  "300.00"},
            {"Mango",  "250.00"},
            {"Banana", "110.00"}
        };

        HashMap<String, Double> productSumMap = new HashMap<>();

        for (String[] entry : salesData) {
            String product = entry[0];
            double amount  = Double.parseDouble(entry[1]);

            productSumMap.put(product, productSumMap.getOrDefault(product, 0.0) + amount);
        }

        System.out.println("===== Product-Wise Sales Summary =====");
        System.out.printf("%-15s %s%n", "Product", "Total Sales");
        System.out.println("--------------------------------------");

        double grandTotal = 0.0;
        for (Map.Entry<String, Double> entry : productSumMap.entrySet()) {
            System.out.printf("%-15s $%.2f%n", entry.getKey(), entry.getValue());
            grandTotal += entry.getValue();
        }

        System.out.println("--------------------------------------");
        System.out.printf("%-15s $%.2f%n", "GRAND TOTAL", grandTotal);
    }
}