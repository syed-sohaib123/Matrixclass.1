public class IdWiseSumNotHashmap {
    public static void main(String[] args) {

        int[] ids     = {101, 102, 101, 103, 102, 101, 103};
        int[] amounts = {500, 300, 200, 400, 100, 300, 150};

        int[] uniqueIds  = new int[ids.length];
        int[] totalSum   = new int[ids.length];
        int   count      = 0;

        for (int i = 0; i < ids.length; i++) {
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (uniqueIds[j] == ids[i]) {
                    totalSum[j] += amounts[i];  
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueIds[count] = ids[i];
                totalSum[count]  = amounts[i];
                count++;
            }
        }

        System.out.println("ID-Wise Sum:");
        System.out.println("------------");
        for (int i = 0; i < count; i++) {
            System.out.println("ID " + uniqueIds[i] + " = " + totalSum[i]);
        }
    }
}