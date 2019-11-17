package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements java.awt.event.ActionListener{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		//new Song("demo.mp3").play();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	//static ArrayList<Song> songs = new ArrayList<Song>();
	static String[] strings = new String[3];
	public static void main(String[] args) {
		_06_IPodShuffle shuffle = new _06_IPodShuffle();
		//ArrayList<Song> songs = new ArrayList<Song>();
	//	songs.add(0, new Song("demo.mp3"));
	//	songs.add(1, new Song("grandma.mp3"));
	//	songs.add(2, new Song("rock.mp3"));
		strings[0] = "demo.mp3";
		strings[1] = "grandma.mp3";
		strings[2] = "rock.mp3";
		shuffle.setup();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton demo = new JButton();
	JButton grandma = new JButton();
	JButton rock = new JButton();
	JButton surprise = new JButton();
	
	public void setup() {
		demo.setText("Demo");
		grandma.setText("Grandma Got Run Over by a Reindeer");
		rock.setText("Jingle Bell Rock");
		surprise.setText("Surprise Me!");
		demo.addActionListener(this);
		grandma.addActionListener(this);
		rock.addActionListener(this);
		surprise.addActionListener(this);
		panel.add(demo);
		panel.add(grandma);
		panel.add(rock);
		panel.add(surprise);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(demo)) {
			new Song("demo.mp3").play();
		}
		if(e.getSource().equals(grandma)) {
			new Song("grandma.mp3").play();
		}
		if(e.getSource().equals(rock)) {
			new Song("rock.mp3").play();
		}
		if(e.getSource().equals(surprise)) {
			Random rand = new Random();
			int anything = rand.nextInt(3);
			String surpriseme = strings[anything];
			new Song(surpriseme).play();
			
		}
	}
}