import java.util.List;
import java.util.*;

public class Sept18thExpressionAddOperators {
    private List<String> rst;
    private char[] num;
    private char[] exp;
    private int target;

    public List<String> addOperators(String num, int target) {
        this.num = num.toCharArray();
        this.rst = new ArrayList<>();
        this.target = target;
        this.exp = new char[num.length() * 2];
        dfs(0, 0, 0, 0);
        return rst;
    }

    private void dfs(int startIndex, int len, long preValue, long currRst) {
        if (startIndex == num.length) {
            if (currRst == target)
                rst.add(new String(exp, 0, len));
            return;
        }

        int index = startIndex;
        int operaIndex = len;
        if (index != 0) {
            ++len;
        }

        long n = 0;
        while (startIndex < num.length) {
            // 0X...
            if (num[index] == '0' && startIndex - index > 0) {
                break;
            }
            n = n * 10 + (num[startIndex] - '0');
            // too long
            if (n > Integer.MAX_VALUE) {
                break;
            }
            // copy exp
            exp[len++] = num[startIndex++];
            if (index == 0) {
                dfs(startIndex, len, n, n);
                continue;
            }
            exp[operaIndex] = '+';
            dfs(startIndex, len, n, currRst + n);
            exp[operaIndex] = '-';
            dfs(startIndex, len, -n, currRst - n);
            exp[operaIndex] = '*';
            dfs(startIndex, len, preValue * n, currRst - preValue + preValue * n);
        }
    }

    public static void main(String[] args) {
        Sept18thExpressionAddOperators test = new Sept18thExpressionAddOperators();
        System.out.println(test.addOperators("123", 6));

    }
}
