import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieRatings {
    public static void main(String[] argv) {

        String[][] ratings = {
                { "Alice", "Frozen", "5" },
                { "Bob", "Mad Max", "5" },
                { "Charlie", "Lost In Translation", "4" },
                { "Charlie", "Inception", "4" },
                { "Bob", "All About Eve", "3" },
                { "Bob", "Lost In Translation", "5" },
                { "Dennis", "All About Eve", "5" },
                { "Dennis", "Mad Max", "4" },
                { "Charlie", "Topsy-Turvy", "2" },
                { "Dennis", "Topsy-Turvy", "4" },
                { "Alice", "Lost In Translation", "1" }
        };

        System.out.println(movieRecommendation("Charlie", ratings));

        System.out.println(movieRecommendation("Bob", ratings));

    }

    // Write your function here

    // 1st, get the list of charlies movies
    // 2nd, find all other user/movies that in charlies list >= 4 List<Movie> -->
    // 3nd, get all other haven't watched movies (within the 2nd list >= 4)

    private static List<String> movieRecommendation(String name, String[][] ratings) {
        List<String> res = new ArrayList<>();
        // assume name always in list of ratings
        Set<String> userMovieList = new HashSet<>();

        for (String[] rating : ratings) {
            // e.g.{"Charlie", "Lost In Translation", "4"},
            // 1st -- user movie >= 4
            if (rating[0].equalsIgnoreCase(name) && (Integer.parseInt(rating[2]) > 3)) { //
                userMovieList.add(rating[1]);
            }
        }

        // 2.1,
        Set<String> names = new HashSet<>();
        for (String movie : userMovieList) {
            for (String[] rating : ratings) {
                if (rating[1].equalsIgnoreCase(movie) && (Integer.parseInt(rating[2]) > 3)) {
                    names.add(rating[0]);
                }
            }
        }

        // 2.2
        Set<String> potentialMovies = new HashSet<>();
        for (String n : names) {
            for (String[] rating : ratings) {
                if (rating[0].equalsIgnoreCase(n) && (Integer.parseInt(rating[2]) > 3)) {
                    potentialMovies.add(rating[1]);
                }
            }
        }
        // System.out.println("PMs:" + potentialMovies);a
        // System.out.println("UMs:" + userMovieList);

        // 3nd
        for (String pm : potentialMovies) {
            if (!userMovieList.contains(pm)) {
                res.add(pm);
            }
        }

        return res;
    }

}
