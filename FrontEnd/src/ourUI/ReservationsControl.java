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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReservation = new JLabel("Reservation #");
		lblReservation.setBounds(29, 6, 200, 23);
		frame.getContentPane().add(lblReservation);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(26, 53, 104, 23);
		frame.getContentPane().add(lblRoomNumber);
		
		JLabel label = new JLabel("InDate");
		label.setBounds(26, 84, 104, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("OutDate");
		label_1.setBounds(26, 118, 104, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Price");
		label_2.setBounds(26, 147, 104, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("PayingMethod");
		label_3.setBounds(26, 178, 104, 23);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Comments");
		label_4.setBounds(26, 203, 104, 23);
		frame.getContentPane().add(label_4);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(175, 53, 150, 28);
		frame.getContentPane().add(txtRoomNumber);
		txtRoomNumber.setColumns(10);
		
		txtInDate = new JTextField();
		txtInDate.setColumns(10);
		txtInDate.setBounds(175, 81, 150, 28);
		frame.getContentPane().add(txtInDate);
		
		txtOutDate = new JTextField();
		txtOutDate.setColumns(10);
		txtOutDate.setBounds(175, 115, 150, 28);
		frame.getContentPane().add(txtOutDate);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(175, 144, 150, 28);
		frame.getContentPane().add(txtPrice);
		
		txtPayingMethod = new JTextField();
		txtPayingMethod.setColumns(10);
		txtPayingMethod.setBounds(175, 175, 150, 28);
		frame.getContentPane().add(txtPayingMethod);
		
		txtComments = new JTextField();
		txtComments.setColumns(10);
		txtComments.setBounds(175, 203, 150, 28);
		frame.getContentPane().add(txtComments);
		
		txtReservationRef = new JTextField();
		txtReservationRef.setBounds(240, 5, 166, 23);
		frame.getContentPane().add(txtReservationRef);
		txtReservationRef.setColumns(10);
		
		txtisPaid = new JTextField();
		txtisPaid.setBounds(362, 144, 50, 28);
		frame.getContentPane().add(txtisPaid);
		txtisPaid.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(327, 40, 117, 29);
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
		btnBack.setBounds(208, 243, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminControl(adminConnect).frame.setVisible(true);

				// Change later to visible
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(327, 243, 117, 29);
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
		lblPaid.setBounds(362, 104, 44, 50);
		frame.getContentPane().add(lblPaid);
		
		
		

	}
}
