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

public class ReservationsControl {

	JFrame frame;
	private DBConnection adminConnect;
	private JTextField txtReservationRef;
	private JTextField txtRoomNumber;
	private JTextField txtInDate;
	private JTextField txtOutDate;
	private JTextField txtPrice;
	private JTextField txtPayingMethod;
	private JTextField txtComments;
	private ResultSet targetReservation;
	private ResultSet targetInvoice;
	private JTextField txtisPaid;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationsControl window = new ReservationsControl(new DBConnection("jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5112390", "sql5112390", "GRa9gFy4NQ"));
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
	public ReservationsControl(DBConnection adminConnect) {
		this.adminConnect = adminConnect;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Editing Reservation Page");  
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReservation = new JLabel("Reservation Number");
		lblReservation.setBounds(99, 43, 200, 23);
		frame.getContentPane().add(lblReservation);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(29, 136, 104, 23);
		frame.getContentPane().add(lblRoomNumber);
		
		JLabel label = new JLabel("InDate");
		label.setBounds(26, 204, 104, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("OutDate");
		label_1.setBounds(26, 253, 104, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Price");
		label_2.setBounds(351, 314, 104, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("PayingMethod");
		label_3.setBounds(26, 314, 104, 23);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Comments");
		label_4.setBounds(29, 370, 63, 23);
		frame.getContentPane().add(label_4);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(124, 134, 150, 28);
		frame.getContentPane().add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		txtInDate = new JTextField();
		txtInDate.setColumns(10);
		txtInDate.setBounds(124, 202, 150, 28);
		frame.getContentPane().add(txtInDate);
		
		txtOutDate = new JTextField();
		txtOutDate.setColumns(10);
		txtOutDate.setBounds(124, 251, 150, 28);
		frame.getContentPane().add(txtOutDate);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(416, 312, 209, 28);
		frame.getContentPane().add(txtPrice);
		
		txtPayingMethod = new JTextField();
		txtPayingMethod.setColumns(10);
		txtPayingMethod.setBounds(124, 312, 175, 28);
		frame.getContentPane().add(txtPayingMethod);
		
		txtComments = new JTextField();
		txtComments.setColumns(10);
		txtComments.setBounds(124, 368, 505, 28);
		frame.getContentPane().add(txtComments);
		
		txtReservationRef = new JTextField();
		txtReservationRef.setBounds(243, 43, 187, 23);
		frame.getContentPane().add(txtReservationRef);
		txtReservationRef.setColumns(10);
		
		txtisPaid = new JTextField();
		txtisPaid.setBounds(497, 165, 50, 28);
		frame.getContentPane().add(txtisPaid);
		txtisPaid.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(524, 40, 117, 29);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				targetReservation = adminConnect.getReservation(txtReservationRef.getText());
				targetInvoice = adminConnect.getInvoice(txtReservationRef.getText());
				try {
					txtRoomNumber.setText(targetReservation.getString("roomNumber"));
					txtInDate.setText(targetReservation.getString("InDate"));
					txtOutDate.setText(targetReservation.getString("OutDate"));
					txtPrice.setText(targetInvoice.getString("amount"));
					txtPayingMethod.setText(targetInvoice.getString("payingMethod"));
					txtComments.setText(targetInvoice.getString("comments"));
					txtisPaid.setText(targetInvoice.getString("ispaid"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnGenerate);
		
		
		JButton btnBack = new JButton("Cancel");
		btnBack.setBounds(430, 422, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminControl(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(557, 422, 117, 29);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtReservationRef.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Reservation Ref first :)");
				}else{
					adminConnect.updateMethod("reservations", "InDate", txtInDate.getText(), "reservationRef", txtReservationRef.getText());
					adminConnect.updateMethod("reservations", "OutDate", txtOutDate.getText(), "reservationRef", txtReservationRef.getText());
					adminConnect.updateMethod("invoice", "amount", txtPrice.getText(), "reservationRef", txtReservationRef.getText());
					adminConnect.updateMethod("invoice", "ispaid", txtisPaid.getText(), "reservationRef", txtReservationRef.getText());
					adminConnect.updateMethod("invoice", "payingMethod", txtPayingMethod.getText(), "reservationRef", txtReservationRef.getText());
					adminConnect.updateMethod("invoice", "comments", txtComments.getText(), "reservationRef", txtReservationRef.getText());
					new AdminControl(adminConnect).frame.setVisible(true);
	
					// Change later to visible
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblPaid = new JLabel("Paid ?");
		lblPaid.setBounds(503, 122, 44, 50);
		frame.getContentPane().add(lblPaid);
		
		
		

	}
}
