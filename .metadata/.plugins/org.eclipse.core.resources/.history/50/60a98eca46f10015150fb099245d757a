package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AdminControl {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControl window = new AdminControl();
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
	public AdminControl() {
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
		
		JButton btnAdministrator = new JButton("Room Control");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdministrator.setBounds(54, 22, 331, 29);
		frame.getContentPane().add(btnAdministrator);
		
		JButton btnCustomerControl = new JButton("Customer Control");
		btnCustomerControl.setBounds(54, 63, 331, 29);
		frame.getContentPane().add(btnCustomerControl);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.setBounds(54, 104, 331, 29);
		frame.getContentPane().add(btnMakeReservation);
	}
}
