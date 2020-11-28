public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) {
            return false;
        }

        // //aaa
        // if (s.length() % 2 != 0) {
        // return false;
        // }

        // find first repeating elemtnt location
        for (int i = 1; i < s.length() + 1; i++) {
            // System.out.println(s.indexOf(s.charAt(i)));
            String sub = s.substring(0, i);
            while (s.trim().length() > 0) {
                s.replace(sub, "");
            }
            if (s.trim().length() == 0) {
                System.out.println(sub);
                return true;
            }
        }

        // loop through

        return false;
    }

    // solution from leetcode
    // https://leetcode.com/problems/repeated-substring-pattern/discuss/94344/Simple-Java-solution-2-lines/327797
    public boolean repeatedSubstringPatternSol(String str) {
        String s = str + str;
        String temp = s.substring(1, s.length() - 1);
        return temp.contains(str);
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern sol = new RepeatedSubstringPattern();
        sol.repeatedSubstringPatternSol("abcabc");
    }
}
