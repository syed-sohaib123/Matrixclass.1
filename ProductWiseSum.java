import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

class BSCS_EVE_B_SalesTotalHM {

    public static void main(String[] args) {

        File f1 = new File("c:\\temp\\SalesEVESession.txt");
        Scanner inp = null;
        HashMap<String, Double> hm = new HashMap<>();

        try {
            inp = new Scanner(f1);

            if (inp.hasNextLine()) {
                String header = inp.nextLine();
                System.out.println("Header: " + header);
            }

            while (inp.hasNextLine()) {
                String dl = inp.nextLine().trim();

                if (dl.isEmpty()) continue; 

                System.out.println(dl);

                String[] parts = dl.split("\t");

                if (parts.length < 4) continue;

                String prodName = parts[1];
                double uPrice   = Double.parseDouble(parts[2]);
                double qty      = Double.parseDouble(parts[3]);
                double amt      = qty * uPrice;

                hm.put(prodName, hm.getOrDefault(prodName, 0.0) + amt);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: File not found → " + f1.getPath());

        } catch (NumberFormatException nfe) {
            System.out.println("Error: Invalid number format in file.");
            nfe.printStackTrace();

        } catch (NoSuchElementException nsee) {
            System.out.println("Error: Unexpected end of file.");

        } finally {
            if (inp != null) inp.close(); 

            System.out.println("\n========== Product-Wise Sales Total ==========");
            System.out.printf("%-25s %10s%n", "Product Name", "Total Amount");
            System.out.println("----------------------------------------------");

            for (Map.Entry<String, Double> me : hm.entrySet()) {
                System.out.printf("%-25s %10.2f%n", me.getKey(), me.getValue());
            }

            System.out.println("==============================================");
        }
    }
}
