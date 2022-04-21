package sequences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {
    // 49 Group Anagrams
    // https://leetcode.com/problems/group-anagrams/

    // shit cant figure it out
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs.length < 1) {
            return res;
        }

        Map<Set<Character>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            System.out.println(word);
            Set<Character> wordSet = new HashSet<>();
            for (Character c : word.toCharArray()) {
                wordSet.add(c);
            }
        }

        return res;
    }

    // labuladong solution
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> codeToGroup = new HashMap<>();

        for (String s : strs) {
            // encode the string
            String code = encode(s);

            // group encoded value;
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        List<List<String>> res = new LinkedList<>();

        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    private String encode(String s) {
        char[] code = new char[26]; // because it only English letters;
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            code[delta]++;
        }
        // 26 char long string ;
        return new String(code); // noticed here, it have to be "new String(code)"
    }

    // similar appraoch but more concise
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // even better soltution
    public List<List<String>> groupAnagrams4(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca); // key is here. (maybe too much overhead?)
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // retry on 1/23
    public List<List<String>> groupAnagrams5(String[] strs) {
        // the key is about encoding the string
        List<List<String>> res = new LinkedList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            String key = encode5(word);

            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(word);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        // can be replaced by --> new ArrayList<>(checkMap.values());

        return res;
    }

    private String encode5(String word) {
        char[] code = new char[26];

        for (char c : word.toCharArray()) {
            code[c - 'a']++;
        }

        // return code.toString(); //can't do code.toString() --> hashCode must be
        // different in this case
        return new String(code); // or String.valueOf()
    }

    // Retry on 2/13/2022, 4/20/2022
    public List<List<String>> groupAnagrams6(String[] strs) {
        // 1, i should start with Brute Force solution. (1, loop through every wored, 2,
        // sort every word, check and add )
        // 2, Tips from labuladong: Encoding is the key for this problem. arr[26] or
        // String ?
        Map<String, List<String>> checkMap = new HashMap<>();
        for (String word : strs) {
            char[] ca = new char[26];

            // Key: encoding here
            for (char c : word.toCharArray()) {
                ca[c - 'a']++;
            }
            String key = String.valueOf(ca);

            checkMap.putIfAbsent(key, new LinkedList<>());
            checkMap.get(key).add(word);
        }

        return new ArrayList<>(checkMap.values());
    }
}
