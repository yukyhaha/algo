package main.java.algo;

public class TrieNode {
	public TrieNode[] children =  new TrieNode[26];
	public char value;
	public boolean isLeaf = false;
	public TrieNode(char value){
		this.value = value;
	}
}
