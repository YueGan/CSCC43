package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CustomerReservation {

	JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtCountry;
	private DBConnection adminConnect;
	private String selectedRoom;
	private JLabel label;
	private JTextField txtCustomerID;
	private String inDate;
	private String outDate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerReservation window = new CustomerReservation(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390", "sql5112390", "GRa9gFy4NQ"), "", "" ,"");
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
	public CustomerReservation(DBConnection adminConnect, String selectedRoom, String inDate, String outDate) {
		this.inDate = inDate;
		this.outDate = outDate;
		this.selectedRoom = selectedRoom;
		this.adminConnect = adminConnect;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, -1, 111, 50);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 40, 111, 50);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 119, 111, 50);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(10, 160, 111, 50);
		frame.getContentPane().add(lblPhoneNumber);
		
		label = new JLabel("ID Number");
		label.setBounds(6, 74, 111, 50);
		frame.getContentPane().add(label);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setColumns(10);
		txtCustomerID.setBounds(109, 92, 200, 29);
		frame.getContentPane().add(txtCustomerID);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(109, 10, 200, 29);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(109, 51, 200, 29);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(109, 130, 200, 29);
		frame.getContentPane().add(txtEmail);
		
		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(109, 171, 200, 29);
		frame.getContentPane().add(txtCountry);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.setBounds(321, 243, 117, 29);
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") ||
						txtEmail.getText().equals("") || txtCustomerID.getText().equals("") ||
						txtCountry.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Please enter all required field!");
				}
				else{
					int customerRef = adminConnect.addCustomer(txtFirstName.getText(), txtLastName.getText(),
							txtCustomerID.getText(),
							txtEmail.getText(), txtCountry.getText());
					adminConnect.addReservation(Integer.parseInt(selectedRoom), customerRef, inDate, outDate);
					//addReservation(selectedRoom, );
					new RoomReservationPage(adminConnect).frame.setVisible(true);
					// Change later to visible
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnMakeReservation);
		

	}
}
