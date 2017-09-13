package hackerrank.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * HackerRank Question - Hash Tables: Ransom Note
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. 
 * He found a magazine and wants to know if he can cut out whole words from it 
 * and use them to create an untraceable replica of his ransom note. 
 * The words in his note are case-sensitive and he must use whole words available 
 * in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.
 * Given the words in the magazine and the words in the ransom note, 
 * print Yes if he can replicate his ransom note exactly using whole words from the magazine; 
 * otherwise, print No.
 * 
 * Input:
 * 6 4
 * give me one grand today night
 * give one grand today
 * 
 * Output:
 * Yes
 */
public class RansomNoteUsingHashTable {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNoteUsingHashTable(String magazine, String note) {
        this.magazineMap = new HashMap<String, Integer>();
        this.noteMap = new HashMap<String, Integer>();
        
        fillMap(magazine, magazineMap);
        fillMap(note, noteMap);
    }
    
    /*
     * fillMap: Generic method to fill both maps.
     * It stores the word as key and the word count as the
     * number of occurrences of that word in the sentence.
     */
    private void fillMap(String sentence, Map<String, Integer> wordMap) {
    	String words[] = sentence.split(" ");
    	for(int i = 0; i < words.length; i++){ 
    		if(wordMap.containsKey(words[i])){
    			int wordCount = wordMap.get(words[i]);
    			wordMap.put(words[i], wordCount + 1);
    		}else{
    			wordMap.put(words[i], 1);
    		}
    	}
	}

    /*
     * solve(): Computes Yes or No based on 2 conditions
     * 1. Whether the word from note is present in the magazine
     * 2. Whether the word-count of a particular word in the note
     * 	  is less than or equal to the total word-count of that word in the magazine.
     */
	public boolean solve() {
		for(Entry<String, Integer> entrySet: noteMap.entrySet()){
			if(!magazineMap.containsKey(entrySet.getKey()))
				return false;
			else{
				if(magazineMap.get(entrySet.getKey()) < entrySet.getValue())
					return false;
			}
		}
		if(noteMap.size() >= 1)
			return true;
		else
			return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNoteUsingHashTable s = new RansomNoteUsingHashTable(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
