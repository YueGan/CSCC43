package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RoomReservationPage {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DBConnection userConnect;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomReservationPage window = new RoomReservationPage();
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
	public RoomReservationPage() {
		initialize();
	}
	public void getConnection(DBConnection givenConnect){
		userConnect = givenConnect;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(25, 16, 61, 25);
		frame.getContentPane().add(lblCapacity);
		
		JLabel label = new JLabel("Check in");
		label.setBounds(176, 16, 61, 25);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Check out");
		label_1.setBounds(313, 16, 102, 25);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(25, 42, 68, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 42, 134, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(310, 42, 134, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDisplayOptionHere = new JLabel("Display Option Here");
		lblDisplayOptionHere.setBounds(25, 92, 200, 50);
		frame.getContentPane().add(lblDisplayOptionHere);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(284, 82, 117, 29);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(241, 158, 117, 29);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerReservation().frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNext);
	}

}
