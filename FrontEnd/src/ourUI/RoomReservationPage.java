package ourUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Panel;

import javax.swing.JPanel;

public class RoomReservationPage {

	JFrame frame;
	JFrame optionFrame;
	private JTextField txtCapacity;
	private JTextField txtCheckIn;
	private JTextField txtCheckOut;
	private DBConnection userConnect;
	private ResultSet searchResult;
	private ButtonGroup group;
	private String inDate;
	private String outDate;
	private String in;
	private String out;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomReservationPage window = new RoomReservationPage(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390", "sql5112390", "GRa9gFy4NQ"));
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
	public RoomReservationPage(DBConnection givenConnect) {
		userConnect = givenConnect;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setTitle("Search");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblCapacity = new JLabel("Room Size");
		lblCapacity.setBounds(101, 10, 68, 25);
		frame.getContentPane().add(lblCapacity);
		
		JLabel label = new JLabel("Check in(yyyyMMdd)");
		label.setBounds(246, 10, 134, 25);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Check out(yyyyMMdd)");
		label_1.setBounds(443, 10, 173, 25);
		frame.getContentPane().add(label_1);
		
		txtCapacity = new JTextField();
		txtCapacity.setBounds(101, 67, 68, 28);
		frame.getContentPane().add(txtCapacity);
		txtCapacity.setColumns(10);
		
		txtCheckIn = new JTextField();
		txtCheckIn.setBounds(246, 67, 134, 28);
		frame.getContentPane().add(txtCheckIn);
		txtCheckIn.setColumns(10);
		
		txtCheckOut = new JTextField();
		txtCheckOut.setBounds(443, 67, 134, 28);
		frame.getContentPane().add(txtCheckOut);
		txtCheckOut.setColumns(10);
		
		
		JLabel lblDisplayOptionHere = new JLabel("Option(s) : ");
		lblDisplayOptionHere.setBounds(10, 118, 200, 50);
		frame.getContentPane().add(lblDisplayOptionHere);
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 207, 452, 171);
		frame.getContentPane().add(panel);
		
		ArrayList<JRadioButton> listButtons = new ArrayList<JRadioButton>();
		
		JButton btnGenerate = new JButton("Search");
		btnGenerate.setBounds(544, 105, 117, 29);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				inDate = txtCheckIn.getText();
				outDate = txtCheckOut.getText();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
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
					
					SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
					in = ft.format(checkInDate);
					out = ft.format(checkOutDate);
					
					searchResult = userConnect.getSearch(txtCapacity.getText(), inDate, outDate);

				     
					group = new ButtonGroup(); 
					try {
						
						while(searchResult.next()){
     
							JRadioButton newbutton = new JRadioButton(searchResult.getString("roomNumber"));
							
							//System.out.println(searchResult.getString("roomNumber"));
							newbutton.setText("Room#: " + searchResult.getString("roomNumber") + 
									" Type: " + searchResult.getString("roomType") + 
									" Cap: " + searchResult.getString("capacity") + 
									" Price " + searchResult.getString("Price") );					
							
							listButtons.add(newbutton);
							group.add(newbutton);
							panel.add(newbutton);
						}
						SwingUtilities.updateComponentTreeUI(frame);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnGenerate);
		

		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(557, 422, 117, 29);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group == null){
					JOptionPane.showMessageDialog(null,"Please search for a room first!");
				}
				else{
					String roomNumber = "";
					int cusCapacity = 0;
					for(int i = 0; i < listButtons.size(); i++){
						if(listButtons.get(i).isSelected()){
							System.out.println(listButtons.get(i).getActionCommand().split(" ")[1]);
							roomNumber = listButtons.get(i).getActionCommand().split(" ")[1];
							cusCapacity = Integer.parseInt(listButtons.get(i).getActionCommand().split(" ")[5]);
						}
					}
					new CustomerReservation(userConnect, roomNumber, cusCapacity, in, out).frame.setVisible(true);
					// Change later to visible
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnNext);
		

		

		

		
		
		
		
		
		

	}
}
