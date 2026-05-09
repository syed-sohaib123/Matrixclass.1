public class ProductWiseSumNotHashmap {
    public static void main(String[] args) {

        String[] products = {"Apple", "Banana", "Apple", "Orange", "Banana", "Apple"};
        int[]    prices   = {  100,     50,      200,     150,       80,      120  };

        String[] uniqueProducts = new String[products.length];
        int[]    totalSum       = new int[products.length];
        int      count          = 0;

        for (int i = 0; i < products.length; i++) {
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (uniqueProducts[j].equals(products[i])) {
                    totalSum[j] += prices[i];  
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueProducts[count] = products[i];
                totalSum[count]       = prices[i];
                count++;
            }
        }

        System.out.println("Product-Wise Sum:");
        System.out.println("-----------------");
        for (int i = 0; i < count; i++) {
            System.out.println(uniqueProducts[i] + " = " + totalSum[i]);
        }
    }
}