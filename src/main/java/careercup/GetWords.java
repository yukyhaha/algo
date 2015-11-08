package main.java.careercup;

import java.util.ArrayList;

/*
 * http://www.careercup.com/question?id=5651322294501376
 * Given an infinite stream of characters and a list L of strings, create a 
 * function that calls an external API when a word in L is recognized during
 *  the processing of the stream. 

Example: 
L = ["ok","test","one","try","trying"] 
stream = a,b,c,o,k,d,e,f,t,r,y,i,n,g............. 

the call to external API (let's call it some function callAPI()) would be 
called when the 'k' is encountered, again when the 'y' is encountered, 
and again at 'g'.
 * */
public class GetWords {
		
	public GetWords(){}
	
	public TrieNode createTrie(String[] list){
		TrieNode root = new TrieNode('.');
		TrieNode n;
		for(int i = 0; i < list.length; i ++){
			n = root;
			for(int j = 0; j < list[i].length(); j ++){
				char c = list[i].charAt(j);
				if(n.children[c - 97] == null){
					n.children[c - 97] = new TrieNode(c);
				}
				if(j == list[i].length() - 1){
					n.children[c - 97].isLeaf = true;
				}
				n =n.children[c - 97];
			}
		}
		return root;
	}
	
	public void doGetWords(String[] list, Character[] stream){
		TrieNode root = createTrie(list);
		ArrayList<TrieNode> arr = new ArrayList<TrieNode>();
		for(int i = 0; i < stream.length; i ++){
			int arrSize = arr.size();
			boolean flag = false;
			for(int j = arrSize - 1; j >= 0; j --){
				TrieNode node = arr.get(j);
				if(node.children[stream[i] - 97] != null){
					arr.set(j, node.children[stream[i] - 97]);
					if(node.children[stream[i] - 97].isLeaf && !flag){
						System.out.println(stream[i]);
						flag = true;
					}
				}else{
					arr.remove(j);
				}
			}
			
			if(root.children[stream[i] - 97] != null){
				arr.add(root.children[stream[i] - 97]);
				if(root.children[stream[i] - 97].isLeaf){
					System.out.println(stream[i]);
				}
			}
		}
	}
	
	public static void main(String args[]){
		GetWords test = new GetWords();
		String[] list = {"abc","bcd", "cdef"};
		Character[] stream = {'a','b','c','d','e','f'};
		test.doGetWords(list, stream);
	}

}
