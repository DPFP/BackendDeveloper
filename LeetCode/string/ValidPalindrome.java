public class ValidPalindrome {

    // considering only alphanumeric characters and ignoring cases.
    // empty string as valid palindrome
    // Runtime 42.85% , Memory 95%
    public boolean isPalindromeFirst(String s) {
        if (s.isEmpty()) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        // clean data -- only leave alphanumeric
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        // reverse & compare
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    // simples online solution
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    // 2022-1-22 (worest runtime so far using two pointer )
    public boolean isPalindrome3(String s) {
        // 1st, remove all nun alph values;
        // 2nd, determine if it even or odd
        // 3rd check the palindrome

        // s.replaceAll("[^A-Za-z0-9]", "")
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int len = s.length();

        if (len % 2 == 0) {
            return check(len / 2 - 1, len / 2, s);
        } else {
            return check(len / 2, len / 2, s);
        }
    }

    private boolean check(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        String t1 = "aba";
        String t2 = "A man, a plan, a canal: Panama";
        String t3 = "race a car";

        assert sol.isPalindrome(t1) == true : "T1 Failed";
        assert sol.isPalindrome(t2) == true : "T2 Failed";
        assert sol.isPalindrome(t3) == false : "T3 Failed";

        System.out.println(3 / 2);
        System.out.println(5 / 2);
        System.out.println("amanaplanacanalpanama".length());
    }
}
