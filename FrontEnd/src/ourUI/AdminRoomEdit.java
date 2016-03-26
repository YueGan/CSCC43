package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminRoomEdit {

	JFrame frame;
	private JTextField txtRoomNumber;
	private JTextField txtCapacity;
	private JTextField txtRoomType;
	private DBConnection adminConnect;
	private JTextField txtPrice;
	private ResultSet result = null;

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
	public AdminRoomEdit(DBConnection adminConnect) {
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
		System.out.println("AdminRoomEdit");
		adminConnect.executeQuery("SELECT * FROM customers;");
		JLabel lblRoomNumer = new JLabel("Room Numer");
		lblRoomNumer.setBounds(26, 6, 200, 28);
		frame.getContentPane().add(lblRoomNumer);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(26, 88, 200, 28);
		frame.getContentPane().add(lblCapacity);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(26, 128, 194, 28);
		frame.getContentPane().add(lblRoomType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(26, 168, 200, 28);
		frame.getContentPane().add(lblPrice);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(232, 6, 200, 28);
		frame.getContentPane().add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		txtCapacity = new JTextField();
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(232, 92, 200, 28);
		frame.getContentPane().add(txtCapacity);
		
		txtRoomType = new JTextField();
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(232, 128, 200, 28);
		frame.getContentPane().add(txtRoomType);

		
		txtPrice = new JTextField();
		txtPrice.setBounds(232, 168, 200, 28);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(232, 46, 117, 29);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Later, add try to catch if cusRef does not exist
				result = adminConnect.getRoom(txtRoomNumber.getText());
				try{
					while(result.next()){
						txtCapacity.setText(result.getString("capacity"));
						txtRoomType.setText(result.getString("roomType"));
						txtPrice.setText(result.getString("Price"));
					}
					
				} catch (SQLException ef) {
					// TODO Auto-generated catch block
					ef.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnGenerate);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(294, 229, 117, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtRoomNumber.equals("")){
					JOptionPane.showMessageDialog(null,"Please generate a customer first!");
				}
				else{
					adminConnect.updateMethod("room", "capacity", txtCapacity.getText(), "roomNumber", txtRoomNumber.getText());
					adminConnect.updateMethod("room", "roomType", txtRoomType.getText(), "roomNumber", txtRoomNumber.getText());
					adminConnect.updateMethod("room", "Price", txtPrice.getText(), "roomNumber", txtRoomNumber.getText());
					new AdminRoomControl(adminConnect).frame.setVisible(true);
					// Change later to visible
					frame.dispose();
			}
			}
		});
		frame.getContentPane().add(btnSave);
	}

}
