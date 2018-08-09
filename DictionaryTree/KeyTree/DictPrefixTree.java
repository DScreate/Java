/**
 * 
 */
package KeyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Derek Sams
 *
 */
public class DictPrefixTree extends Dictionary {
	
	
	private class wordTrie {
		private tNode root = new tNode();
		
		public wordTrie() {
			this.root = new tNode();
		}
		
		public void insertString(tNode root, String str) {
			tNode cur = root;
			for(char ch : str.toCharArray()) {
				tNode next = cur.children.get(ch);;
				if(next == null)
					cur.children.put(ch, next = new tNode());
					
				cur = next;
				
			}
			
			cur.endPoint = true;
		}
	}
	
	public class tNode {
		char value;
		HashMap<Character, tNode> children;
		boolean endPoint; //the idea here is to be able to mark any given node as the endpoint for a word
						  //but still have the capability to continue on. So like the e in "home" would be marked as an endpoint
						  //even if is also continued on to make "homework"
		
		public tNode() {
			children = new HashMap<Character, tNode>();
		}
		
		public tNode(char ch) {
			this.value = ch;
			children = new HashMap<Character, tNode>();
		}
		
		
	}

	//private tNode root;	
	private wordTrie dTree;
	
	public DictPrefixTree(String fileName) {
		dTree = new wordTrie();


		Scanner fin = openFile(fileName);
		String temp = "";
		int count = 0;
		//while(1);
		while(fin.hasNextLine()) {
			temp += fin.nextLine();
			count++;
		}
		
		for(int i = 0; i < 10; i++) {  
			String s = Integer.toString(i);       
			temp = temp.replaceAll(s, "");
		}
		
		String[] words = temp.split(",");
		
		 for(String word : words)
			 dTree.insertString(dTree.root, word);

	}




	@Override
	public void insert(String str) {
		dTree.insertString(dTree.root, str);
	}
	
	@Override
	public boolean isWord(String str) {
		tNode cur = dTree.root;
			
		for(char ch: str.toCharArray()) {
			cur = cur.children.get(ch);
			if (cur == null) 
				return false;	
		}
		
		return cur.endPoint;
	}




	@Override
	public boolean hasWordPrefixed(String s) {
		// TODO Auto-generated method stub
		return false;
	}
}
