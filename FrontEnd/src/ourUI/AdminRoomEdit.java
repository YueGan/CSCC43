package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminRoomEdit {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRoomEdit window = new AdminRoomEdit();
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
	public AdminRoomEdit() {
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
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(39, 10, 200, 50);
		frame.getContentPane().add(lblRoomNumber);
		
		textField = new JTextField();
		textField.setBounds(250, 10, 200, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(260, 72, 117, 29);
		frame.getContentPane().add(btnGenerate);
		
		JLabel lblDisplayRoomInfo = new JLabel("Display Room Info Here");
		lblDisplayRoomInfo.setBounds(39, 123, 200, 50);
		frame.getContentPane().add(lblDisplayRoomInfo);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(294, 229, 117, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminRoomControl().frame.setVisible(true);
				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnSave);
	}

}
