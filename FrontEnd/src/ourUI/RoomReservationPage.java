package ourUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Panel;

public class RoomReservationPage {

	JFrame frame;
	private JTextField txtCapacity;
	private JTextField txtCheckIn;
	private JTextField txtCheckOut;
	private DBConnection userConnect;
	private ResultSet searchResult;
	private ButtonGroup group;
	private String inDate;
	private String outDate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//RoomReservationPage window = new RoomReservationPage(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390", "sql5112390", "GRa9gFy4NQ"));
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
	public RoomReservationPage(DBConnection givenConnect) {
		userConnect = givenConnect;
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
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(25, 16, 61, 25);
		frame.getContentPane().add(lblCapacity);
		
		JLabel label = new JLabel("Check in(dd-MM-yyyy)");
		label.setBounds(176, 16, 61, 25);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Check out(dd-MM-yyyy)");
		label_1.setBounds(313, 16, 102, 25);
		frame.getContentPane().add(label_1);
		
		txtCapacity = new JTextField();
		txtCapacity.setBounds(25, 42, 68, 28);
		frame.getContentPane().add(txtCapacity);
		txtCapacity.setColumns(10);
		
		txtCheckIn = new JTextField();
		txtCheckIn.setBounds(157, 42, 134, 28);
		frame.getContentPane().add(txtCheckIn);
		txtCheckIn.setColumns(10);
		
		txtCheckOut = new JTextField();
		txtCheckOut.setBounds(310, 42, 134, 28);
		frame.getContentPane().add(txtCheckOut);
		txtCheckOut.setColumns(10);
		
		JLabel lblDisplayOptionHere = new JLabel("Display Option Here");
		lblDisplayOptionHere.setBounds(25, 92, 200, 50);
		frame.getContentPane().add(lblDisplayOptionHere);
		
		Panel optionPanel = new Panel();
		optionPanel.setBounds(10, 137, 311, 131);
		frame.getContentPane().add(optionPanel);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(284, 82, 117, 29);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				inDate = txtCheckIn.getText();
				outDate = txtCheckOut.getText();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Date checkInDate = null;
				Date checkOutDate = null;
				try {
					checkInDate = format.parse(inDate);
					checkOutDate= format.parse(outDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				if(checkInDate.compareTo(checkOutDate) >= 0){
					JOptionPane.showMessageDialog(null,"Invalid Dates");
				}
				else{
					searchResult = userConnect.getSearch(txtCapacity.getText(), inDate, outDate);
					group = new ButtonGroup(); 
					try {
						while(searchResult.next()){
							JRadioButton newbutton = new JRadioButton();
							newbutton.setText("Room#: " + searchResult.getString("roomNumber") + 
									" Type: " + searchResult.getString("roomType") + 
									" Cap: " + searchResult.getString("capacity") + 
									" Price " + searchResult.getString("Price") );
							group.add(newbutton);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnGenerate);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(327, 239, 117, 29);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group == null){
					JOptionPane.showMessageDialog(null,"Please search for a room first!");
				}
				else{
					ButtonModel selectedRoom = group.getSelection();
					String roomNumber = selectedRoom.getActionCommand().split(" ")[1];
					new CustomerReservation(userConnect, roomNumber, inDate, outDate).frame.setVisible(true);
					// Change later to visible
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnNext);
		

	}
}
