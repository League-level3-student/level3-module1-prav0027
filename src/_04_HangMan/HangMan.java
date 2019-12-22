package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	public static void main(String[] args) {
		String enterednumber = JOptionPane.showInputDialog("Please enter a number.");
		int number = Integer.parseInt(enterednumber);
		
		
		Stack<String> words = new Stack<String>();
		for(int i=0; i<number; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			//System.out.println(words.pop());
		}
		String firstword = words.pop();
		int charnumber = firstword.length();
		//System.out.println(charnumber);
		//System.out.println(firstword);
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel input = new JLabel();
		JLabel lettersused = new JLabel();
		
	}
	
	
}
