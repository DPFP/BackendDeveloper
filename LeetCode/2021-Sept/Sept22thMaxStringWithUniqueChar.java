import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sept22thMaxStringWithUniqueChar {
    public int maxLengthFirstTry(List<String> arr) {
        int res = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i)); // first level get the word
            sb.append(arr.get(i));
            for (char c : arr.get(i).toCharArray()) {
                sb.setLength(0);
                // second level - get char for the word
                for (int j = 0; j < arr.size(); j++) {
                    // compare the char with all other words
                    if (i != j && arr.get(j).indexOf(c) != -1) {
                        // not gonna work
                        continue;
                    }
                    sb.append(arr.get(j));
                }
                res = Math.max(res, sb.toString().length());
            }
        }
        return res;
    }

    // https://wentao-shao.gitbook.io/leetcode/graph-search/1239.maximum-length-of-a-concatenated-string-with-unique-characters
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();

        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0)
                continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0)
                    continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sept22thMaxStringWithUniqueChar sol = new Sept22thMaxStringWithUniqueChar();
        String[] t1 = { "un", "iq", "ue" };
        System.out.println(sol.maxLength(Arrays.asList(t1)));
    }
}
