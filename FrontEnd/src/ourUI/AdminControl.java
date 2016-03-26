package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdministrator = new JButton("Room/Customer Control");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomControl(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		btnAdministrator.setBounds(54, 72, 331, 29);
		frame.getContentPane().add(btnAdministrator);
		
		JButton btnReservationsControl = new JButton("Reservations Control");
		btnReservationsControl.setBounds(54, 111, 331, 29);
		btnReservationsControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReservationsControl(adminConnect).frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnReservationsControl);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.setBounds(54, 185, 331, 29);
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomReservationPage(adminConnect).frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnMakeReservation);
		
		JLabel lblAdminContralPannel = new JLabel("Admin Control Pannel");
		lblAdminContralPannel.setBounds(54, 10, 331, 28);
		frame.getContentPane().add(lblAdminContralPannel);
	}
}
