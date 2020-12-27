import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // bf way;
    public int romanToIntBF(String s) {
        if (s.trim().length() < 1 && s.trim().length() > 15) {
            return 0;
        }

        Map<String, Integer> subtraction = new HashMap<>();
        subtraction.put("IV", 4);
        subtraction.put("IX", 9);
        subtraction.put("XL", 40);
        subtraction.put("XC", 90);
        subtraction.put("CD", 400);
        subtraction.put("CM", 900);

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (String key : subtraction.keySet()) {
            if (s.contains(key)) {
                result += subtraction.get(key);
                // Need do the following, String is immutable
                s = s.replace(key, "");
            }
        }

        while (s.trim().length() != 0) {
            for (char value : s.toCharArray()) {
                result += map.get(value);
                int index = s.indexOf(value);
                s = s.substring(0, index) + s.substring(index + 1);
            }
        }

        return result;
    }

    // second try
    // Goal improve the performance
    public int romanToInt(String s) {

        return 0;
    }


    //added online solution 
    static int number(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int romanToIntSol(String s) {
        int ans = 0, prev = 0;
        for (char c : s.toCharArray()) {
            int num = number(c);
            if (prev < num) {
                ans = ans - prev;
                ans += num - prev;
            } else {
                ans += num;
            }
            prev = num;

        }
        return ans;
    }

    public static void main(String[] args) {
        RomanToInteger sol = new RomanToInteger();
        assert sol.romanToInt("III") == 3 : "III failed";
        assert sol.romanToInt("IV") == 4 : "IV failed";
        assert sol.romanToInt("IX") == 9 : "IX failed";
        assert sol.romanToInt("LVIII") == 58 : "LVIII failed";
        assert sol.romanToInt("MCMXCIV") == 1994 : "MCMXCIV failed";
    }
}
