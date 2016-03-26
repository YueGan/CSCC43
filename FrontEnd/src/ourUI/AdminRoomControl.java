package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class AdminRoomControl {

	JFrame frame;
	private DBConnection adminConnect;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					//AdminRoomControl window = new AdminRoomControl();
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
	public AdminRoomControl(DBConnection adminConnect) {
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

		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.setBounds(65, 23, 328, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomAdd(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEditRoomInformation = new JButton("Edit Room Information");
		btnEditRoomInformation.setBounds(65, 51, 328, 29);
		btnEditRoomInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomEdit(adminConnect).frame.setVisible(true);

				
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEditRoomInformation);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setBounds(65, 87, 328, 29);
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminCustomerAdd(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAddCustomer);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setBounds(65, 128, 328, 29);
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminCustomerEdit(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEditUser);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(307, 216, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminControl(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);
	}
}
