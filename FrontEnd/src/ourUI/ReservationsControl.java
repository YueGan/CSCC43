package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReservationsControl {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationsControl window = new ReservationsControl();
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
	public ReservationsControl() {
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
		
		JLabel lblReservation = new JLabel("Reservation #");
		lblReservation.setBounds(31, 25, 200, 50);
		frame.getContentPane().add(lblReservation);
		
		textField = new JTextField();
		textField.setBounds(220, 25, 200, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDisplayReservationsHere = new JLabel("Display Reservations here");
		lblDisplayReservationsHere.setBounds(56, 122, 200, 50);
		frame.getContentPane().add(lblDisplayReservationsHere);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(303, 87, 117, 29);
		frame.getContentPane().add(btnGenerate);
	}
}
