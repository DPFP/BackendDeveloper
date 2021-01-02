public class LengthOfLastWord {

    // 1st try
    public int lengthOfLastWordBF(String s) {
        if (s.isBlank()) {
            return 0;
        }

        String[] listOfWords = s.split(" ");
        return listOfWords[listOfWords.length - 1].length();
    }

    // online best solution
    public int lengthOfLastWord(String s) {
        if (s.isBlank()) {
            return 0;
        }
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        LengthOfLastWord sol = new LengthOfLastWord();

        String t1 = " ";
        String t2 = "Hello world";
        String t3 = "HelloWorld";
        String t4 = " Hello";
        String t5 = "Hello world Leetcode";

        assert sol.lengthOfLastWord(t1) == 0 : "T1 failed:" + t1;
        assert sol.lengthOfLastWord(t2) == 5 : "T2 failed:" + t2;
        assert sol.lengthOfLastWord(t3) == 10 : "T3 failed:" + t3;
        assert sol.lengthOfLastWord(t4) == 5 : "T4 failed:" + t4;
        assert sol.lengthOfLastWord(t5) == 8 : "T5 failed:" + t5;

    }

}
