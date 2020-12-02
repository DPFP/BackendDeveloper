public class ValidPalindromeII {


    //Brute force solution -- Time Limit Exceeded
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
            return true;
        }else{
            for(int i=0; i < s.length();i++){
                sb.setLength(0);
                sb.append(s);
                sb.deleteCharAt(i);
                if(sb.toString().equalsIgnoreCase(sb.reverse().toString())){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ValidPalindromeII sol = new ValidPalindromeII();
        assert sol.validPalindrome("aba") == true : "T1 failed";
        assert sol.validPalindrome("abca") == true : "T2 failed";
    }
}
