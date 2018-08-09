/**
 * 
 */
package KeyTree;

import java.util.Hashtable;
/**
 * @author Derek Sams
 *
 */
public class DictHashTable extends Dictionary {
	
	public Hashtable<String, String> dictHash;
	
	public DictHashTable(String fileName) {
		int count = 0;
		String temp = "";
		
		java.util.Scanner fin = openFile(fileName);
		
		while(fin.hasNextLine()) {
			count++;
			temp+=fin.nextLine();
		}      		
		
		this.dictHash = new java.util.Hashtable<String, String>(count + 1);	
		
		for(int i = 0; i < 10; i++) {  
			String s = Integer.toString(i);       
			temp = temp.replaceAll(s, "");
		}
		
		String[] words = temp.split(",");
		
		 for(String word : words)
			 dictHash.put(word, word);
			 
	}
	
	public Hashtable<String, String> getTable() {
		return this.dictHash;
	}
	
	@Override
	public boolean isWord(String word) {		
		return dictHash.containsKey(word);
	}

	@Override
	public void insert(String str) {
		dictHash.put(str,  str);
	}

	@Override
	public boolean hasWordPrefixed(String s) {
		// TODO Auto-generated method stub
		return false;
	}



}
