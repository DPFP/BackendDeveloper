import java.util.HashMap;
import java.util.Map;

public class Sept13th {

    public int maxNumberOfBalloons(String text) {

        String target = "balloon"; // special handle l and o

        Map<Character, Integer> targetMap = new HashMap<>();

        // fill in the map
        for (char c : target.toCharArray()) {
            targetMap.put(c, 0);
        }

        for (char c : text.toCharArray()) {
            if (target.indexOf(c) > -1) {
                targetMap.computeIfPresent(c, (key, val) -> val + 1);
            }
        }

        int temp = 0;
        int count = -1;
        for (char c : targetMap.keySet()) {
            temp = targetMap.get(c);
            if (c == 'l' || c == 'o') {
                temp = (targetMap.get(c) / 2);
            }
            if (count < 0) {
                count = temp;
            } else if (temp < count) {
                count = temp;
            }

            // System.out.println("key:" + c + " Value:" + temp);
        }
        System.out.println("count:" + count);

        return count;
    }

    public static void main(String[] args) {
        Sept13th sol = new Sept13th();
        sol.maxNumberOfBalloons("nlaebolko");

        sol.maxNumberOfBalloons("loonbalxballpoon");
        sol.maxNumberOfBalloons("leetcode");
        // System.out.println("balloon".indexOf('b'));
    }
}
