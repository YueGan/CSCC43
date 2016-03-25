package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminRoomAdd {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAddRoom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRoomAdd window = new AdminRoomAdd();
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
	public AdminRoomAdd() {
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
		
		JLabel lblRoomNumer = new JLabel("Room Numer");
		lblRoomNumer.setBounds(26, 28, 200, 50);
		frame.getContentPane().add(lblRoomNumer);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(26, 105, 200, 50);
		frame.getContentPane().add(lblCapacity);
		
		textField = new JTextField();
		textField.setBounds(232, 28, 200, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(232, 105, 200, 50);
		frame.getContentPane().add(textField_1);
		
		btnAddRoom = new JButton("Add Room");
		btnAddRoom.setBounds(291, 219, 117, 29);
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomControl().frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAddRoom);
	}

}
