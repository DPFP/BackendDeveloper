import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ScratchPad {
    public static void main(String[] args) {

        // Test ++ --
        int num = 10;
        System.out.println(num++); // 10 (print and then add 1)
        System.out.println(num); // 11 (print 10+1 )
        num = 10;
        System.out.println(++num); // 11 (add 1 then print )
        num = 10;
        System.out.println(num--); // 10 (print and then minus 1)
        num = 10;
        System.out.println(--num); // 9 (minus 1 and then print)

        // Test priorityQueue
        System.out.println("--------PQ---Test");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(9);
        pq.add(11);

        pq.forEach(x -> System.out.println(x));

        List<Integer> l1 = new ArrayList<Integer>();

        l1.add(10);
        l1.add(9);
        l1.add(11);

        System.out.println("--------Sort---Test");
        l1.forEach(x -> System.out.print(x + " "));
        System.out.println("--------Sort---Test");
        Collections.sort(l1);
        Collections.reverse(l1);
        l1.forEach(x -> System.out.println(x + " "));

        // String
        String sentence = "hello world";

        System.out.println("------------------------------");
        System.out.println(Character.toChars(48));
        System.out.println(Character.toChars(49));
        System.out.println(Character.forDigit('b', 10));
        System.out.println((int) 'a'); // a-z is 97 - 122 //A-Z is 65 - 90

        int shift = 3;
        for (int i = 0; i < 10; i++) {    
            System.out.println(i + " : shift 3 mod 10 " + (shift + i) % 10);
        }


        String numbers = "1234567890";
        for(char c : numbers.toCharArray()){
            if(Character.isDigit(c)){
                System.out.println("value:" + c + ": ascii " + (int)c);
                System.out.println(Character.getNumericValue(c));
            }
        }

        int inToChar = 10; 
        System.out.println("Convert " + (char) inToChar );

        int a = '1';
        char b = (char) a;
        System.out.println(b);
    }
}
