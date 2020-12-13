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

        for (String s : transactions) {
            // if amount exceed 1000
            String[] transaction = s.split(",");
            LinkedList<String[]> tempLinkedList = new LinkedList<>();

            if (Integer.valueOf(transaction[2]) > 1000) {
                // TODO -- this will not add the transaction to the linkedlist
                tempLinkedList = invalidMap.getOrDefault(transaction[0], new LinkedList<>());
                tempLinkedList.add(transaction);
                invalidMap.put(transaction[0], tempLinkedList);
            } else {
                tempLinkedList = validMap.getOrDefault(transaction[0], new LinkedList<>());
                tempLinkedList.add(transaction);
                validMap.put(transaction[0], tempLinkedList);
            }

            // can't do this, because ConcurrentModificationException
            // while (it.hasNext()) {
            // String[] nextTran = it.next();
            // LinkedList<String[]> temp;

            // if (Math.abs(Integer.valueOf(nextTran[1]) - Integer.valueOf(transaction[1]))
            // < 60
            // && !nextTran[3].equals(transaction[3])) {
            // // add to the invalidMap
            // temp = validMap.get(transaction[0]);
            // temp.add(transaction);
            // temp.add(nextTran);
            // invalidMap.put(transaction[0], temp);

            // // remove from the validMap
            // temp = validMap.get(transaction[0]);
            // temp.remove(nextTran);
            // it.remove();
            // validMap.put(transaction[0], temp);
            // }
            // }
            LinkedList<String[]> current = validMap.getOrDefault(transaction[0], new LinkedList<>());

            // Deadloop
            for (int i = 0; i < current.size(); i++) {
                String[] nextTran = validMap.get(transaction[0]).get(i);

                LinkedList<String[]> temp;

                // if within 60 mins. same name, different city. (both are invlaid)
                if (Math.abs(Integer.valueOf(nextTran[1]) - Integer.valueOf(transaction[1])) < 60
                        && !nextTran[3].equals(transaction[3])) {
                    // add to the invalidMap
                    temp = validMap.get(transaction[0]);
                    temp.add(nextTran);
                    invalidMap.put(transaction[0], temp);

                    // remove from the validMap
                    temp = validMap.get(transaction[0]);
                    temp.remove(transaction);
                    validMap.put(transaction[0], temp);
                }
            }
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
