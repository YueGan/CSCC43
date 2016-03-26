package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ChooseUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseUser window = new ChooseUser();
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
	public ChooseUser() {
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
		
		JLabel lblWecomeToHotel = new JLabel("Wecome to Hotel Management System 2.0");
		lblWecomeToHotel.setBounds(104, 42, 277, 16);
		frame.getContentPane().add(lblWecomeToHotel);
		
		JLabel lblLogInAs = new JLabel("Proceed in as:");
		lblLogInAs.setBounds(22, 134, 103, 16);
		frame.getContentPane().add(lblLogInAs);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.setBounds(142, 129, 117, 29);
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Load Admin database and pass the parameter to next page
				// todo.
				new AdminPage().frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAdministrator);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(286, 129, 117, 29);
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Load Admin database and pass the parameter to next page
				// todo.
				new RoomReservationPage(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390", "sql5112390", "GRa9gFy4NQ")).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCustomer);
	}
}
