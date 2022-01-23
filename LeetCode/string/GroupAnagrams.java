import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {
    // 49 Group Anagrams https://leetcode.com/problems/group-anagrams/

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
        return new String(code);
    }

    // similar appraoch but more concise
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray())
                ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
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
}
