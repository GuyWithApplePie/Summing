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

public class SummingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtResult;

	//Global Variables
	int[] nums;
	 
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
	 * Create the frame.
	 */
	public SummingFrame() {
		setTitle("Integer Summing");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Integer Sums");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblTitle.setBounds(95, 10, 123, 22);
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
		txtAResult.setToolTipText("Output appears here");
		txtAResult.setBounds(184, 43, 91, 202);
		contentPane.add(txtAResult);
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBounds(10, 75, 77, 143);
		contentPane.add(pnlLeft);
		pnlLeft.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
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
					txtResult.setText("Invalid Input.");	// Displayed if given a negative number.
					txtInput.setText("");
					return;
				}
				
			}
		});
		btnAdd.setToolTipText("Add number in input field");
		btnAdd.setMargin(new Insets(2, 8, 2, 8));
		btnAdd.setBounds(0, 0, 77, 23);
		pnlLeft.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setToolTipText("Sorts input numbers");
		btnSort.setMargin(new Insets(2, 8, 2, 8));
		btnSort.setBounds(0, 38, 77, 23);
		pnlLeft.add(btnSort);
		
		JButton btnSumAll = new JButton("Sum All");
		btnSumAll.setToolTipText("Calculates the sum of the input numbers");
		btnSumAll.setMargin(new Insets(2, 8, 2, 8));
		btnSumAll.setBounds(0, 79, 77, 23);
		pnlLeft.add(btnSumAll);
		
		JButton btnSumEven = new JButton("Sum Even");
		btnSumEven.setToolTipText("Calculates the sum of the even input numbers");
		btnSumEven.setMargin(new Insets(2, 8, 2, 8));
		btnSumEven.setBounds(0, 113, 77, 23);
		pnlLeft.add(btnSumEven);
		
		JPanel pnlRight = new JPanel();
		pnlRight.setBounds(97, 75, 77, 143);
		contentPane.add(pnlRight);
		pnlRight.setLayout(null);
		
		JButton btwSumOdd = new JButton("Sum Odd");
		btwSumOdd.setToolTipText("Calculates the sum of the odd input numbers");
		btwSumOdd.setMargin(new Insets(2, 8, 2, 8));
		btwSumOdd.setBounds(0, 113, 77, 23);
		pnlRight.add(btwSumOdd);
		
		JButton btnCount = new JButton("Count");
		btnCount.setToolTipText("Counts how many numbers were given");
		btnCount.setMargin(new Insets(2, 8, 2, 8));
		btnCount.setBounds(0, 79, 77, 23);
		pnlRight.add(btnCount);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setToolTipText("Clears the numbers input");
		btnClear.setMargin(new Insets(2, 8, 2, 8));
		btnClear.setBounds(0, 38, 77, 23);
		pnlRight.add(btnClear);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setToolTipText("Remove number in input field");
		btnRemove.setMargin(new Insets(2, 8, 2, 8));
		btnRemove.setBounds(0, 0, 77, 23);
		pnlRight.add(btnRemove);
	}
}
