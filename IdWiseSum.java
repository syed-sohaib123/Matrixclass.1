import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

class BSCS_EVE_B_SalesTotalHM_ID {

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

                String salesID = parts[0];                       
                double uPrice  = Double.parseDouble(parts[2]);
                double qty     = Double.parseDouble(parts[3]);
                double amt     = qty * uPrice;

                hm.put(salesID, hm.getOrDefault(salesID, 0.0) + amt);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: File not found → " + f1.getPath());

        } catch (NumberFormatException nfe) {
            System.out.println("Error: Invalid number in file.");
            nfe.printStackTrace();

        } catch (NoSuchElementException nsee) {
            System.out.println("Error: Unexpected end of file.");

        } finally {
            if (inp != null) inp.close();

            System.out.println("\n========== ID-Wise Sales Total ==========");
            System.out.printf("%-10s %15s%n", "Sale ID", "Total Amount");
            System.out.println("------------------------------------------");

            for (Map.Entry<String, Double> me : hm.entrySet()) {
                System.out.printf("%-10s %15.2f%n", me.getKey(), me.getValue());
            }

            System.out.println("==========================================");
        }
    }
}
