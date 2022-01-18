import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
    // 271 Encode and Decode Strings (Leetcode Premium)
    // https://leetcode.com/problems/encode-and-decode-strings/

    // i really can't use any of those !!! because it within 256 ASCII table -- #FML

    // from LC discussion solution
    // https://leetcode.com/problems/encode-and-decode-strings/discuss/70412/AC-Java-Solution
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();

        // here is the index.
        // C: so, instead of "Two pointer", this is the one pointer
        int i = 0;

        while (i < s.length()) {
            // key is this part, get the index of slash
            int slash = s.indexOf('/', i); // why there is the i ? From Index
            int size = Integer.valueOf(s.substring(i, slash));

            // move the index;
            i = slash + size + 1;

            // anything after slash to the index point
            res.add(s.substring(slash + 1, i));
        }

        return res;
    }

    // another really good answer
    // https://leetcode.com/problems/encode-and-decode-strings/discuss/70402/Java-with-%22escaping%22
}
