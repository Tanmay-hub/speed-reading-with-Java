package assignment4;
import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;
/**
 * 
 * @author Tanmay Bothra
 *Class: WordGenerator
 *This class contains methods used to read from and print the contents of the file and methods that tabulate the number of words and sentences
 */
public class WordGenerator {

private String filename;
private Scanner sc;
private Scanner S;
private int WordCount;
private int SentenceCount;

	public WordGenerator(String filename) {
		this.filename = filename;
		try {
			sc = new Scanner(new FileReader(this.filename));
		} 
		catch (FileNotFoundException e) {
			System.err.println("No file of that name was found.");
			}
		}//constructor
	
	/**
	 * 
	 * @return Boolean
	 * The underlying scanner checks if the text has another word and returns true if it does.
	 */
	public Boolean hasNext() {
	if(sc.hasNext()) {
		return true;
	}
	else {
		return false;
	}
	}
	
	/**
	 * 
	 * @return String
	 * The method returns the next word of the text.
	 */
	public String next() {
	return sc.next();
	}
	
	/**
	 * 
	 * @param int wc
	 * This method sets the word count to wc, which is the number of words in the text and is tabulated in the SpeedReader class.
	 */
	public void setWordCount(int wc) {
		WordCount = wc;
	}
	
	/**
	 * 
	 * @return int 
	 * This method returns the word count of the text
	 */
	public int getWordCount() {
	return WordCount;
	}
	
	/**
	 * 
	 * @return int
	 * This method counts the number of sentences by counting the number of words ending in '.' or '?' or '!'
	 */
	public int getSentenceCount() {
		try {
			S = new Scanner(new FileReader(this.filename));
			while(S.hasNext()) {
				String word = S.next();
				for(int i =0; i < word.length(); i++) {
					if(word.charAt(i) == '.' || word.charAt(i) == '?' || word.charAt(i) == '!') {
					SentenceCount++;
					}
				}
			}
		} 
		catch (FileNotFoundException e) {
			System.err.println("No file of that name was found.");
			}
		finally {
			if(S != null) {
				S.close();
			}
		}
		return SentenceCount;
	}
	
	/**
	 * 
	 * @return Scanner
	 * This method returns the class's underlying scanner.
	 */
	public Scanner getScanner() {
		return sc;
	}
	
}


