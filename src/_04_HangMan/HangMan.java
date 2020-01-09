package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangMan implements KeyListener{
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.setup();		
	}
	
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField input = new JTextField();
	JLabel characterlabel = new JLabel();
	JLabel charsusedlabel = new JLabel();
	JLabel liveslabel = new JLabel();
	char guess;
	char[] letters;
	String[] dashs;
	int numberentered;
	int lives;
	String dashstring;
	String charsused;
	String livesstring;
	boolean isLetter;
	
	
	
	void setup() {
	numberentered = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number."));
	
	
	Stack<String> words = new Stack<String>();
	for(int i=0; i<numberentered; i++) {
		words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
	}
	String firstword = words.pop();
	letters = firstword.toCharArray();
	dashs = new String[letters.length];
	System.out.println("Char: "+letters.length);
	System.out.println("First word: "+firstword);
	
	lives = 10;
	livesstring = "Number of lives: "+lives;

	
	
	dashstring = " ";
	charsused = "Letters guessed: ";
	
	for(int a = 0; a<letters.length; a++) {
		dashs[a]="_ ";
		dashstring = dashstring.concat(dashs[a]);
	}
	

	characterlabel.setText(dashstring);
	input.addKeyListener(this);
	
	
	
	frame.add(panel);
	panel.add(input);
	panel.add(characterlabel);
	panel.add(charsusedlabel);
	panel.add(liveslabel);
	liveslabel.setText(livesstring);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	System.out.println("------");
	for(int c = 0; c<dashs.length; c++) {
	}
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		frame.pack();
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			guess = input.getText().charAt(0);
			charsused = charsused.concat(guess+", ");
			charsusedlabel.setText(charsused);
			for(int i=0; i<letters.length; i++) {
				if(letters[i]==guess) {
					dashs[i]=guess+" ";
					System.out.println(" ");
					dashstring = dashs[0];
					for(int a = 1; a<letters.length; a++) {
						dashstring = dashstring.concat(dashs[a]);
					}
					characterlabel.setText(dashstring);
					isLetter = true;
				}
			}
			if(isLetter==false) {
			lives--;
			livesstring = "Number of lives: "+lives;
			liveslabel.setText(livesstring);
			}
		}
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
