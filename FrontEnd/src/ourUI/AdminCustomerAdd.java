package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminCustomerAdd {

	JFrame frame;
	private JTextField textField;
	private JTextField AdminAddCustomerfName;
	private JTextField AdminAddCustomerlName;
	private JTextField AdminAddCustomerIDnumber;
	private JTextField AdminAddCustomerEmail;
	private JTextField AdminAddCustomerCountry;
	
	private String firstName, lastName, idNumber, email, country;
	private DBConnection adminConnect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCustomerAdd window = new AdminCustomerAdd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminCustomerAdd(DBConnection adminConnect) {
		this.adminConnect = adminConnect;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(10, 60, 76, 29);
		frame.getContentPane().add(lblName);
		
		JLabel label = new JLabel("Last Name");
		label.setBounds(10, 99, 76, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID Number");
		label_1.setBounds(10, 234, 76, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(10, 288, 76, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Country");
		label_3.setBounds(10, 174, 76, 29);
		frame.getContentPane().add(label_3);
		
		AdminAddCustomerfName = new JTextField();
		AdminAddCustomerfName.setBounds(96, 61, 138, 28);
		frame.getContentPane().add(AdminAddCustomerfName);
		AdminAddCustomerfName.setColumns(10);
		
		AdminAddCustomerlName = new JTextField();
		AdminAddCustomerlName.setColumns(10);
		AdminAddCustomerlName.setBounds(96, 100, 138, 28);
		frame.getContentPane().add(AdminAddCustomerlName);
		
		AdminAddCustomerIDnumber = new JTextField();
		AdminAddCustomerIDnumber.setColumns(10);
		AdminAddCustomerIDnumber.setBounds(96, 235, 248, 28);
		frame.getContentPane().add(AdminAddCustomerIDnumber);
		
		AdminAddCustomerEmail = new JTextField();
		AdminAddCustomerEmail.setColumns(10);
		AdminAddCustomerEmail.setBounds(96, 289, 463, 28);
		frame.getContentPane().add(AdminAddCustomerEmail);
		
		AdminAddCustomerCountry = new JTextField();
		AdminAddCustomerCountry.setColumns(10);
		AdminAddCustomerCountry.setBounds(96, 175, 248, 28);
		frame.getContentPane().add(AdminAddCustomerCountry);
		
		JButton btnAddClient = new JButton("Add Customer");
		btnAddClient.setBounds(568, 363, 117, 29);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// Here are all the user information inputed
				firstName = AdminAddCustomerfName.getText();
				lastName = AdminAddCustomerlName.getText();
				idNumber = AdminAddCustomerIDnumber.getText();
				email = AdminAddCustomerEmail.getText();
				country = AdminAddCustomerCountry.getText();
				
				try{
					int customerID = adminConnect.addCustomer(firstName, lastName, idNumber, email, country);
					String message = "New customer (" + customerID + ")" + "is added.";
					JOptionPane.showMessageDialog(null,message);
					// make sure here
					new AdminRoomControl(adminConnect).frame.setVisible(true);;
					// Change later to visible
					frame.dispose();
				}
				catch (Exception er){
					JOptionPane.showMessageDialog(null,"Please enter all fields");
					
				}
				
				
			}
		});
		frame.getContentPane().add(btnAddClient);
		
	}
	

}
