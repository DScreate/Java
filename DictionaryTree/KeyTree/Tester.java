/**
 * 
 */
package KeyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Derek Sams
 *
 */
public class Tester {
	public static void main(String[] args) {
		boolean exit = false;
		NumTree myTree = new NumTree();
      java.util.Scanner fin = new java.util.Scanner("dictionary.txt");
      
		java.util.Scanner kb = new java.util.Scanner(System.in);
		DictHashTable dHash = new DictHashTable("dictionary.txt");
		DictPrefixTree preTree = new DictPrefixTree("dictionary.txt");
		
		while(!exit) {			
			
			
			System.out.println("Keypad Simulator! Please input any combination of 2-9 to process or enter 0 to exit.");
			


			try {
				String kbIn = kb.nextLine();
				
				if(kbIn.contains("0")) {
					System.out.println("0 detected, exiting...");
					exit = true;
					break;
				}
				
				if(kbIn.contains("1")) {
					System.out.println("1 detected, invalid input");
				} else {
				
					kbIn = kbIn.replaceAll(",", "");
					kbIn = kbIn.replaceAll(" ", "");

					List<String> wordList = myTree.combiner(kbIn, myTree.root());
					
					System.out.println("Testing against Hash table Dictionary:");
					for(String word : wordList) {
						if(dHash.isWord(word))
							System.out.print(" " + word + " ");
					}
					System.out.println();

					
					System.out.println("Testing against Tree Dictionary:");
					for(String word : wordList) {
						if(preTree.isWord(word))
							System.out.print(" " + word + " ");
					}
	
					System.out.println();
					
				}
			
			} catch (NumberFormatException e) {
				System.out.println(e.toString());
				System.out.println(e.getMessage());
				exit = true;
			}
			
			
		}
		
		kb.close();
		
	}
	
	private static List<String> solverTree(String digits) {
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
	
	private static void helper(List<String> result, StringBuilder sb, String digits, int index, TreeMap<Character, char[]> map){
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
