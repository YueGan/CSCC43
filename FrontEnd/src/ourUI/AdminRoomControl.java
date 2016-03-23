package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class AdminRoomControl {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRoomControl window = new AdminRoomControl();
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
	public AdminRoomControl() {
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
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEditRoomInformation = new JButton("Edit Room Information");
		btnEditRoomInformation.setBounds(65, 51, 328, 29);
		frame.getContentPane().add(btnEditRoomInformation);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setBounds(65, 87, 328, 29);
		frame.getContentPane().add(btnAddCustomer);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setBounds(65, 128, 328, 29);
		frame.getContentPane().add(btnEditUser);
	}

}
