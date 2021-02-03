import java.util.ArrayList;
import java.util.Arrays;

public class CompareVersionNumber {

    // BF approach -- memory usage could be improved
    public int compareVersionBF(String version1, String version2) {
        if (version1.isEmpty() || version2.isEmpty()) {
            return 0;
        }
        // clean the input --> only have pure version string
        // THIS part is not needed
        version1 = version1.substring(12, version1.length() - 1);
        version2 = version2.substring(12, version2.length() - 1);

        // separated by . array
        ArrayList<String> v1Token = new ArrayList<>(Arrays.asList(version1.split("\\.")));
        ArrayList<String> v2Token = new ArrayList<>(Arrays.asList(version2.split("\\.")));

        // fill in the length (0)
        while (v2Token.size() < v1Token.size()) {
            v2Token.add("0");
        }

        while (v1Token.size() < v2Token.size()) {
            v1Token.add("0");
        }

        // compare from higher to lower
        for (int i = 0; i < v1Token.size(); i++) {
            if (Integer.parseInt(v1Token.get(i)) > Integer.parseInt(v2Token.get(i))) {
                return 1;
            } else if (Integer.parseInt(v1Token.get(i)) < Integer.parseInt(v2Token.get(i))) {
                return -1;
            }
        }

        return 0;
    }

    // 2nd try to minimize memory
    public int compareVersion(String version1, String version2) {

        return 0;
    }

    // Online simple solution
    public int compareVersionOS(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int longest = Math.max(levels1.length, levels2.length);

        for (int i = 0; i < longest; i++) {
            // this how it saved memory. if length > i, that meanst this level do have
            // value. otherwise 0
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;

            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String t11 = "version1 = \"1.01\"";
        String t12 = "version2 = \"1.001\"";

        String t21 = "version1 = \"1.0\"";
        String t22 = "version2 = \"1.0.0\"";

        String t31 = "version1 = \"0.1\"";
        String t32 = "version2 = \"1.1\"";

        String t41 = "version1 = \"1.0.1\"";
        String t42 = "version2 = \"1\"";

        String t51 = "version1 = \"7.5.2.4\"";
        String t52 = "version2 = \"7.5.3\"";

        CompareVersionNumber sol = new CompareVersionNumber();

        assert sol.compareVersion(t11, t12) == 0 : "T1 Failed";
        assert sol.compareVersion(t21, t22) == 0 : "T2 Failed";
        assert sol.compareVersion(t31, t32) == -1 : "T3 Failed";
        assert sol.compareVersion(t41, t42) == 1 : "T4 Failed";
        assert sol.compareVersion(t51, t52) == -1 : "T5 Failed";
    }
}
