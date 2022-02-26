import java.io.*;
import java.util.*;

public class SecretSanta {
    private String COMMA_DELIMITER = ",";

    private HashMap<String, String> pairPeople(String filePath) {
        // Name:PairName, Name:PairName,Name:PairName
        HashMap<String, String> res = new HashMap<>();

        // read the input CSV file
        List<List<String>> input = readCSVFile(filePath);

        // Key: name, Value: List of disallowed name (don't want to receive gift form)
        Map<String, List<String>> disallowedMap = new HashMap<>();
        Set<String> recNameSet = new HashSet<>();
        Set<String> giverNameSet = new HashSet<>();

        // Populate the necessary data
        populatedTheData(input, disallowedMap, recNameSet, giverNameSet);

        // TODO Remove
        System.out.println("-disallowed list-");
        for (String name : disallowedMap.keySet()) {
            System.out.println(name + ":" + disallowedMap.get(name));
        }
        System.out.println("-----------");

        // find the pair using iterator
        Iterator<String> recNameIter = recNameSet.iterator();
        Iterator<String> giverNameIter = giverNameSet.iterator();

        boolean firstRecFlag = true;
        String firstRec = "";
        String giverName = "";

        while (recNameIter.hasNext()) {
            String recName = recNameIter.next();
            if (firstRecFlag) {
                firstRec = recName;
                firstRecFlag = false;
            }
            while (giverNameIter.hasNext()) {
                giverName = giverNameIter.next();
                // Rule #1, they can't give to self;
                // Rule #3, filter by disallowed name;
                if (!recName.equals(giverName) && isAllowedGiver(disallowedMap.get(recName), giverName)) {
                    // Rule #2, remove from the iterator ensure each person can only give or receive
                    // once;
                    // Rule #4, two people can't exchange
                    if (res.containsKey(giverName) && !res.get(giverName).equals(recName)) {
                        res.putIfAbsent(recName, giverName);
                        recNameIter.remove();
                    } else {
                        res.putIfAbsent(recName, giverName);
                        recNameIter.remove();
                        giverNameIter.remove();
                        break;
                    }
                }
            }
        }

        // Here is to handle the special case of the first Receiver & last Giver
        if (isAllowedGiver(disallowedMap.get(giverName), firstRec)) {
            res.put(giverName, firstRec);
        }

        return res;
    }

    private boolean isAllowedGiver(List<String> disallowedNames, String giverName) {
        for (String disallowed : disallowedNames) {
            if (disallowed.equals(giverName)) {
                return false;
            }
        }
        return true;
    }

    private void populatedTheData(List<List<String>> input,
            Map<String, List<String>> disallowedList,
            Set<String> recNameSet,
            Set<String> giverNameSet) {
        for (List<String> ls : input) {
            int size = ls.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    recNameSet.add(ls.get(0));
                    giverNameSet.add(ls.get(0));
                    disallowedList.putIfAbsent(ls.get(0), new ArrayList<>());
                }
                if (i > 1) {
                    disallowedList.get(ls.get(0)).add(ls.get(i));
                }
            }
        }
    }

    private List<List<String>> readCSVFile(String filePath) {
        List<List<String>> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER); // Make sure do this part
                input.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void main(String[] args) {
        SecretSanta secretSanta = new SecretSanta();

        for (int i = 1; i < 6; i++) {
            // TODO will need change the path accordingly
            String group = "/Users/charles/Downloads/Secret Santa/group" + i + ".csv";

            System.out.println(" --- check for group " + i + " ----");
            HashMap<String, String> res = secretSanta.pairPeople(group);
            // TODO remove -- display result
            for (String key : res.keySet()) {
                System.out.println("(Key)Receiver:" + key + " <--- Giver(Value): " + res.get(key));
            }
        }
    }
}
