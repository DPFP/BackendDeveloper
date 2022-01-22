import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // okay solution
    public boolean containsDuplicate2(int[] nums) {
        // set 1, contains; 2,length
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    // better solution
    public boolean containsDuplicate(int[] nums) {
        // set 1, contains; 2,length
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
