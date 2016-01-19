package mainProgram;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JPasswordField;

public class AdminLogin {

	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmAdminlogin = new JFrame();

		frmAdminlogin.setTitle("Admin Login");
		frmAdminlogin.setResizable(false);
		frmAdminlogin.setBounds(100, 100, 354, 248);
		frmAdminlogin.getContentPane().setLayout(null);
		frmAdminlogin.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 39, 113, 33);
		frmAdminlogin.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(33, 93, 113, 33);
		frmAdminlogin.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(178, 40, 124, 35);
		frmAdminlogin.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = textField.getText();
				char[] pw = passwordField.getPassword();
				String pw1 = new String(pw);

				MainMethods.adminlogin(username, pw1);
				frmAdminlogin.dispose();

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(107, 149, 113, 37);
		frmAdminlogin.getContentPane().add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(178, 95, 124, 33);
		frmAdminlogin.getContentPane().add(passwordField);

		frmAdminlogin.setVisible(true);
	}
}
