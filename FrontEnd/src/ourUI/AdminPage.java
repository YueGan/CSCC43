package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AdminPage {

	JFrame frame;
	private JTextField txtAccount;
	private JTextField txtPassword;
	private JLabel lblAccount;
	private JLabel lblPassword;
	private JButton btnNewButton;
	
	private final String username = "admin";
	private final String password = "password";
	private JLabel lblWrongAccountpassword;
	private JLabel lblPleaseEnterYour;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdminPage window = new AdminPage();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Login Page");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblAccount = new JLabel("Username");
		lblAccount.setFont(new Font("PMingLiU", Font.PLAIN, 15));
		lblAccount.setBounds(156, 154, 117, 16);
		frame.getContentPane().add(lblAccount);
		
		txtAccount = new JTextField();
		txtAccount.setBounds(239, 142, 227, 28);
		frame.getContentPane().add(txtAccount);
		txtAccount.setColumns(10);
		
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("PMingLiU", Font.PLAIN, 15));
		lblPassword.setBounds(156, 214, 117, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(239, 202, 227, 28);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		lblWrongAccountpassword = new JLabel("Wrong Account/Password");
		lblWrongAccountpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongAccountpassword.setBounds(113, 322, 434, 50);
		frame.getContentPane().add(lblWrongAccountpassword);
		lblWrongAccountpassword.setVisible(false);
		
		btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the input of account
				String tempAcc = txtAccount.getText();
				String tempPswd = txtPassword.getText();
				
				if(tempAcc.equals(username) && tempPswd.equals(password)){
				
					new AdminControl(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390",
							"sql5112390", "GRa9gFy4NQ")).frame.setVisible(true);
					frame.dispose();
				}
				else{
					lblWrongAccountpassword.setVisible(true);
					lblNewLabel.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(274, 382, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		lblPleaseEnterYour = new JLabel("Please Enter Your Adminstrative Username and Password");
		lblPleaseEnterYour.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 20));
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(0, 53, 684, 50);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("PMingLiU", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setIcon(new ImageIcon(AdminPage.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		lblNewLabel.setBounds(288, 268, 78, 72);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		

	}
}
