package mainProgram;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserLogin {

	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmUserlogin = new JFrame();
		frmUserlogin.setTitle("User Login");
		frmUserlogin.setResizable(false);
		frmUserlogin.setBounds(100, 100, 354, 248);
		frmUserlogin.getContentPane().setLayout(null);
		frmUserlogin.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 39, 113, 33);
		frmUserlogin.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(33, 93, 113, 33);
		frmUserlogin.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(177, 39, 124, 35);
		frmUserlogin.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				char[] pw = passwordField.getPassword();
				String pw1 = new String(pw);

				MainMethods.usrlogin(username, pw1);
				frmUserlogin.dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(107, 149, 113, 37);
		frmUserlogin.getContentPane().add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 93, 123, 33);
		frmUserlogin.getContentPane().add(passwordField);

		frmUserlogin.setVisible(true);
	}
}
