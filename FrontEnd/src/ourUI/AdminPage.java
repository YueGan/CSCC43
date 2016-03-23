package ourUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage {

	private JFrame frame;
	private JTextField txtAccount;
	private JTextField txtPassword;
	private JLabel lblAccount;
	private JLabel lblPassword;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
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
	public AdminPage() {
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
		
		lblAccount = new JLabel("Account");
		lblAccount.setBounds(72, 64, 117, 16);
		frame.getContentPane().add(lblAccount);
		
		txtAccount = new JTextField();
		txtAccount.setBounds(136, 58, 227, 28);
		frame.getContentPane().add(txtAccount);
		txtAccount.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(72, 124, 117, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(136, 118, 227, 28);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(163, 208, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}

}
