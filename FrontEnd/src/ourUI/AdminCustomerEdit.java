package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminCustomerEdit {

	JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtCustomerID;
	private JTextField txtEmail;
	private JTextField txtCountry;
	private DBConnection adminConnect;
	private String customerRef;
	private JTextField txtCustomerRef;
	private ResultSet result = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdminCustomerEdit window = new AdminCustomerEdit();
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
	public AdminCustomerEdit(DBConnection adminConnect) {
		this.adminConnect = adminConnect;
		initialize();
	}


	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Editing Customer Info");  
		frame.setBounds(100, 100, 710, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(29, 95, 75, 29);
		frame.getContentPane().add(lblName);
		
		JLabel label = new JLabel("Last Name");
		label.setBounds(29, 134, 75, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID Number");
		label_1.setBounds(29, 243, 75, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(29, 282, 75, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Country");
		label_3.setBounds(29, 204, 75, 29);
		frame.getContentPane().add(label_3);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(114, 96, 134, 28);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(113, 135, 134, 28);
		frame.getContentPane().add(txtLastName);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setColumns(10);
		txtCustomerID.setBounds(114, 244, 251, 28);
		frame.getContentPane().add(txtCustomerID);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(114, 283, 501, 28);
		frame.getContentPane().add(txtEmail);
		
		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(114, 205, 251, 28);
		frame.getContentPane().add(txtCountry);
		

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(567, 362, 117, 29);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(customerRef.equals("")){
					JOptionPane.showMessageDialog(null,"Please generate a customer first!");
				}
				else{
					adminConnect.updateMethod("customers", "fName", txtFirstName.getText(), "customerRef", customerRef);
					adminConnect.updateMethod("customers", "lName", txtLastName.getText(), "customerRef", customerRef);
					adminConnect.updateMethod("customers", "IDnumber", txtCustomerID.getText(), "customerRef", customerRef);
					adminConnect.updateMethod("customers", "emailAddress", txtEmail.getText(), "customerRef", customerRef);
					adminConnect.updateMethod("customers", "country", txtCountry.getText(), "customerRef", customerRef);
					new AdminRoomControl(adminConnect).frame.setVisible(true);;
					// Change later to visible
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblCustomerReferenceNumber = new JLabel("Customer Reference Number");
		lblCustomerReferenceNumber.setBounds(63, 36, 218, 37);
		frame.getContentPane().add(lblCustomerReferenceNumber);
		
		txtCustomerRef = new JTextField();
		txtCustomerRef.setBounds(269, 41, 202, 28);
		frame.getContentPane().add(txtCustomerRef);
		txtCustomerRef.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(512, 40, 117, 29);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Later, add try to catch if cusRef does not exist
				customerRef = txtCustomerRef.getText();
				result = adminConnect.getCustomer(customerRef);
				try{
					while(result.next()){
						txtFirstName.setText(result.getString("fName"));
						txtLastName.setText(result.getString("lName"));
						txtCustomerID.setText(result.getString("IDnumber"));
						txtEmail.setText(result.getString("emailAddress"));
						txtCountry.setText(result.getString("country"));
					}
					
				} catch (SQLException ef) {
					// TODO Auto-generated catch block
					ef.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnGenerate);
	}
}
