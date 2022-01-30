import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ScratchPad {
    public static void main(String[] args) {

        // Test ++ --
        int i = 10;
        System.out.println(i++); // 10 (print and then add 1)
        System.out.println(i); // 11 (print 10+1 )
        i = 10;
        System.out.println(++i); // 11 (add 1 then print )
        i = 10;
        System.out.println(i--); // 10 (print and then minus 1)
        i = 10;
        System.out.println(--i); // 9 (minus 1 and then print)

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
        l1.forEach(x -> System.out.print(x + " "));
    }
}
