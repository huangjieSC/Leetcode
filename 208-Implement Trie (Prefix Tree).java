class TrieNode {
    // Initialize your data structure here.
        char content;
        boolean isEnd;
        int count;
        LinkedList<TrieNode> childList;
        
        public TrieNode(){
            childList = new LinkedList<TrieNode>();
            isEnd = false;
            content = ' ';
            count = 0;
        }
        
        public TrieNode(char c){
            childList = new LinkedList<TrieNode>();
            isEnd = false;
            content = c;
            count = 0;
        }
        
        public TrieNode subNode(char c){
            if(childList!=null){
                for(TrieNode aChild:childList){
                    if(aChild.content==c)
                        return aChild;
                }
            }
            return null;
        }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word)) return;
        
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child!=null) 
                current = child;
            else{
                current.childList.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            if(current.subNode(ch)==null) return false;
            else current = current.subNode(ch);
        }
        if(current.isEnd) return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()){
            if(current.subNode(ch)==null) return false;
            else current = current.subNode(ch);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
