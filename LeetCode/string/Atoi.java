import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atoi {
    // https://leetcode.com/problems/string-to-integer-atoi/

    public int myAtoi(String s) {
        if (s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }

        // trim lending white space
        s = s.stripLeading();
        int[] validSigns = new int[] { 43, 45, 46 };
        List<Integer> signs = Arrays.asList(43, 45, 46);

        // 0 ~ 9 --> 48 ~ 57
        // + --> 43, - --> 45, . --> 46
        if (s.charAt(0) < 57 && s.charAt(0) > 48) {
            // 0 ?
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
