import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InvalidTransactions {
    // A transaction is possibly invalid if:
    // the amount exceeds $1000, or;
    // if it occurs within (and including) 60 minutes of another transaction with
    // the same name in a different city.

    // "alice,20,800,mtv",

    public List<String> invalidTransactions(String[] transactions) {
        // Map not gonna work
        Map<String, LinkedList<String[]>> validMap = new HashMap<>();
        Map<String, LinkedList<String[]>> invalidMap = new HashMap<>();
        Iterator<String[]> it;
        String[] temp;

        for (String s : transactions) {
            // if amount exceed 1000
            String[] transaction = s.split(",");

            if (Integer.valueOf(transaction[2]) > 1000) {
                // TODO -- this will not add the transaction to the linkedlist
                invalidMap.getOrDefault(transaction[0], new LinkedList<>()).add(transaction);
            } else {
                validMap.getOrDefault(transaction[0], new LinkedList<>()).add(transaction);
            }

            // if within 60 mins. same name, different city. (both are invlaid)
            it = validMap.getOrDefault(transaction[0], new LinkedList<>()).iterator();

            while (it.hasNext()) {
                temp = it.next();
                if (Math.abs(Integer.valueOf(temp[1]) - Integer.valueOf(transaction[1])) < 60
                        && !temp[3].equals(transaction[3])) {
                    invalidMap.get(transaction[0]).add(transaction);
                } else {
                    validMap.getOrDefault(transaction[0], new LinkedList<>()).add(transaction);
                }
            }

            // for (String temp : validMap.get(transaction[0])) {

            // }
        }
        System.out.println(invalidMap.toString());

        return null;
    }

    public static void main(String[] args) {
        InvalidTransactions sol = new InvalidTransactions();
        String[] t1 = { "alice,20,800,mtv", "alice,50,100,beijing" };

        sol.invalidTransactions(t1);
    }
}
