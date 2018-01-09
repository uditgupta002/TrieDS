import java.util.*;
import java.lang.*;
import java.io.*;

class TrieInsertion {
    
    static final int ALPHABET_SIZE = 26;
    
    static class TrieNode {
        
        boolean isEndOfWord;
        TrieNode children[] = null;
        public TrieNode() {
            this.isEndOfWord = isEndOfWord;
            this.children = new TrieNode[ALPHABET_SIZE];
        }
    }
    
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		for(int test=0;test<tests;test++){
		    int N = Integer.parseInt(br.readLine());
		    TrieNode root = new TrieNode();
		    String temp[] = br.readLine().split(" ");
		    for(int i=0;i<N;i++) {
		        insert(root,temp[i]);
		    }
		    String testStr = br.readLine();
		    System.out.println(search(root,testStr) ? 1 : 0);
		}
	}
	
	private static void insert(TrieNode root,String key) {
	    
	    TrieNode currNode = root;
	    int index;
	    for(int i=0;i<key.length();i++){
	        index = key.charAt(i) - 'a';
	        if(currNode.children[index] == null){
	            currNode.children[index] = new TrieNode();
	        }
	        currNode = currNode.children[index];
	    }
	    currNode.isEndOfWord = true;
	}
	
	private static boolean search(TrieNode root, String key) {
	    
	    TrieNode currNode = root;
	    int index;
	    for(int i=0;i<key.length();i++) {
	        index = key.charAt(i) - 'a';
	        if(currNode.children[index] == null)
	            return false;
	        currNode = currNode.children[index];
	    }
	    return currNode.isEndOfWord;
	}
	
}
