package Word_Scrambler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
	@author Wei Jian Zhen
	
	Credit to JavaPoint, TutorialsPoint, and StackOverflow for the information about 
	Java GridBagLayout, Random Number Generation, converting character array to String,
	and detecting the enter key press.
	
	Links:
	https://www.javatpoint.com/how-to-generate-random-number-in-java
	https://www.javatpoint.com/java-gridbaglayout
	https://www.tutorialspoint.com/copy-char-array-to-string-in-java#:~:
	text=Use%20the%20valueOf()%20method,of%20array%20to%20be%20copied.
	https://stackoverflow.com/questions/4419667/detect-enter-press-in-jtextfield
	
**/

public class Scrambler_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel textPanel;
	private JPanel inputPanel;
	private JLabel explainTxt;
	private JTextField textBox;
	private JButton txtBoxBtn;
	private JLabel scramTxt;
	
	//Constructor to initialize components.
	public Scrambler_Frame() {
		textPanel = new JPanel();
		inputPanel = new JPanel();
		explainTxt = new JLabel();
		textBox = new JTextField();
		txtBoxBtn = new JButton();
		scramTxt = new JLabel();
	}
	
	//Method that is called in Main class to display the program and its components.
	public void defineGUI() {
		setTitle("Word Scrambler");
		setMinimumSize(new Dimension(475, 150)); //new Dimensions(x, y);
		setPreferredSize(new Dimension(500, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		
		//setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		//setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		//Methods that produce the UI for the program.
		scramblerContent();
		
		pack();
		setVisible(true);
	}
	
	//Method that adds all the program components and specifies its functions.
	private void scramblerContent() {
		
		//Specifies the parameters and appearance of the panel that holds the components inside.
		textPanel = new JPanel();
		textPanel.setBackground(Color.WHITE);
		textPanel.setMinimumSize(getMinimumSize());
		textPanel.setPreferredSize(getPreferredSize());
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		textPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		//Specifies the parameters and appearance of the top explanation text of the program.
		explainTxt = new JLabel();
		explainTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		explainTxt.setText("Please enter a word in the text box below to scramble it");
		explainTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		explainTxt.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		//Adds the explanation text to the panel.
		textPanel.add(explainTxt);
		
		//Specifies the parameters, appearance, and layout of the panel that holds the text box and button.
		inputPanel = new JPanel();
		inputPanel.setBackground(new Color(237, 237, 237));
		inputPanel.setMinimumSize(new Dimension(200, 20));
		inputPanel.setPreferredSize(new Dimension(300, 25));
		inputPanel.setMaximumSize(new Dimension(325, 30));
		inputPanel.setLayout(new GridBagLayout()); //GridBagLayout orders components in a grid with varying sizes.
		
		//Constrains the size and padding of the components inside inputPanel.
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 250;
		gbc.ipady = 10;
		
		//Specifies the parameters, background color, and position of the text box.
		textBox = new JTextField();
		textBox.setBackground(Color.LIGHT_GRAY);
		textBox.setPreferredSize(new Dimension(200, 20));
		textBox.setMaximumSize(new Dimension(400, 25));
		textBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		textBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		textBox.setEditable(true);
		
		//Adds the text box to inputPanel with the above GridBagConstraints.
		inputPanel.add(textBox, gbc);
		
		//Specifies the font style and position of the resulting scrambled text below the text box.
		scramTxt = new JLabel();
		scramTxt.setFont(new Font("serif", Font.PLAIN, 20));
		scramTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		scramTxt.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		//Specifies the grid position and padding of the text box button.
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 50;
		gbc.ipady = 10;
		
		//Specifies the positioning, parameters, and appearance of the text box button.
		txtBoxBtn = new JButton("Click");
		txtBoxBtn.setBackground(Color.WHITE);
		txtBoxBtn.setMinimumSize(new Dimension(20, 20));
		txtBoxBtn.setPreferredSize(new Dimension(25, 25));
		txtBoxBtn.setMaximumSize(new Dimension(30, 30));
		txtBoxBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		//Action function that will perform the word scrambling when action is called.
		Action action = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(textBox.getText());
				
				String txtBoxWord = textBox.getText(); //Gets text inserted from textBox.
				
				char[] letters = txtBoxWord.toCharArray(); //Splices text into an array of characters.
				
				int wordLength = letters.length; //Stores the length of the word to and integer value.
				
				//From the start of the word to the end of the word,
				//determine a random letter position
				//and then swap that random letter position with the current letter position of integer i.
				for(int i = 0; i < wordLength; i++) {
					
					int max = wordLength;
					int min = 0;
					int letterPos = (int) (Math.random() * (max - min) + min);
					
					char temp = letters[letterPos];
					letters[letterPos] = letters[i];
					letters[i] = temp;
				}
				
				//System.out.println(letters);
				
				//Returns the letters into a scrambled word and stores the scrambled word as a String value.
				String scrambled = String.valueOf(letters);
				
				//JLabel scramTxt will set its text to the scrambled word which should appear below the text box.
				scramTxt.setText(scrambled);
			}
		};
		
		//Method that detects the enter key when pressed for the text box
		//to activate 'action' for a word to be scrambled.
		textBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					textBox.addActionListener(action);
				}
			}
		});
		
		//Method that detects when the text box button is pressed so that it can scramble a word.
		txtBoxBtn.addActionListener(
					action
				);
		
		//Adds the text box button with GridBagConstraints to inputPanel.
		inputPanel.add(txtBoxBtn, gbc);
		
		//Adds child JPanel inputPanel to the parent JPanel of textPanel.
		textPanel.add(inputPanel);
		
		//Adds the scrambled word to textPanel.
		//Order matters. If I put this line of code above inputPanel, it would appear above the text box.
		textPanel.add(scramTxt);
		
		//Adds textPanel to JFrame and Word Scrambler program to be viewable.
		add(textPanel);
		
	}

}
