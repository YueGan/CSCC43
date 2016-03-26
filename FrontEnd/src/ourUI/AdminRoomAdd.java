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
	private JTextField txtRoomNumber;
	private JTextField txtCapacity;
	private JButton btnAddRoom;
	private JTextField txtRoomType;
	private DBConnection adminConnect;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminRoomAdd(DBConnection adminConnect) {
		this.adminConnect = adminConnect;
		initialize();
	}
	public void getConnection(DBConnection givenConnect){
		adminConnect = givenConnect;
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
		lblRoomNumer.setBounds(26, 6, 200, 28);
		frame.getContentPane().add(lblRoomNumer);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(26, 42, 200, 28);
		frame.getContentPane().add(lblCapacity);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(26, 82, 194, 28);
		frame.getContentPane().add(lblRoomType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(26, 122, 200, 28);
		frame.getContentPane().add(lblPrice);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(232, 6, 200, 28);
		frame.getContentPane().add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		txtCapacity = new JTextField();
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(232, 46, 200, 28);
		frame.getContentPane().add(txtCapacity);
		
		txtRoomType = new JTextField();
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(232, 82, 200, 28);
		frame.getContentPane().add(txtRoomType);

		
		txtPrice = new JTextField();
		txtPrice.setBounds(232, 122, 200, 28);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		btnAddRoom = new JButton("Add Room");
		btnAddRoom.setBounds(295, 229, 117, 29);
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminConnect.addRooms(Integer.parseInt(txtRoomNumber.getText()), txtRoomType.getText(),
						Integer.parseInt(txtCapacity.getText()), Double.parseDouble(txtPrice.getText()));
				
				new AdminRoomControl(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAddRoom);
		

		
		
		

	}
}
