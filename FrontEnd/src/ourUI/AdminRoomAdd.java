package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JList;

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
		frame.setTitle("Add new room (by Admin)");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRoomNumer = new JLabel("Room Numer");
		lblRoomNumer.setBounds(85, 58, 200, 28);
		frame.getContentPane().add(lblRoomNumer);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(85, 123, 200, 28);
		frame.getContentPane().add(lblCapacity);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(85, 197, 194, 28);
		frame.getContentPane().add(lblRoomType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(85, 272, 200, 28);
		frame.getContentPane().add(lblPrice);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(319, 59, 200, 28);
		frame.getContentPane().add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		txtCapacity = new JTextField();
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(319, 124, 200, 28);
		frame.getContentPane().add(txtCapacity);
		
		txtRoomType = new JTextField();
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(319, 198, 200, 28);
		frame.getContentPane().add(txtRoomType);

		
		txtPrice = new JTextField();
		txtPrice.setBounds(319, 273, 200, 28);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		btnAddRoom = new JButton("Add Room");
		btnAddRoom.setBounds(557, 422, 117, 29);
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
