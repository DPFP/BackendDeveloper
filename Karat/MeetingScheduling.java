import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MeetingScheduling {
    public static void main(String[] argv) {
        String[][] prereqsCourses1 = {
                { "Foundations of Computer Science", "Operating Systems" },
                { "Data Structures", "Algorithms" },
                { "Computer Networks", "Computer Architecture" },
                { "Algorithms", "Foundations of Computer Science" },
                { "Computer Architecture", "Data Structures" },
                { "Software Design", "Computer Networks" }
        };

        String[][] prereqsCourses2 = {
                { "Algorithms", "Foundations of Computer Science" },
                { "Data Structures", "Algorithms" },
                { "Foundations of Computer Science", "Logic" },
                { "Logic", "Compilers" },
                { "Compilers", "Distributed Systems" },
        };

        String[][] prereqsCourses3 = {
                { "Data Structures", "Algorithms" }
        };

        System.out.println(findHalfway(prereqsCourses3));
    }

    // https://www.1point3acres.com/bbs/thread-878358-1-1.html
    public static String findHalfway(String[][] courses) {
        LinkedList<String> lst = new LinkedList<>();
        int x = courses.length;
        // assume there is always records.
        // "Data Structures" -> "Algorithms" -> "Foundations of Computer Science" ->
        // "Operating Systems"
        Map<String, String> ba = new HashMap<>();
        Map<String, String> ab = new HashMap<>();
        for (int i = 0; i < x; i++) {
            String before = courses[i][0];
            String after = courses[i][1];
            ba.put(before, after);
            ab.put(after, before);
        }

        lst.add(courses[0][0]);
        lst.add(courses[0][1]);

        for (int j = 1; j < x; j++) {
            String head = lst.getFirst();
            String tail = lst.getLast();
            if (ab.get(head) != null) {
                lst.addFirst(ab.get(head));
            }
            if (ba.get(tail) != null) {
                lst.addLast(ba.get(tail));
            }
        }

        return lst.get(x / 2);
    }
}
