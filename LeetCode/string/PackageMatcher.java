import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://leetcode.com/discuss/interview-question/1367405/Shopify-Coding-On-Site-(Package-Matcher)/1083896
public class PackageMatcher {

    private static Map<String, Map<String, Integer>> boxingInfo = new HashMap<>();

    static {
        //- Camera (identifier: Cam): one can fit in a medium box, and up to two can fit in a large box
        Map<String, Integer> cameraBoxing = Stream.of(new Object[][] { { "M", 1 }, { "L", 2 } })
                .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        //- Gaming Console (identifier: Game): too big for a medium box, but up to two can fit in a large box
        // max of 2 g consoles can fit in 1 box
        Map<String, Integer> gameBoxing = Stream.of(new Object[][] { { "M", 0 }, { "L", 2 } })
                .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        //- Bluetooth speaker (identifier: Blue): one can fit in a large box . max is 1 per large box
        Map<String, Integer> blueBoxing = Stream.of(new Object[][] { { "M", 0 }, { "L", 1 } })
                .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        boxingInfo.put("Cam", cameraBoxing);
        boxingInfo.put("Game", gameBoxing);
        boxingInfo.put("Blue", blueBoxing);
    }

    public static void main(String[] args) {
        String[] input = new String[] { "Cam", "Game" };
        PackageMatcher pm = new PackageMatcher();
        List<Map<String, List<String>>> output = pm.matchPackages(input);
        System.out.println(output);
    }

    private List<Map<String, List<String>>> matchPackages(String[] input) {
        List<Map<String, List<String>>> output = new ArrayList<>();

        Map<String, Integer> typeToQuantity = new LinkedHashMap<String, Integer>();

        //calculate all the type and its quantity from input
        Arrays.stream(input).forEach(inp -> {
            if (typeToQuantity.containsKey(inp)) {
                typeToQuantity.put(inp, typeToQuantity.get(inp) + 1);
            } else {
                typeToQuantity.put(inp, 1);
            }
        });

        //Loop through all the item, find the matching box info
        for (Map.Entry<String, Integer> entry : typeToQuantity.entrySet()) {
            findPackages(entry.getKey(), entry.getValue(), boxingInfo.get(entry.getKey()), output);
        }
        return output;
    }

    private void findPackages(String type, int quantity, Map<String, Integer> boxingInfo,
                              List<Map<String, List<String>>> output) {
        if (quantity <= 0) {
            return;
        }

        if (quantity <= boxingInfo.get("M")) {
            // fit all the items in medium box
            List<String> values = new ArrayList<String>();
            for (int i = 0; i < quantity; i++) {
                values.add(type);
            }
            output.add(Collections.singletonMap("M", values));
        } else {
            int count = Math.min(quantity, boxingInfo.get("L"));
            // fit the required items in large box first
            List<String> values = new ArrayList<String>();
            for (int i = 0; i < count; i++) {
                values.add(type);
            }
            output.add(Collections.singletonMap("L", values));

            //recursively keep find the matching packages
            findPackages(type, quantity - count, boxingInfo, output);
        }
    }
}