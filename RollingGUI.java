import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RollingGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JComboBox<Integer> numDiceList;
	private JComboBox<Integer> typeDiceList;
	private JButton roll;
	private JPanel north;
	private JPanel south;
	private JPanel west;
	
	private ArrayList<Object> arr = new ArrayList<Object>();
	private int integ;

	
	public RollingGUI() {
		frame = new JFrame();
		
		frame.setTitle("Dice Roller"); // sets window title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close
		frame.pack();
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null); // centres it
		
		// TOP BAR
		// number of dice drop down menu
		JLabel numOfDiceLabel = new JLabel("Enter Dice: ");
		Vector<Integer> numOfDice = new Vector<Integer>();
		for (int i = 1; i <= 10; i++) {
			numOfDice.add(i);
		}
		
		numDiceList = new JComboBox<Integer>(numOfDice);
		numDiceList.addActionListener(this);
		
		// type of dice drop down menu
		JLabel diceTypeLabel = new JLabel("d");
		Vector<Integer> typeOfDice = new Vector<Integer>();
		typeOfDice.add(4);
		typeOfDice.add(6);
		typeOfDice.add(8);
		typeOfDice.add(10);
		typeOfDice.add(12);
		typeOfDice.add(20);
		typeOfDice.add(100);
		
		typeDiceList = new JComboBox<Integer>(typeOfDice);
		typeDiceList.addActionListener(this);
		
		// roll button
		roll = new JButton("Roll");
		roll.addActionListener(this);
		
		north = new JPanel();
		north.add(numOfDiceLabel);
		north.add(numDiceList);
		north.add(diceTypeLabel);
		north.add(typeDiceList);
		north.add(roll);
		
		frame.add(north, BorderLayout.NORTH);
		
		// dice visual
		
		
		frame.setVisible(true);
	}
	
	private void roll() {
		int num = (int)numDiceList.getSelectedItem();
		int type = (int)typeDiceList.getSelectedItem();
		
		RollingFunction rollFunc = new RollingFunction();
		
		// performs calc
		rollFunc.roll(num, type);
		
		// returns it as array
		arr = rollFunc.rollArray();
		
		// returns it as total
		integ = rollFunc.rollTotal();
	}
	

	public static void main(String[] args) {
		new RollingGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(roll)) {
			this.roll();
			
			west = new JPanel();
			west.setLayout(new GridLayout(2, 0));
			frame.add(west, BorderLayout.WEST);
			
			JLabel array = new JLabel("Individual Rolls: " + arr);
			JLabel integer = new JLabel("Total: " + integ);
			
			west.add(array);
			west.add(integer);
			
			west.setVisible(true);

			
		}
		
	}

}
