// Jihyun Lee, 141859181
// jlee592@myseneca.ca
// Lab7_Task1 | 2020-03-07
// TypingTutor.java
// The application should display a virtual keyboard and should allow the user 
// to watch what he or she is typing on the screen without looking at the actual keyboard.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TypingTutor extends JFrame {

	public TypingTutor() {

		setLayout(new GridLayout(2, 1, 0, 0));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		// Upper Part for the result
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		
		JLabel guide1 = new JLabel(
				"Type some text using your keyboard. The keys you press will be highlightened and the text will be displayed.");
		JLabel guide2 = new JLabel("Node: Clicking the button with your mouse will not perform any action.");
		guide1.setFont(new Font("TimesRoman", Font.BOLD, 11));
		guide2.setFont(new Font("TimesRoman", Font.BOLD, 11));
		JTextArea myTextArea = new JTextArea(610, 5);
		myTextArea.setLineWrap(true);
		myTextArea.setBackground(Color.WHITE);
		myTextArea.setPreferredSize(new Dimension(610, 200));

		panel1.add(guide1);
		panel1.add(guide2);
		panel1.add(myTextArea);

		// Lower Part for the keyboard
		panel2.setLayout(new GridLayout(5, 1, 0, 0));
		panel2.setBorder(new EmptyBorder(10, 10, 10, 0));
		JPanel panel01 = new JPanel();
		JPanel panel02 = new JPanel();
		JPanel panel03 = new JPanel();
		JPanel panel04 = new JPanel();
		JPanel panel05 = new JPanel();
		panel01.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel02.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel03.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel04.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel05.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		// firstRow of Keyboard : 14
		JButton[] firstRow = { new JButton("~"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"),
				new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9"),
				new JButton("0"), new JButton("-"), new JButton("+"), new JButton("Backspace") };

		int[] firstKeys = { KeyEvent.VK_BACK_QUOTE, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4,
				KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_0,
				KeyEvent.VK_MINUS, KeyEvent.VK_EQUALS, KeyEvent.VK_BACK_SPACE };

		for (int i = 0; i < firstRow.length; i++) {
			firstRow[i].setMargin(new Insets(1, 1, 1, 1));
			firstRow[i].setPreferredSize(new Dimension(40, 40));
			panel01.add(firstRow[i]);
		}
		firstRow[13].setPreferredSize(new Dimension(100, 40)); // Backspace resizing

		panel2.add(panel01);

		// Second Row of Keyboard: 14
		JButton[] secondRow = { new JButton("Tab"), new JButton("Q"), new JButton("W"), new JButton("E"),
				new JButton("R"), new JButton("T"), new JButton("Y"), new JButton("U"), new JButton("I"),
				new JButton("O"), new JButton("P"), new JButton("["), new JButton("]"), new JButton("\\") };

		int[] secondKeys = { KeyEvent.VK_TAB, KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_R, KeyEvent.VK_T,
				KeyEvent.VK_Y, KeyEvent.VK_U, KeyEvent.VK_I, KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_OPEN_BRACKET,
				KeyEvent.VK_CLOSE_BRACKET, KeyEvent.VK_BACK_SLASH };

		for (int i = 0; i < secondRow.length; i++) {
			secondRow[i].setMargin(new Insets(1, 1, 1, 1));
			secondRow[i].setPreferredSize(new Dimension(40, 40));
			panel02.add(secondRow[i]);
		}
		secondRow[0].setPreferredSize(new Dimension(60, 40));

		panel2.add(panel02);

		// Third Row of Keyboard: 13
		JButton[] thirdRow = { new JButton("Caps"), new JButton("A"), new JButton("S"), new JButton("D"),
				new JButton("F"), new JButton("G"), new JButton("H"), new JButton("J"), new JButton("K"),
				new JButton("L"), new JButton(":"), new JButton("\""), new JButton("Enter") };

		int[] thirdKeys = { KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F,
				KeyEvent.VK_G, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_SEMICOLON,
				KeyEvent.VK_QUOTE, KeyEvent.VK_ENTER };

		for (int i = 0; i < thirdRow.length; i++) {
			thirdRow[i].setMargin(new Insets(1, 1, 1, 1));
			thirdRow[i].setPreferredSize(new Dimension(40, 40));
			panel03.add(thirdRow[i]);
		}

		thirdRow[0].setPreferredSize(new Dimension(60, 40));
		thirdRow[12].setPreferredSize(new Dimension(80, 40));

		panel2.add(panel03);

		// Fourth Row of Keyboard: 12
		JButton[] fourthRow = { new JButton("Shift"), new JButton("Z"), new JButton("X"), new JButton("C"),
				new JButton("V"), new JButton("B"), new JButton("N"), new JButton("M"), new JButton(","),
				new JButton("."), new JButton("?"), new JButton("^") };

		int[] fourthKeys = { KeyEvent.VK_SHIFT, KeyEvent.VK_Z, KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_V,
				KeyEvent.VK_B, KeyEvent.VK_N, KeyEvent.VK_M, KeyEvent.VK_COMMA, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH,
				KeyEvent.VK_UP, };

		for (int i = 0; i < fourthRow.length - 1; i++) {
			fourthRow[i].setMargin(new Insets(1, 1, 1, 1));
			fourthRow[i].setPreferredSize(new Dimension(40, 40));
			panel04.add(fourthRow[i]);
		}
		fourthRow[0].setPreferredSize(new Dimension(80, 40));
		JLabel space = new JLabel("      ");
		panel04.add(space);
		fourthRow[fourthRow.length - 1].setMargin(new Insets(1, 1, 1, 1));
		fourthRow[fourthRow.length - 1].setPreferredSize(new Dimension(40, 40));
		panel04.add(fourthRow[fourthRow.length - 1]);
		panel2.add(panel04);

		// Fifth Row of Keyboard: 4

		panel05.setLayout(new GridLayout(1, 3, 0, 0));
		// panel05.setBorder(new EmptyBorder(10, 10, 10, 0));
		JPanel panel51 = new JPanel();
		JPanel panel52 = new JPanel();
		JPanel panel53 = new JPanel();
		panel52.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel53.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JButton[] fifthRow = { new JButton(""), new JButton("<"), new JButton("\u02c5"), new JButton(">") };

		int[] fifthKeys = { KeyEvent.VK_SPACE, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT };

		fifthRow[0].setMargin(new Insets(1, 1, 1, 1));
		fifthRow[0].setPreferredSize(new Dimension(200, 40));
		panel52.add(fifthRow[0]);

		for (int i = 1; i < fifthRow.length; i++) {
			fifthRow[i].setMargin(new Insets(1, 1, 1, 1));
			fifthRow[i].setPreferredSize(new Dimension(40, 40));
			panel53.add(fifthRow[i]);
		}
		
		//fifthRow[0].setBorder(new EmptyBorder(300, 0, 0, 0));
		//panel05.add(fifthRow[0]);

		panel05.add(panel51);
		panel05.add(panel52);
		panel05.add(panel53);
		panel2.add(panel05);

		add(panel1);
		add(panel2);

		// For KEYBOARD EVENT *****************************************
		Color originalColor = firstRow[0].getBackground();

		myTextArea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				for (int i = 0; i < firstRow.length; i++) {
					if (e.getKeyCode() == firstKeys[i]) {
						// System.out.println(e.getKeyCode());
						firstRow[i].setBackground(Color.PINK);
					}
				}

				for (int i = 0; i < secondRow.length; i++) {
					if (e.getKeyCode() == secondKeys[i]) {
						secondRow[i].setBackground(Color.PINK);
					}
				}

				for (int i = 0; i < thirdRow.length; i++) {
					if (e.getKeyCode() == thirdKeys[i]) {
						thirdRow[i].setBackground(Color.PINK);
					}
				}
				for (int i = 0; i < fourthRow.length; i++) {
					if (e.getKeyCode() == fourthKeys[i]) {
						fourthRow[i].setBackground(Color.PINK);
					}
				}

				for (int i = 0; i < fifthRow.length; i++) {
					if (e.getKeyCode() == fifthKeys[i]) {
						fifthRow[i].setBackground(Color.PINK);
					}
				}

			}

			public void keyReleased(KeyEvent e) {

				for (int i = 0; i < firstRow.length; i++) {
					if (e.getKeyCode() == firstKeys[i]) {
						// System.out.println(e.getKeyCode());
						firstRow[i].setBackground(originalColor);
					}
				}

				for (int i = 0; i < secondRow.length; i++) {
					if (e.getKeyCode() == secondKeys[i]) {
						secondRow[i].setBackground(originalColor);
					}
				}

				for (int i = 0; i < thirdRow.length; i++) {
					if (e.getKeyCode() == thirdKeys[i]) {
						thirdRow[i].setBackground(originalColor);
					}
				}
				for (int i = 0; i < fourthRow.length; i++) {
					if (e.getKeyCode() == fourthKeys[i]) {
						fourthRow[i].setBackground(originalColor);
					}
				}

				for (int i = 0; i < fifthRow.length; i++) {
					if (e.getKeyCode() == fifthKeys[i]) {
						fifthRow[i].setBackground(originalColor);
					}
				}
			}
		});
		
		
		// For MOUSE EVENT *****************************************
		// They are working, but not efficient as I have set the events separately for every button. 
        // Wondering if there is a way that I can make it simpler.

		firstRow[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//firstRow[0].setBackground(Color.PINK);
				myTextArea.setText(myTextArea.getText() + firstRow[0].getText());	
			}
			
		});

		firstRow[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//firstRow[1].setBackground(Color.PINK);
				myTextArea.setText(myTextArea.getText() + firstRow[1].getText());
			}
		});
		firstRow[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myTextArea.setText(myTextArea.getText() + firstRow[2].getText());
			}
		});
		
		
		// I cannot use this code as the local variable 'k' is not available in ActionListener
		
//		for (int k = 0; k < firstRow.length; k++) {
//			firstRow[k].addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					firstRow[k].setBackground(Color.PINK);
//					myTextArea.setText(myTextArea.getText() + firstRow[k].getText());
//				}
//			});
//		}
		
	}

	public static void main(String[] args) {

		TypingTutor myframe = new TypingTutor();
		myframe.setTitle("Typing Tutor");
		myframe.setSize(650, 490);
		myframe.setLocationRelativeTo(null);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);

	}

}
