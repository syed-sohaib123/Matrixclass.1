import java.util.HashMap;

public class IdWiseSum {
    public static void main(String[] args) {

        int[] ids     = {101, 102, 101, 103, 102, 101, 103};
        int[] amounts = { 500, 300, 200, 400, 100, 300, 150};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ids.length; i++) {
            map.put(ids[i], map.getOrDefault(ids[i], 0) + amounts[i]);
        }

        System.out.println("ID-Wise Sum:");
        System.out.println("------------");
        for (int key : map.keySet()) {
            System.out.println("ID " + key + " = " + map.get(key));
        }
    }
}