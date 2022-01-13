import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaComparator {
    public static void main(String[] args) {
        List<Player> fbt = new ArrayList<>();
        Player p1 = new Player(59, "59-John", 20);
        Player p2 = new Player(67, "67-Roger", 19);
        Player p3 = new Player(45, "45-Steven", 24);

        fbt.addAll(Arrays.asList(p1, p2, p3));

        System.out.println("Before sorting: " + fbt);

        PlayerRankingComparator playerComparator = new PlayerRankingComparator();
        PlayerAgeComparator playerAgeComparator = new PlayerAgeComparator();

        // Java 8 --
        Comparator<Player> byRanking = (Player player1, Player player2) -> Integer.compare(player1.getRanking(),
                player2.getRanking());
        Comparator<Player> byRanking2 = Comparator.comparing(Player::getRanking);
        Comparator<Player> byAge = Comparator.comparing(Player::getAge);

        // have to have <Player> class implements the "Comparable" interface
        // otherwise will getting a compiler time error
        Collections.sort(fbt);
        System.out.println("after sorting by ranking(default): " + fbt);

        // or you can actually passing a comparator
        // (if you don't/won't able to modify the data class)
        Collections.sort(fbt, byAge);

        System.out.println("after sorting by age (cutom Comparator): " + fbt);
    }
}

class PlayerRankingComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {

        // Not recommended using this , due to potential int overflow
        // return o1.getRanking() - o2.getRanking();

        // use te following instead;
        return Integer.compare(o1.getRanking(), o2.getRanking());
    }
}

class PlayerAgeComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class Player implements Comparable<Player> {
    private String name;
    private int age;
    private int ranking;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public int compareTo(Player o) {
        // compare(x,y) return -1 if x < y; return 0 if x == y; return 1 otherwise
        return Integer.compare(getRanking(), o.getRanking());
    }
}