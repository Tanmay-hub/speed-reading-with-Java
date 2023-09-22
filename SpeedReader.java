/*
 * Tanmay Bothra
Speed Reading
April 29 2022

Help obtained: None
I/ confirm that the above list of sources is complete AND that I/we have not talked to anyone else (e.g., CSC 207 students) about the solution to this problem."
 */
package assignment4;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 * @author Tanmay Bothra
 * This class reads a file, displays it on a Drawing Panel (dp) based on the command-line arguments, and reports the number of words
 * and sentences in the file.
 *
 * THE FOLLOWING COMMAND LINE ARGUMENTS ARE NEEDED: <filename> <width of dp> <height of dp> <font size> <wpm>
 */
public class SpeedReader {
	static int wordCount = 0;

	public static void main(String args[]) {
		WordGenerator wg = new WordGenerator(args[0]);      //filename
		int width = Integer.parseInt(args[1]);              //width of the drawing panel
		int height = Integer.parseInt(args[2]);             //height of the drawing panel
		int wpm = Integer.parseInt(args[4]);                //words per minute
	    DrawingPanel dp = new DrawingPanel(width, height); 
		Graphics g = dp.getGraphics(); 
		dp.setBackground(Color.white);
		g.setFont(new Font("Courier", Font.PLAIN, Integer.parseInt(args[3]))); //font size
		try {
			 while(wg.hasNext()) {
				 wordCount++;
				 g.setColor(Color.white);
				 g.fillRect(0, 0, width, height);
				 g.setColor(Color.black);
				 g.drawString(wg.next(), (int)(width * 0.1), height/2);
				 Thread.sleep(60000/wpm);
			     }
			 wg.setWordCount(wordCount);
		         }
		catch (InterruptedException ie ) {
			System.err.println("There was an error");
		}
	finally {
		if(wg.getScanner() != null) {
			wg.getScanner().close();
		}
	}
		System.out.println("Word Count: " + wg.getWordCount());
		System.out.println("Sentence Count: " + wg.getSentenceCount());
		
}
}
