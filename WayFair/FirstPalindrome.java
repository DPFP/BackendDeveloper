public class FirstPalindrome {
    // 2108. Find First Palindromic String in the Array
    // https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;

        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
