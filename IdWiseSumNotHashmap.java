import java.util.Scanner;
import java.io.File;

class BSCS_EVE_B_SalesTotalNoHM {
    public static void main(String[] args) {
        
        File f1 = new File("c:\\temp\\SalesEVESession.txt");
        
        String[] productIds = new String[100]; 
        double[] totals = new double[100];
        int uniqueCount = 0;

        try (Scanner inp = new Scanner(f1)) {
           
            if (inp.hasNextLine()) {
                System.out.println("Header: " + inp.nextLine());
            }

            while (inp.hasNextLine()) {
                String dl = inp.nextLine();
                if (dl.trim().isEmpty()) continue;

                String[] parts = dl.split("\t");
                
                String currentId = parts[1]; 
                double uPrice = Double.parseDouble(parts[2]);
                double qty = Double.parseDouble(parts[3]);
                double lineTotal = qty * uPrice;

                int foundIndex = -1;
                for (int i = 0; i < uniqueCount; i++) {
                    if (productIds[i].equals(currentId)) {
                        foundIndex = i;
                        break;
                    }
                }

                if (foundIndex != -1) {
                   
                    totals[foundIndex] += lineTotal;
                } else {
                    
                    productIds[uniqueCount] = currentId;
                    totals[uniqueCount] = lineTotal;
                    uniqueCount++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + e.getMessage());
        }

       
        System.out.println("\n--- ID Wise Totals ---");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println("ID: " + productIds[i] + " | Total: " + totals[i]);
        }
    }
}
