/**
 * 
 */
package KeyTree;

import java.util.Scanner;

/**
 * @author Derek Sams
 *
 */
public abstract class Dictionary {
	
	public abstract void insert(String str);

	public abstract boolean isWord(String str);
	
	public abstract boolean hasWordPrefixed(String s);
	
	protected Scanner openFile(String fileName) {
		Scanner fin = null;
		
		try {
			fin = new Scanner(new java.io.File(fileName));
			
		} catch(java.io.FileNotFoundException e) {
			System.out.println(fileName + " not found!");
		}
		
		return fin;
	}
}
