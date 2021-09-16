public class Sept15thLongestTurbulentSubarray {

    // https://github.com/cherryljr/LeetCode/blob/master/Longest%20Turbulent%20Subarray.java
    public int maxTurbulenceSize(int[] arr) {

        int inc = 1, dec = 1, res = 1;
        for (int i = 1; i < arr.length; i++) { // ignored the first and last element
            if (arr[i] > arr[i - 1]) { // increase
                inc = dec + 1; // smart move
                dec = 1;
            } else if (arr[i] < arr[i - 1]) { // decrease
                dec = inc + 1; // smart move
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            res = Math.max(res, Math.max(inc, dec));
        }

        return res;
    }

    public static void main(String[] args) {
        Sept15thLongestTurbulentSubarray sol = new Sept15thLongestTurbulentSubarray();
        int[] t1 = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };

        System.out.println(sol.maxTurbulenceSize(t1));
    }
}
