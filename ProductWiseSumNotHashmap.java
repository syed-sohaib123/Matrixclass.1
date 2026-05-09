import java.util.Scanner;
import java.io.File;

class BSCS_EVE_B_SalesTotalNoHM {
    public static void main(String[] args) {
        
        File f1 = new File("c:\\temp\\SalesEVESession.txt"); 
        
        String[] products = new String[100];
        double[] totals = new double[100];
        int productCount = 0;

        try (Scanner inp = new Scanner(f1)) {
           
            if (inp.hasNextLine()) {
                System.out.println("Header: " + inp.nextLine());
            }

            while (inp.hasNextLine()) {
                String dl = inp.nextLine();
                if (dl.trim().isEmpty()) continue;

                String[] parts = dl.split("\t");
                String prodName = parts[1];
                double uPrice = Double.parseDouble(parts[2]);
                double qty = Double.parseDouble(parts[3]);
                double currentAmt = qty * uPrice;

                int foundIndex = -1;
                for (int i = 0; i < productCount; i++) {
                    if (products[i].equalsIgnoreCase(prodName)) {
                        foundIndex = i;
                        break;
                    }
                }

                if (foundIndex != -1) {
            
                    totals[foundIndex] += currentAmt;
                } else {
                    
                    products[productCount] = prodName;
                    totals[productCount] = currentAmt;
                    productCount++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("\n--- Product Totals ---");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i] + " --- " + totals[i]);
        }
    }
}
