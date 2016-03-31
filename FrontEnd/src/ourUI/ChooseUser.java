package ourUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ChooseUser {

	JFrame frame;

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
		frame.setTitle("Welcome Page");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWecomeToHotel = new JLabel("Wecome to Four Point O Hotel Managing System 2.0");
		lblWecomeToHotel.setFont(new Font("Mistral", Font.BOLD, 20));
		lblWecomeToHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblWecomeToHotel.setBounds(0, 38, 684, 29);
		frame.getContentPane().add(lblWecomeToHotel);
		
		JLabel lblLogInAs = new JLabel("Proceed in as:");
		lblLogInAs.setBounds(93, 368, 103, 16);
		frame.getContentPane().add(lblLogInAs);
		
		//Image image=new ImageIcon("icon.jpg").getImage();  
		//JPanel panel = new BackgroundPanel(image);  
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.setBounds(251, 362, 117, 29);
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
		btnCustomer.setBounds(462, 362, 117, 29);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/Gavin/Desktop/CSCC43/FrontEnd/src/icon.jpg"));
		lblNewLabel.setBounds(39, 77, 596, 273);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
