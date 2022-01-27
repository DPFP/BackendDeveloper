import java.util.HashMap;

class Trie {

    // 208 Implement Trie (Prefix Tree)
    // https://leetcode.com/problems/implement-trie-prefix-tree/

    // soution from
    // https://www.baeldung.com/trie-java
    public class TrieNode {
        private HashMap<Character, TrieNode> children;
        // private String content;
        private boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getChildren() {
            return this.children;
        }

        public void setEndOfWord(boolean val) {
            this.isWord = val;
        }

        public boolean isEndOfWord() {
            return this.isWord;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;

        for (char c : word.toCharArray()) {
            // notice here with computeIfAbsent instead of putIfAbsent
            // if node.getChildren().get(c) already existed, then add it to the children;
            // otherwise, add new TrieNode;
            // noticed it is return the computed value, in this case is the new "TrieNode";
            // to the "node"
            node = node.getChildren().computeIfAbsent(c, n -> new TrieNode());
        }
        node.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode node = this.root;

        for (char ch : word.toCharArray()) {
            // get the children TrieNode based on "character"
            TrieNode cur = node.getChildren().get(ch);
            if (cur == null) {
                return false;
            }
            // Notice: we set the "node" to current node before next iteration
            node = cur;
        }
        return node.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode cur = node.getChildren().get(ch);
            if (cur == null) {
                return false;
            }
            // Notice: we set the "node" to current node before next iteration
            node = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("word");
        System.out.println(trie.search("word"));
        System.out.println(trie.startsWith("wor"));
    }
}