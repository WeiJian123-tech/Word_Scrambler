package Word_Scrambler;

/**
 * 
 * @author Wei Jian Zhen
 *
 * Program intended for portfolio building and learning about front end Java development.
 * 
 * I programmed a word scrambler to further develop my programming abilities.
 * It took around 5 days to complete.
 * I learned about converting characters to Strings and Strings to characters.
 * I learned more about Java swing layouts, including GridBagLayout.
 * I furthermore learned about random number generation and how to 
 * detect a key press in Java.
 * Most importantly of all, I learned how to dynamically resize components
 * in Java using a combination of Java swing layouts.
 * 
 * Initial Publishing Date/Date Published: 08/6/2022
 * 
 **/

public class Main {

	public static void main(String[] args) {
		
		//Instantiating a new Scrambler_Frame object to call components from Scrambler_Frame class.
		Scrambler_Frame sf = new Scrambler_Frame();
		
		//Calls defineGUI method to display the program when it is running.
		sf.defineGUI();

	}

}
