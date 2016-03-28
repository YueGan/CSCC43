package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

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
		frame.setTitle("Administrative Controling Panel");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.setFont(new Font("Bodoni MT Black", Font.PLAIN, 17));
		btnNewButton.setBounds(165, 39, 350, 55);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomAdd(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEditRoomInformation = new JButton("Edit Room Information");
		btnEditRoomInformation.setFont(new Font("Bodoni MT Black", Font.PLAIN, 17));
		btnEditRoomInformation.setBounds(165, 127, 350, 55);
		btnEditRoomInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomEdit(adminConnect).frame.setVisible(true);

				
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEditRoomInformation);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setFont(new Font("Bodoni MT Black", Font.PLAIN, 17));
		btnAddCustomer.setBounds(165, 211, 350, 55);
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminCustomerAdd(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAddCustomer);
		
		JButton btnEditUser = new JButton("Edit User");
		btnEditUser.setFont(new Font("Bodoni MT Black", Font.PLAIN, 17));
		btnEditUser.setBounds(165, 296, 350, 55);
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminCustomerEdit(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEditUser);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(557, 422, 117, 29);
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
