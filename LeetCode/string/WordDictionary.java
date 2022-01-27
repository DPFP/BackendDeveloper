import java.util.HashMap;

class WordDictionary {

    // 211 Add and Search Word
    // https://leetcode.com/problems/add-and-search-word-data-structure-design/

    // good soltuion
    // https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/59669/Java-Solution-easy-understand

    // combined solution
    private TrieNode trie;

    public WordDictionary() {
        this.trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode root = this.trie;
        for (char c : word.toCharArray()) {
            // root.getChildren().computeIfAbsent(c, v -> new TrieNode());
            root = root.getChildren().computeIfAbsent(c, v -> new TrieNode());
        }
        root.setIsWord(true);
    }

    public boolean search(String word) {

        // TrieNode root =this.trie;

        // for(char c : word.toCharArray()){
        // TrieNode cur = root.getChildren().get(c);
        // if(cur == null){
        // return false;
        // }
        // root = cur;
        // }

        // return root.isWord();

        return searchHelper(this.trie, 0, word);
    }

    private boolean searchHelper(TrieNode node, int pos, String word) {
        if (pos == word.length()) {
            return node.isWord();
        }

        if (node.getChildren().size() == 0) {
            return false;
        }

        // if the character at current position is '.',
        // recursive check whether the remaing word is in the trie
        if (word.charAt(pos) == '.') {
            for (Character c : node.getChildren().keySet()) {
                if (searchHelper(node.getChildren().get(c), pos + 1, word)) {
                    return true;
                }
            }
        }

        // if character at position 'pos' is neither equal to the node nor '.', return
        // false
        if (!node.getChildren().containsKey(word.charAt(pos))) {
            return false;
        }

        // if character at current position matches the node,
        // recursively search the remaining word
        return searchHelper(node.getChildren().get(word.charAt(pos)), pos + 1, word);
    }

    class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getChildren() {
            return this.children;
        }

        public void setIsWord(boolean val) {
            this.isWord = val;
        }

        public boolean isWord() {
            return this.isWord;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */