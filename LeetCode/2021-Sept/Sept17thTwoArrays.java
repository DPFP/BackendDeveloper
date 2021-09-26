import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sept17thTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] intersectNOTCoverALl(int[] nums1, int[] nums2) {
        // Issue [4,9,5] [9,4,9,8,4]
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums1) {
            count.put(i, 0);
        }

        for (int i : nums2) {
            if (count.keySet().contains(i)) {
                count.put(i, count.get(i) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i : count.keySet()) {
            if (count.get(i) != 0) {
                for (int j = 0; j < count.get(i); j++) {
                    res.add(i);
                }
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = { 1, 2, 2, 1 };
        int[] array2 = { 2, 2 };
        Sept17thTwoArrays twoArrays = new Sept17thTwoArrays();

        int[] result = twoArrays.intersect(array1, array2);
        for (int i : result) {
            System.out.println(i);
        }

    }
}