import java.util.ArrayList;

import java.util.List;

public class WordSearchII {
    // 212 Word Search II
    // https://leetcode.com/problems/word-search-ii/

    // class TrieNode { //this trie is too compliated
    // private Map<Character, TrieNode> children;
    // private boolean isword;

    // public TrieNode() {
    // this.children = new HashMap<>();
    // }

    // public Map<Character, TrieNode> getChildren() {
    // return this.children;
    // }

    // public void setChildren(Map<Character, TrieNode> children) {
    // this.children = children;
    // }

    // public boolean isWord() {
    // return this.isword;
    // }

    // public void setIsWord(boolean value) {
    // this.isword = value;
    // }

    // }

    int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }; // right, down, left, up
    int nRow, nCol;

    // didn't work, can't figure it out
    public List<String> findWords(char[][] board, String[] words) {
        // 1, DFS search to see if there is a valid path for each word ?
        // 2, Trie ?

        nRow = board.length;
        nCol = board[0].length;

        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[nRow][nCol];

        for (String word : words) {
            int[] index = boardIndex(board, word.charAt(0));

            System.out.println(index[0] + " " + index[1]);
            // check the starting letter, if it not even in the Matrix, there is no way it
            // gonna work.
            // this not gonna work, "i" could start from multipler places. (use map instead
            // Map<char,List<int[]>> charToLocation --> )
            if (index[0] < 0) {
                continue;
            }

            if (checkWord(board, word, index)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean checkWord(char[][] board, String word, int[] index) {

        return false;
    }

    private int[] boardIndex(char[][] board, char c) {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (board[i][j] == c) {
                    return new int[] { i, j };
                }
            }
        }
        // not in the matrix
        return new int[] { -1, -1 };
    }

    // -----------------Working solution---------
    // https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        // 1, DFS search to see if there is a valid path for each word ?
        // 2, Trie ?

        nRow = board.length;
        nCol = board[0].length;

        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            // reset p back to the root for each word
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a'; // a-z --> 0-25 value
                // if the next trie doesn't exists, add new TrieNode
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                // set next
                p = p.next[i];
            }
            p.word = w;
        }

        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j]; // starting point, will use for backtracking later

        // if visited & reached the end of TrieNode
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }

        // keep trying for next level deep
        p = p.next[c - 'a'];
        // found a valid word
        if (p.word != null) {
            res.add(p.word);
            p.word = null; // de-duplicate (remove already found value)
        }

        board[i][j] = '#'; // backtracking (set this one to '#' as visited)
        // for (int[] dirs : DIRS) {} might not working here
        if (i > 0) {
            dfs(board, i - 1, j, p, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, p, res);
        }
        if (i < nRow - 1) {
            dfs(board, i + 1, j, p, res);
        }

        if (j < nCol - 1) {
            dfs(board, i, j + 1, p, res);
        }

        board[i][j] = c; // backtracking reset the value back to c
    }

    public static void main(String[] args) {
        String abc = "abcdefghijklmnopqrstuvwxyz";

        for (char c : abc.toCharArray()) {
            System.out.println(c - 'a');
        }
    }
}
