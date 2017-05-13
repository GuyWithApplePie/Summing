/*			Integer Summing
 * 
 * Programmer: Nick Couzelis
 * 		 Date: 212/05/2017
 * 
 * This program creates a collection of positive integers (And 0) from user inputs or by use of an input for a random interger 1-100.
 * The program can then sort or clear the array, or remove user selected values. The program can calculate the sum of all values, all odd values, or all even values.
 */
package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class SummingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtResult;

	//Array List Creation
	ArrayList <Integer> num = new ArrayList();	// An array list is created to house the user's Integers
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SummingFrame frame = new SummingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create string from elements in ArrayList num.
	 * @return Text formatted for TextArea output.
	 */
	public String listOutput(){
		String text = "";	// text is created to hold the string while it's created.
		for(int i=0;i<num.size();i++){	//The loop runs one for each Integer in num.
			text= text+num.get(i).toString()+"\n";	//The string receives a number then '\n' to move to the next line.
		}
		return text;	//The final string is returned
	}
	
	/**
	 * Create the frame.
	 */
	public SummingFrame() {
		setResizable(false);
		setTitle("Integer Summing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Integer Sums");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblTitle.setBounds(83, 11, 123, 22);
		contentPane.add(lblTitle);
		
		JLabel lblInput = new JLabel("Integer Input:");
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInput.setBounds(10, 44, 93, 20);
		contentPane.add(lblInput);
		
		txtInput = new JTextField();
		txtInput.setToolTipText("Input a positive integer");
		txtInput.setBounds(114, 45, 60, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		txtResult = new JTextField();
		txtResult.setToolTipText("Output appears here");
		txtResult.setEditable(false);
		txtResult.setBounds(10, 225, 164, 20);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		
		JTextArea txtAResult = new JTextArea();
		txtAResult.setRows(2);
		txtAResult.setEditable(false);
		txtAResult.setToolTipText("Output appears here");
		txtAResult.setBounds(184, 43, 91, 202);
		contentPane.add(txtAResult);
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBounds(10, 75, 80, 143);
		contentPane.add(pnlLeft);
		pnlLeft.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Variable List
				int n;	//Holds the input value.
				try{			//Checking for integer.
					 n = Integer.parseInt(txtInput.getText());
				} catch(NullPointerException|NumberFormatException x){
					txtResult.setText("Invalid Input.");	// Displayed if given an empty value or not a number.
					txtInput.setText("");
					return;
				}
				if(n<0){
					txtResult.setText("Not Positive.");	// Displayed if given a negative number.
					txtInput.setText("");
					return;
				}
				num.add(n);	// Adding input to ArrayList num
				txtInput.setText("");
				txtAResult.setText(listOutput()); //Displaying the ArrayList to the user.
				txtResult.setText("");
			}
		});
		btnAdd.setToolTipText("Add number in input field");
		btnAdd.setMargin(new Insets(2, 8, 2, 8));
		btnAdd.setBounds(0, 0, 80, 23);
		pnlLeft.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(num);	//Sorting the ArrayList lowest value to highest.
				txtAResult.setText(listOutput()); //Displaying the ArrayList to the user.
				txtResult.setText("");
				txtInput.setText("");
			}
		});
		btnSort.setToolTipText("Sorts input numbers");
		btnSort.setMargin(new Insets(2, 8, 2, 8));
		btnSort.setBounds(0, 38, 80, 23);
		pnlLeft.add(btnSort);
		
		JButton btnSum = new JButton("Sum");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int sum = 0;	// Holds the sum locally while calculating.
					for(int i=0;i<num.size();i++){	// Loops through all objects in num.
						sum += num.get(i);	// Adds the value of each object to sum.
					}
					txtResult.setText(Integer.toString(sum));
					txtInput.setText("");
			}
		});
		btnSum.setToolTipText("Calculates the sum of the input numbers");
		btnSum.setMargin(new Insets(2, 8, 2, 8));
		btnSum.setBounds(0, 76, 80, 23);
		pnlLeft.add(btnSum);
		
		JButton btnSumEven = new JButton("Sum Even");
		btnSumEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum = 0;	// Holds the sum locally while calculating.
				for(int i=0;i<num.size();i++){	// Loops through all objects in num.
					if(num.get(i)%2==0){
					sum += num.get(i);	// Adds each even value to sum.
					}
				}
				txtResult.setText(Integer.toString(sum));
				txtInput.setText("");
			}
		});
		btnSumEven.setToolTipText("Calculates the sum of the even input numbers");
		btnSumEven.setMargin(new Insets(1, 8, 1, 8));
		btnSumEven.setBounds(0, 114, 80, 23);
		pnlLeft.add(btnSumEven);
		
		JPanel pnlRight = new JPanel();
		pnlRight.setBounds(94, 75, 80, 143);
		contentPane.add(pnlRight);
		pnlRight.setLayout(null);
		
		JButton btwSumOdd = new JButton("Sum Odd");
		btwSumOdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum = 0;	//Holds the sum locally while calculating.
				for(int i=0;i<num.size();i++){	// Loops through all objects in num
					if(num.get(i)%2==1){
					sum += num.get(i);	// Adds each odd value to sum.
					}
				}
				txtResult.setText(Integer.toString(sum));
				txtInput.setText("");
			}
		});
		btwSumOdd.setToolTipText("Calculates the sum of the odd input numbers");
		btwSumOdd.setMargin(new Insets(2, 8, 2, 8));
		btwSumOdd.setBounds(0, 114, 80, 23);
		pnlRight.add(btwSumOdd);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)(Math.random()*100+1);
				num.add(n);	// Adding input to ArrayList num
				txtInput.setText("");
				txtAResult.setText(listOutput()); //Displaying the ArrayList to the user.
				txtResult.setText("");
			}
		});
		btnRandom.setToolTipText("Adds a random number 1-100");
		btnRandom.setMargin(new Insets(1, 8, 1, 8));
		btnRandom.setBounds(0, 38, 80, 23);
		pnlRight.add(btnRandom);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num.clear();	// Clears the ArrayList of all elements.
				txtAResult.setText("");
				txtResult.setText("");	//Resets output and input fields.
				txtInput.setText("");
			}
		});
		btnClear.setToolTipText("Clears the numbers input");
		btnClear.setMargin(new Insets(2, 8, 2, 8));
		btnClear.setBounds(0, 76, 80, 23);
		pnlRight.add(btnClear);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Variable List
				int n;				
				try{			//Checking for integer.
					 n = Integer.parseInt(txtInput.getText());
				} catch(NullPointerException|NumberFormatException x){
					txtResult.setText("Invalid Input.");	// Displayed if given an empty value or not a number.
					txtInput.setText("");
					return;
				}
				if(n<0){
					txtResult.setText("Not Positive.");	// Displayed if given a negative number.
					txtInput.setText("");
					return;
				}
				if(!num.contains(n)){
					txtResult.setText("Not in Array.");	// Displayed if given a number not in the ArrayList.
					txtInput.setText("");
					return;
				}
				num.remove(new Integer(n));	// Remove input from ArrayList num.
				txtInput.setText("");
				txtAResult.setText(listOutput()); //Displaying the ArrayList to the user.
				txtResult.setText("");
				}
		});
		btnRemove.setToolTipText("Remove number in input field");
		btnRemove.setMargin(new Insets(2, 8, 2, 8));
		btnRemove.setBounds(0, 0, 80, 23);
		pnlRight.add(btnRemove);
	}
}
