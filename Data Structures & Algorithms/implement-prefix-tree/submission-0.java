public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

/*
Time & Space Complexity
Time complexity: O(n)  for each function call.
Space complexity: O(t) 

Where n is the length of the string and 
t is the total number of TrieNodes created in the Trie.
*/
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null ){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null ){
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null ){
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}
