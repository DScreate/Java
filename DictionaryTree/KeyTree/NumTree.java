/**
 * 
 */
package KeyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;



/**
 * @author Derek
 *
 */
public class NumTree {
	private int size;
	private int maxSize;
	private GTNode root;
	private int[] myNums;
	
	public NumTree(int[] input) {
		
		this.size = 0;
		this.root = new GTNode("");
		maxSize = input.length;
		myNums = input;

	}
	
	public NumTree() {
		this.size = 0;
		this.root = new GTNode("");
		
	}
	

	
	public GTNode root() {
		return this.root;
	}
	

		
	public List<String> combiner(String digits, GTNode cur) {
	    TreeMap<Character, char[]> map = new TreeMap<Character, char[]>();	 
	    
	    map.put('2', new char[]{'a','b','c'});
	    map.put('3', new char[]{'d','e','f'});
	    map.put('4', new char[]{'g','h','i'});
	    map.put('5', new char[]{'j','k','l'});
	    map.put('6', new char[]{'m','n','o'});
	    map.put('7', new char[]{'p','q','r','s'});
	    map.put('8', new char[]{'t','u','v'});
	    map.put('9', new char[]{'w','x','y','z'});
	 
	    List<String> result = new ArrayList<String>();
	    if(digits.equals(""))
	        return result;
	 
	    helper(result, new StringBuilder(), digits, 0, map);
	 
	    return result;
	 
	}
	
	public static void helper(List<String> result, StringBuilder sb, String digits, int index, TreeMap<Character, char[]> map){
	    if(index>=digits.length()){
	        result.add(sb.toString());
	        return;
	    }
	 
	    char c = digits.charAt(index);
	    char[] arr = map.get(c);
	 
	    for(int i=0; i<arr.length; i++){
	        sb.append(arr[i]);
	        helper(result, sb, digits, index+1, map);
	        sb.deleteCharAt(sb.length()-1);
	    }
	}
			
}

	class GTNode {

		private Object value;
		private GTNode parent = null;
		TreeMap<Character, char[]> children;
		private GTNode rightSib;
		
		public GTNode(Object data) {
			this.value = data;
			this.children = new TreeMap<Character, char[]>();
		}
		
		public TreeMap<Character, char[]> getChildren() {
			return this.children;
		}
		
		public void setChildren(TreeMap<Character, char[]> newMap) {
			this.children = newMap;
		}
	
		
		public String toString() {
			return this.value.toString();
		}
		
		
		
		public Object value() {
			return this.value;
		}
	
		
		public boolean isLeaf() {
			return (this.children.isEmpty());
		}
	
		
		public GTNode parent() {
			return this.parent;
		}
	
		
		public char[] leftMostChild() {
			return children.get(0);
		}
	
		
		public GTNode rightSibling() {
			return this.rightSib;
		}
	
		
		public void setValue(Object value) {
			this.value = value;
			
		}
	
		
		public void setParent(GTNode par) {
			this.parent = (GTNode)par;
			
		}
		
		/*
	
		
		public void insertFirst(GTNode n) {
			if(this.children.isEmpty()) {
				this.children.add(0, n);
				n.setParent(this);
			}

			else if(!children.containsKey(n)) {
				GTNode original = this.leftMostChild();
				children.add(0, (GTNode) n);
				this.leftMostChild().rightSib = original;
				n.setParent(this);
			}
			
		}
	
		
		public void insertNext(TreeMap<> n) {

			
			if(this.children.isEmpty())
				insertFirst(n);
			
			
			else if(!children.containsKey(n)) {
				this.children.add(n);
				this.children.get(this.children.lastIndexOf(n) - 1).rightSib =
						this.children.get(this.children.lastIndexOf(n));
				n.setParent(this);
			}
			
		}
		*/
	
	}




