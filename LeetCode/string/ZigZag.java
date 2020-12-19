import java.util.ArrayList;
import java.util.List;

class ZigZag {

    // Official Solution
    // https://github.com/liweiwei1419/LeetCode-Solutions-in-Good-Style/blob/master/string/Java/0006-zigzag-conversion/src/Solution.java
    public String convert(String s, int numRows) {
        // 特判
        if (numRows < 2) {
            return s;
        }

        // 每一行初始化，每一行相当于一个链表
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int len = s.length();
        int index = 0;
        // 遍历每一个字符
        while (index < len) {
            // 先从上到下
            for (int i = 0; i < numRows && index < len; i++) {
                rows[i].append(s.charAt(index));
                index++;
            }
            // 再从下到上
            for (int i = numRows - 2; i > 0 && index < len; i--) {
                rows[i].append(s.charAt(index));
                index++;
            }
        }

        // 最后合起来
        for (int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }

    // mimic official solution
    public String convertMySolution(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int inputLength = s.length();
        int index = 0;

        while (index < inputLength) {
            for (int i = 0; i < numRows && index < inputLength; i++) {
                rows[i].append(s.charAt(index));
                index++;
            }
            for (int i = numRows - 2; i > 0 && index < inputLength; i--) {
                rows[i].append(s.charAt(index));
                index++;
            }
        }

        for (int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }

    public String convertMySolutionSecond(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int inputLength = s.length();
        int index = 0;
        while (index < inputLength) {
            // TODO try use mod
            for (int i = 0; i < numRows && index < inputLength; i++) {
                rows[i % numRows].append(s.charAt(index));
                index++;
            }
        }
        return null;
    }

    // LeetCode official solution #1
    // Approach 1: Sort by Row
    public String convertSolNoOne(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);

            // interesting part on when to switch direction
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // move up or down
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();

        // actuall don't need care about space.
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    // LeetCode official solution #1
    // Approach 2: Visit by Row
    public String convertSolNoTwo(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    // 2nd try 2020-12-18
    public String convert2nd(String s, int numRows) {
        // #1 convert S to ZigZag based on numRows

        // #2 convert ZigZag to String

        return null;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        ZigZag solution = new ZigZag();
        String convert = solution.convertMySolution(s, numRows);
        System.out.println(convert);
    }
}