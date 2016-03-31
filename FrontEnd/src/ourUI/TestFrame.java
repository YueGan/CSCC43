package ourUI;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class TestFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame window = new TestFrame();
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
	public TestFrame() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 83, 350, 139);
		TextField k=new TextField();
		k.setText("APPLE!");
		panel.add(k);
		JButton apple = new JButton();
		apple.setText("WHAT!");
		panel.add(apple);
		
		ArrayList<JRadioButton> listButtons = new ArrayList<JRadioButton>();
		
		for(int i = 0; i < 5; i++){
			listButtons.add(new JRadioButton("????"));
			panel.add(listButtons.get(i));
		}
		frame.getContentPane().add(panel);

	}

}
