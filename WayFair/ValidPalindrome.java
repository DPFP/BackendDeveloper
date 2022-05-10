public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        //clear string
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                sb.append(c);
            }
        }
        
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }
}
