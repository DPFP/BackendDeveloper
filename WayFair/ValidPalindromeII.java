public class ValidPalindromeII {
    
    //680. Valid Palindrome II
    //https://leetcode.com/problems/valid-palindrome-ii/

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return (checkPalindrome(s,i,j-1) || checkPalindrome(s,i+1,j));
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean checkPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true; 
    }

    public static void main(String[] args) {
        
    }
}
