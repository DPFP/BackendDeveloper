/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;
import java.math.BigDecimal;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Item {
    private String name;
    private int rank;
    private BigDecimal price;

    public Item(String name, int rank, BigDecimal price) {
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return this.rank;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

}

class ComparatorSolution {

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {
        // TODO How to sort the List<String[]> without create addition Entityt ? (POJO)

        List<String[]> test = new ArrayList<>();
        test.add(new String[] { "A", "30", "200" });
        test.add(new String[] { "AB", "1", "999" });
        test.add(new String[] { "ABC", "10", "199" });

        List<Item> items = new ArrayList<>();
        for (String[] s : test) {
            Item item = new Item(s[0], Integer.valueOf(s[1]), new BigDecimal(s[2]));
            items.add(item);
            System.out.println(s[0] + " " + s[1] + " " + s[2]);
        }

        ComparatorSolution sol = new ComparatorSolution();

        List<String> res = sol.getItems(items);

        for (String s : res) {
            System.out.println(s);
        }

    }

    private List<String> getItems(List<Item> items) {
        List<String> res = new LinkedList<>();

        // Comparator<List<String[]>> c = Comparator.comparing(List<String[]>::a[1]);
        // Collections.sort(input, (a,b)->
        // Integer.compare(Integer.valueOf(a[1]),Integer.valueOf(b[1])));
        // Collections.sort(input, (a,b)->
        // Integer.compare(Integer.valueOf(a[2]),Integer.valueOf(b[2])));
        // input.sort(new MyComparator());
        // input.sort((a,b)->a[2].compareTo(b[2]));

        // manually sort by Rank only;
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.getRank(), o2.getRank());
            }
        });

        // manually sort by Rank & price

        // items.sort(new Comparator<Item>() {
        // @Override
        // public int compare(Item o1, Item o2) {
        // if (Integer.compare(o1.getRank(), o2.getRank()) == 0) {
        // return o1.getPrice().compareTo(o2.getPrice());
        // } else {
        // return Integer.compare(o1.getRank(), o2.getRank());
        // }
        // }
        // });

        items.sort(Comparator.comparing(Item::getRank).thenComparing(Item::getPrice));
        // the same
        Collections.sort(items, Comparator.comparing(Item::getRank).thenComparing(Item::getPrice));
        // Collections.reverse(items);

        for (Item item : items) {
            res.add(item.getName());
        }

        return res;
    }
}
