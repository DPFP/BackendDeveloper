public class ReverseString {

    // Do not allocate extra space for another array, you must do this by modifying
    // the input array in-place with O(1) extra memory.
    public void reverseStringBF(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }

        System.out.println(s);
    }

    // online simple solution
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public static void main(String[] args) {
        char[] t1 = { 'h', 'e', 'l', 'l', 'o' };
        char[] t2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        ReverseString sol = new ReverseString();

        sol.reverseString(t1);
        sol.reverseString(t2);

        // assert sol.reverseString(t1) == {'o','l','l','e','h'}: 'T1 Failed';
    }
}
