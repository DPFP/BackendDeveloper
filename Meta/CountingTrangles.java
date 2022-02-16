import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountingTrangles {
    class Sides {
        int a;
        int b;
        int c;

        Sides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // Add any helper functions you may need here

    // 1st try, this is a disaster .. was on the right direction
    int countDistinctTrianglesBad(ArrayList<Sides> arr) {
        // Write your code here
        // sort the arry and then compare (if the same, identical, otherwise, distinct);
        ArrayList<int[]> tempArrayList = new ArrayList<>();

        // convert Sides to int[]
        for (Sides sides : arr) {
            List<Integer> a = List.of(sides.a, sides.b, sides.c);
            Arrays.sort(a.toArray());
            // tempArraList.add(a);
        }
        int counter = 0;
        int len = tempArrayList.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // if (Arrays.compare(tempArrayList.indexOf(i), tempArrayList.indexOf(j))) {
                // counter++;
                // }
                // if(Arrays.equals(a, a2));
            }
        }

        return counter;
    }

    // 2nd try
    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        // use hashSet and sort arry
        Set<String> counterSet = new HashSet<>();

        for (int i = 0; i < arr.size(); i++) {
            Sides sides = arr.get(i);
            int[] temp = { sides.a, sides.b, sides.c };

            // key is to sort;
            Arrays.sort(temp);
            // and then encoding
            String triangle = Arrays.toString(temp);

            counterSet.add(triangle);
        }

        return counterSet.size();
    }

}
