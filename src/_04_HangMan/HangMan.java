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
	JLabel characternumber = new JLabel();
	JLabel lettersused = new JLabel();
	JLabel lives = new JLabel();
	char guess;
	
	
	void setup() {
	String enterednumber = JOptionPane.showInputDialog("Please enter a number.");
	int number = Integer.parseInt(enterednumber);
	
	
	Stack<String> words = new Stack<String>();
	for(int i=0; i<number; i++) {
		words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
	}
	String firstword = words.pop();
	int charnumber = firstword.length();
	System.out.println("Char: "+charnumber);
	System.out.println("First word: "+firstword);
	
	
	
	
	
	
	//JFrame frame = new JFrame();
	//JPanel panel = new JPanel();
	//JTextField input = new JTextField();
	//JLabel characternumber = new JLabel();
	//JLabel lettersused = new JLabel();
	//JLabel lives = new JLabel();
	String dashnumber = " ";
	String charused = " ";
	
	
	for(int i=0; i<charnumber; i++) {
		dashnumber = dashnumber.concat("_ ");
	}
	
	
	characternumber.setText(dashnumber);
	input.addKeyListener(this);
	
	
	
	frame.add(panel);
	panel.add(input);
	panel.add(lettersused);
	panel.add(characternumber);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	System.out.println(dashnumber);
	
	
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
			System.out.println(guess);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
