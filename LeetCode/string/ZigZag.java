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

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        ZigZag solution = new ZigZag();
        String convert = solution.convertMySolution(s, numRows);
        System.out.println(convert);
        System.out.println(4 % 4);
    }
}