import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    //13. Roman to Integer
    //https://leetcode.com/problems/roman-to-integer/

    // brute force solution; 11/13/2020 21:59
    public int romanToIntBF(String s) {
        if (s.trim().length() < 1 && s.trim().length() > 15) {
            return 0;
        }

        Map<String, Integer> subtraction = new HashMap<>();
        subtraction.put("IV", 4);
        subtraction.put("IX", 9);
        subtraction.put("XL", 40);
        subtraction.put("XC", 90);
        subtraction.put("CD", 400);
        subtraction.put("CM", 900);

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (String key : subtraction.keySet()) {
            if (s.contains(key)) {
                result += subtraction.get(key);
                // Need do the following, String is immutable
                s = s.replace(key, "");
            }
        }

        while (s.trim().length() != 0) {
            for (char value : s.toCharArray()) {
                result += map.get(value);
                int index = s.indexOf(value);
                s = s.substring(0, index) + s.substring(index + 1);
            }
        }

        return result;
    }

    // second try , slightly different version of BF solution. 
    //02/12/2022 12:55
    public int romanToInt2(String s) {
        //first create a map
        
        //key: Roman,  value: Integer
        Map<Character,Integer> RoToIntMap = new HashMap<>(); 
        
        RoToIntMap.put('I', 1); // 4, 9 
        RoToIntMap.put('V', 5);
        RoToIntMap.put('X', 10); // 40, 90 
        RoToIntMap.put('L', 50);
        RoToIntMap.put('C', 100); // 400, 900 
        RoToIntMap.put('D', 500);
        RoToIntMap.put('M', 1000);
        
        int index = 0; 
        int res = 0; 
        int n = s.length();
        
        while(index < n){
            char cur = s.charAt(index);
            //M CD XL IV III 
            if(cur == 'C'){
                 if(((index+1) < n) && (s.charAt(index+1) == 'D')){
                    res += 400;
                    index++;
                }else if(((index+1) < n) && (s.charAt(index+1) == 'M')){
                    res += 900;
                    index++;
                }else{
                    res += RoToIntMap.get(cur); //1000 + 400 +      
                }
            }else if(cur == 'X'){
                 if( ((index+1) < n) && (s.charAt(index+1) == 'L')){
                    res += 40;
                    index++;
                }else if(((index+1) < n) && (s.charAt(index+1) == 'C')){
                    res += 90;
                    index++;
                }else{
                    res += RoToIntMap.get(cur); //1000 + 400 +      
                }
            }else if(cur == 'I'){
                 if(((index+1) < n)  && (s.charAt(index+1) == 'V')){
                    res += 4;
                    index++;
                }else if(((index+1) < n) && (s.charAt(index+1) == 'X')){
                    res += 9;
                    index++;
                }else{
                    res += RoToIntMap.get(cur); //1000 + 400 +      
                }
            }else{
                res += RoToIntMap.get(cur); //1000 + 400 +      
            }
            index++;
        }
        
        return res; 
    }

    //3rd try -- improved answer
    public int romanToInt4(String s) {
        //first create a map
        
        //key: Roman,  value: Integer
        Map<Character,Integer> RoToIntMap = new HashMap<>(); 
        
        RoToIntMap.put('I', 1); // 4, 9 
        RoToIntMap.put('V', 5);
        RoToIntMap.put('X', 10); // 40, 90 
        RoToIntMap.put('L', 50);
        RoToIntMap.put('C', 100); // 400, 900 
        RoToIntMap.put('D', 500);
        RoToIntMap.put('M', 1000);
        
        int index = 0; 
        int res = 0; 
        int n = s.length();
        
        int prev = 0; 
        
        while(index < n){
            int cur = RoToIntMap.get(s.charAt(index));
            //The key is here !!! if prevsiou value is smaller than current, we need substrat it twice ! 
            if(prev < cur){
                res += cur - prev * 2;
            }else{
                res += cur; 
            }
            prev = cur; 
            index++;
        }
        
        return res; 
    }
    


    //added online solution 
    static int number(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int romanToIntSol(String s) {
        int ans = 0, prev = 0;
        for (char c : s.toCharArray()) {
            int num = number(c);
            if (prev < num) {
                ans = ans - prev;
                ans += num - prev;
            } else {
                ans += num;
            }
            prev = num;

        }
        return ans;
    }

    //Another online solution
    //the key is: The logic here is that, if a current character value is greater than that of the previous, we have to subtract it. 
    // We subtract twice, because previously iteration had blindly added it. :) Hope this helps.
    public int romanToInt(String str) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for(char s : str.toCharArray()) {
            if(a[s - 'A'] > a[prev - 'A']) {
                sum = sum - 2 * a[prev - 'A'];
            }
            sum = sum + a[s - 'A'];
            prev = s;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger sol = new RomanToInteger();
        assert sol.romanToInt("III") == 3 : "III failed";
        assert sol.romanToInt("IV") == 4 : "IV failed";
        assert sol.romanToInt("IX") == 9 : "IX failed";
        assert sol.romanToInt("LVIII") == 58 : "LVIII failed";
        assert sol.romanToInt("MCMXCIV") == 1994 : "MCMXCIV failed";
    }
}
