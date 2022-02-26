package LeetCode.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecretSanta {
    private final static String COMMA_DELIMITER = ",";

    private HashMap<String, String> pairPeople(String filePath) {
        // 1st, read the input CSV file
        List<List<String>> input = readCSVFile(filePath);

        // 2nd, Populate the nameSet
        Set<String> nameSet = populatedNameSet(input);

        // 3rd, build the graph: receiverName --> allowed giver name list
        // Key: name, Value: Set of ALLOWED name (can receive gift from)
        Map<String, Set<String>> graph = populatedGraph(input, nameSet);

        // TODO remove -- show allowed list
        graph.keySet().stream().forEach(k -> System.out.println(k + ":" + graph.get(k)));
        System.out.println("-----------");

        // 4th, traverse the graph to find the possible matches
        LinkedList<String> possibleFullMatch = findPairs(graph);

        if (possibleFullMatch.size() == 0) {
            System.out.println("Sorry, not able to match everyone ! ");
            return new HashMap<>();
        }

        HashMap<String, String> res = new HashMap<>();

        // special case, make sure match the first with last person
        String first = possibleFullMatch.getFirst();
        String last = possibleFullMatch.getLast();
        res.put(last, first); // last --> lastGiver, first -->firstReceiver

        for (int i = 1; i < possibleFullMatch.size(); i++) {
            res.put(first, possibleFullMatch.get(i));
            first = possibleFullMatch.get(i);
        }

        return res;
    }

    private LinkedList<String> findPairs(Map<String, Set<String>> graph) {
        LinkedList<String> possibleFullPath = new LinkedList<>();

        LinkedList<String> path = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // traverse through each name to see if there is possible full-cycle;
        for (String recName : graph.keySet()) {
            traverse(graph, recName, path, visited, possibleFullPath);
        }

        return possibleFullPath;
    }

    private void traverse(Map<String, Set<String>> graph,
            String recName,
            LinkedList<String> path,
            Set<String> visited,
            LinkedList<String> possiblePath) {

        if (visited.contains(recName)) {
            return;
        }

        visited.add(recName);

        path.addLast(recName);
        // if those two size equal, we know we have matched everyone
        if (path.size() == graph.size()) {
            System.out.println("We able to get everyone paired !!! ");
            possiblePath.addAll(path);
            return;
        }

        for (String giverName : graph.get(recName)) {
            traverse(graph, giverName, path, visited, possiblePath);
        }

        path.removeLast();

    }

    private Set<String> populatedNameSet(List<List<String>> input) {
        Set<String> nameSet = new HashSet<>();
        for (List<String> ls : input) {
            nameSet.add(ls.get(0));
        }
        return nameSet;
    }

    private Map<String, Set<String>> populatedGraph(List<List<String>> input, Set<String> name) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> ls : input) {
            int len = ls.size();
            String recName = ls.get(0);
            graph.putIfAbsent(recName, new HashSet<>());

            // shallow copy; addAll() for deep copy
            Set<String> allowed = new HashSet<>(name);

            // Rule #1, they can't give to self;
            allowed.remove(ls.get(0));

            // from CSV input: ls[0] = name, ls[1] = email, ls[>2] = disallowed Names
            if (len > 2) { // if disallowed list is NOT empty --> remove those in the list
                for (int i = 2; i < len; i++) {
                    // Rule #3, filter by disallowed name;
                    allowed.remove(ls.get(i));
                }
            }
            graph.put(recName, allowed);
        }

        return graph;
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
                System.out.println("(Key)Receiver:" + key + " <--- (Value)Giver: " + res.get(key));
            }
        }
    }
}
