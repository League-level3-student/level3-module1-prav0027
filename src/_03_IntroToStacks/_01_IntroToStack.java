package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> randomnumbers = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0; i<100; i++) {
			Random rand = new Random();
			randomnumbers.push((double) rand.nextInt(100));
		}
		int sz = randomnumbers.size();
		
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String answer1 = JOptionPane.showInputDialog("Please enter a number between 0 and 100, inclusive.");
		String answer2 = JOptionPane.showInputDialog("Please enter a number between 0 and 100, inclusive, that is bigger than your first number.");
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		int answernum1 = Integer.parseInt(answer1);
		int answernum2 = Integer.parseInt(answer2);
		
		for(int i = 0; i < sz; i++){
			double check = randomnumbers.pop();
			if(answernum1<check&&check<answernum2) {
			System.out.println(check);
			}
		}
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
