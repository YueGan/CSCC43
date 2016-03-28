package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AdminControl {

	JFrame frame;
	private DBConnection adminConnect;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdminControl window = new AdminControl(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390", "sql5112390", "GRa9gFy4NQ"));
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
	public AdminControl(DBConnection adminConnect) {
		this.adminConnect = adminConnect;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Admin Controling Panel");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdministrator = new JButton("Room/Customer Adminstrative");
		btnAdministrator.setFont(new Font("Bodoni MT Black", Font.PLAIN, 20));
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomControl(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		btnAdministrator.setBounds(78, 98, 507, 62);
		frame.getContentPane().add(btnAdministrator);
		
		JButton btnReservationsControl = new JButton("Reservations Control");
		btnReservationsControl.setFont(new Font("Bodoni MT Black", Font.PLAIN, 20));
		btnReservationsControl.setBounds(78, 170, 507, 62);
		btnReservationsControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReservationsControl(adminConnect).frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnReservationsControl);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.setFont(new Font("Bodoni MT Black", Font.PLAIN, 20));
		btnMakeReservation.setBounds(78, 361, 507, 62);
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomReservationPage(adminConnect).frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnMakeReservation);
		
		JLabel lblAdminContralPannel = new JLabel("Admin Control Pannel");
		lblAdminContralPannel.setFont(new Font("Poor Richard", Font.PLAIN, 33));
		lblAdminContralPannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminContralPannel.setBounds(10, 34, 664, 28);
		frame.getContentPane().add(lblAdminContralPannel);
		
		JLabel lblProceedAsA = new JLabel("Proceed as a Customer");
		lblProceedAsA.setFont(new Font("Poor Richard", Font.PLAIN, 33));
		lblProceedAsA.setHorizontalAlignment(SwingConstants.CENTER);
		lblProceedAsA.setBounds(0, 303, 684, 28);
		frame.getContentPane().add(lblProceedAsA);
	}
}
