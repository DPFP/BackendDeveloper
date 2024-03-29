package sequences;
public class ProductofArrayExceptSelf {
    // 238 Product of Array Except Self
    // https://leetcode.com/problems/product-of-array-except-self/

    // TLE :(
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product = product * nums[j];
                }
            }
            res[i] = product;
        }

        return res;
    }

    // solution based on NeedCode
    // similar approach
    // https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];

        // here is the default preFix product value
        int fix = 1;

        // from left -> right
        for (int i = 0; i < len; i++) {
            // Key: this will ensure res[2] = fix value of previous calculation (1 offset to
            // the right, res[1])
            res[i] = fix;

            // key - calculate the prefix product
            fix = fix * nums[i];
        }

        // reset fix (aka. PostFix product)
        fix = 1;

        // from right to left
        for (int i = len - 1; i >= 0; i--) {
            // Key: this will ensure res[3] = fix value of previous calculation (1 offset to
            // the left, res[4])
            res[i] = res[i] * fix;

            // key - calculate the postfix product for next round to use (essetially skip
            // nums[len-1] -> as it default to 1)
            fix = fix * nums[i];
        }

        return res;
    }

    // re-did 1/23
    public int[] productExceptSelf4(int[] nums) {
        // left preFix product & right preFix product

        int len = nums.length;
        int[] res = new int[len];

        int fix = 1; // probably should name this "fix" instead of pre, (it could be postFix)
        // res[0] = nums[0];

        // notice it start from 0
        // for(int i=1; i < len ; i++){
        for (int i = 0; i < len; i++) {
            // res[i] = pre * nums[i-1];
            // pre = res[i];
            res[i] = fix; // pre default is 1 (index -1)
            fix = fix * nums[i]; // calculate for next round;
            // System.out.print(res[i] + " ");
        }

        fix = 1; // index len
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * fix; // preFix * postFix ==> final result;
            fix = fix * nums[i]; // postFix result for the previous value;
        }

        return res;
    }

    // more concise version --> easy to find the pattern
    public int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp; // notice here just =
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp; // notice here with *=
            tmp *= nums[i];
        }
        return result;
    }
}
