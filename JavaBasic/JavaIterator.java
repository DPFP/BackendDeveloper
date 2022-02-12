package JavaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JavaIterator {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.addAll(List.of("a", "b", "c"));

        Iterator<String> it = l.iterator();

        // can't do the follwing, it only can be called after .next()
        // it.remove();

        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
            if (next.equals("b")) {
                it.remove();
            }
        }

        it.forEachRemaining(System.out::println);

        // will not getting to here, as previous already consumed it ?
        while (it.hasNext()) {
            System.out.println(it.next() + " ? ");
        }

        //
        ListIterator<String> listIterator = l.listIterator();
        while (listIterator.hasNext()) {
            String nextWithIndex = l.get(listIterator.nextIndex());
            String next = listIterator.next();
            if ("REPLACE ME".equals(next)) {
                listIterator.set("REPLACED");
            }
        }
        listIterator.add("NEW");
        while (listIterator.hasPrevious()) {
            String previousWithIndex = l.get(listIterator.previousIndex());
            String previous = listIterator.previous();
            System.out.println(previous);
        }
    }
}