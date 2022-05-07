public class Fib {

    private static int getFib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n < 4) {
            return 1;
        }

        return getFib(n - 2) + getFib(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(getFib(9));
    }
}
