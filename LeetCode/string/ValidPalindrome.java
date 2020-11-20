public class ValidPalindrome {

    // considering only alphanumeric characters and ignoring cases.
    // empty string as valid palindrome
    public boolean isPalindrome(String s) {
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

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        String t1 = "aba";
        String t2 = "A man, a plan, a canal: Panama";
        String t3 = "race a car";

        assert sol.isPalindrome(t1) == true : "T1 Failed";
        assert sol.isPalindrome(t2) == true : "T2 Failed";
        assert sol.isPalindrome(t3) == false : "T3 Failed";
    }
}
