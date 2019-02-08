package lab2;
import java.io.*;
import java.util.*;

public class Dictionary {

	protected BufferedWriter outputWriter;
	protected ArrayList<Word> theDictionary;
	
	//Constructors
	Dictionary () {
//	
//	outputWriter = new BufferedWriter();
	
		theDictionary = new ArrayList<Word>();
	
	}
	
	Dictionary(String input) {
		this.addWords(input);
	}
	
	
	public void addWords(String input) {
	
		String[] wordArray = input.split(" ");
	
		for (String w : wordArray) {
			Word wordInstance  = new Word(w);
			theDictionary.add(wordInstance);
		}
	
	}
	
	public int numberOfWords() {
		return theDictionary.size();
	}
	
	public void removeDuplicates() {
		ArrayList<Word> newList = new ArrayList<Word>();
		for (Word w : this.theDictionary) {
			if(!newList.contains(w)) {
				newList.add(w);
			}
		}
		this.theDictionary = newList;
	}
	
	public String countOccurences() {
		int maxCount = 1;
		int M = 0;
		int N = 1;
		for (Word w : this.theDictionary) {
			if (w.counts == N) {
				M++;
			} else {
				if(w.counts > maxCount) {
					maxCount = w.counts;
				}
			}
		}
		
		return "There are " + M + " words that occured " + N + " times";
	}
	
	public void sortDictionaryByCounts() {
		for(int i = 0; i < theDictionary.size(); i++) {	
			for(int j = 0; j < theDictionary.size()-1; j++) {	
				if(theDictionary.get(j).getCounts() <  theDictionary.get(j+1).getCounts()) {							
					Word temp = theDictionary.get(j);				
					theDictionary.set(j, theDictionary.get(j+1));				
					theDictionary.set(j+1, temp);				
				}
			}
		}
	}
	
	public void setFileName(String filename) {
		try {
			outputWriter = new BufferedWriter(new FileWriter(filename));
		}catch(IOException ierr) {
			System.out.println("Error");	
		}
	}
	
	public void saveFile() {
//		try {
//			String toSave = toString();
//		}catch(IOExceptions ierr){
//			
//		}
		
	}
	
	public String toString() {
		String s = "Total words: " + Integer.toString(numberOfWords()) + " and total occurences ";
		sortDictionaryByCounts();
		s += Integer.toString(numberOfWords());
		return s;
	}

}

