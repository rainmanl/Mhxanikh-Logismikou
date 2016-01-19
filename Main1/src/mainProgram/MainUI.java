package mainProgram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI {

	private JFrame frmAuctionApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frmAuctionApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmAuctionApp = new JFrame();
		frmAuctionApp.setTitle("APP MAIN");
		frmAuctionApp.setResizable(false);
		frmAuctionApp.setBounds(100, 100, 799, 470);
		frmAuctionApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuctionApp.getContentPane().setLayout(null);

		frmAuctionApp.setLocationRelativeTo(null);

		JLabel lblWelcome = new JLabel("Welcome to our online auction system.");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(177, 26, 443, 95);
		frmAuctionApp.getContentPane().add(lblWelcome);

		JButton btnNewButton = new JButton("LOGIN as USER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLogin();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(139, 160, 214, 95);
		frmAuctionApp.getContentPane().add(btnNewButton);

		JButton btnLoginAsAdmin = new JButton("LOGIN as ADMIN");
		btnLoginAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminLogin();
			}
		});
		btnLoginAsAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoginAsAdmin.setBounds(438, 160, 214, 95);
		frmAuctionApp.getContentPane().add(btnLoginAsAdmin);

		JLabel lblTeipirCo = new JLabel("by Omada14 CO.");
		lblTeipirCo.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblTeipirCo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeipirCo.setBounds(657, 390, 126, 41);
		frmAuctionApp.getContentPane().add(lblTeipirCo);

		JButton btnNewButton_1 = new JButton("Create USER ACCOUNT\t");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserCreate();
			}
		});
		btnNewButton_1.setBounds(139, 287, 214, 95);
		frmAuctionApp.getContentPane().add(btnNewButton_1);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(438, 287, 214, 95);
		frmAuctionApp.getContentPane().add(btnExit);

	}
}
