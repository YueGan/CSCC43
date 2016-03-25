package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JTextField AdminAddCustomerCID;

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
	public AdminCustomerAdd() {
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
		lblName.setBounds(10, 5, 76, 29);
		frame.getContentPane().add(lblName);
		
		JLabel label = new JLabel("Last Name");
		label.setBounds(10, 44, 76, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID Number");
		label_1.setBounds(10, 115, 76, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(10, 154, 76, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Country");
		label_3.setBounds(248, 115, 76, 29);
		frame.getContentPane().add(label_3);
		
		AdminAddCustomerfName = new JTextField();
		AdminAddCustomerfName.setBounds(71, 6, 138, 28);
		frame.getContentPane().add(AdminAddCustomerfName);
		AdminAddCustomerfName.setColumns(10);
		
		AdminAddCustomerlName = new JTextField();
		AdminAddCustomerlName.setColumns(10);
		AdminAddCustomerlName.setBounds(71, 45, 138, 28);
		frame.getContentPane().add(AdminAddCustomerlName);
		
		AdminAddCustomerIDnumber = new JTextField();
		AdminAddCustomerIDnumber.setColumns(10);
		AdminAddCustomerIDnumber.setBounds(71, 116, 138, 28);
		frame.getContentPane().add(AdminAddCustomerIDnumber);
		
		AdminAddCustomerEmail = new JTextField();
		AdminAddCustomerEmail.setColumns(10);
		AdminAddCustomerEmail.setBounds(71, 155, 138, 28);
		frame.getContentPane().add(AdminAddCustomerEmail);
		
		AdminAddCustomerCountry = new JTextField();
		AdminAddCustomerCountry.setColumns(10);
		AdminAddCustomerCountry.setBounds(295, 116, 138, 28);
		frame.getContentPane().add(AdminAddCustomerCountry);
		
		JButton btnAddClient = new JButton("Add Customer");
		btnAddClient.setBounds(568, 363, 117, 29);
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomControl().frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAddClient);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(340, 5, 76, 29);
		frame.getContentPane().add(lblCustomerId);
		
		AdminAddCustomerCID = new JTextField();
		AdminAddCustomerCID.setBounds(389, 45, 138, 28);
		frame.getContentPane().add(AdminAddCustomerCID);
		AdminAddCustomerCID.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(581, 47, 87, 23);

		frame.getContentPane().add(btnGenerate);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 226, 76, 29);
		frame.getContentPane().add(lblAddress);
		
	}
}
