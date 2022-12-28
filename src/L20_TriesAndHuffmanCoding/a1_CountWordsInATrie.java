package L20_TriesAndHuffmanCoding;
/*
Count Words in Trie
Send Feedback
You are given the Trie class with following functions -
1. insertWord
2. removeWord
Now, you need to create one more function (named "countWords" ) which returns the number of words currently present in Trie in O(1) time complexity.
Note : You can change the already given functions in the Trie class, if required.

 */


public class a1_CountWordsInATrie {

    private TrieNode root;
    private int numWords;

    public a1_CountWordsInATrie() {
        root = new TrieNode('\0');
        numWords = 0;
    }

    public void remove(String word){
        if(remove(root, word)) {
            numWords--;
        }
    }


    private boolean remove(TrieNode root, String word) {
        if(word.length() == 0){
            if(root.isTerminating) {
                root.isTerminating = false;
                return true;
            }
            else {
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        boolean ans = remove(child, word.substring(1));
        // We can remove child node only if it is non terminating and its number of children are 0

        if(!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
        return ans;
    }

    private boolean add(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminating) {
                return false;
            }
            else {
                root.isTerminating = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return add(child, word.substring(1));
    }

    public void add(String word){
        if(add(root, word)) {
            numWords++;
        }
    }

    public int countWords() {
        return numWords;
    }

}