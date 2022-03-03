package JavaBasic.LeetCode.string;

public class PalindromicSubstrings {
    // 647 Palindromic Substrings
    // https://leetcode.com/problems/palindromic-substrings/

    // precise soltuion from NeedCode
    public int countSubstrings(String s) {
        // BF - O(n^3) --> O(n^2) substring + O(n) determine palindromic
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // check odd length palindrome
            res += count(i, i, s);
            // check even length palindrome
            res += count(i, i + 1, s);
        }

        return res;
    }

    private int count(int left, int right, String s) {
        int len = s.length();
        int res = 0;

        // here is the key to check the palindrome
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            res += 1;
            left--;
            right++;
        }

        return res;
    }

    // longer version before refactoring
    public int countSubstrings2(String s) {
        // BF - O(n^3) --> O(n^2) substring + O(n) determine palindromic
        int res = 0;
        int len = s.length();

        int left = 0;
        int right = 0;

        for (int i = 0; i < len; i++) {
            // check odd length palindrome
            left = i;
            right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left--;
                right++;
            }

            // check even length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left--;
                right++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char a = 'a';
        char b = 'a';

        Character c = 'c';
        Character d = 'c';

        System.out.println(a == b);
        System.out.println(c.equals(d));
    }
}
