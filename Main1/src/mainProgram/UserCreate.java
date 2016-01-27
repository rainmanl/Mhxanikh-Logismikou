package mainProgram;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import user.UserMethods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserCreate {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSubmit;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public UserCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmCreateNewUser = new JFrame();
		frmCreateNewUser.setResizable(false);
		frmCreateNewUser.setTitle("Create User");
		frmCreateNewUser.setBounds(100, 100, 504, 333);
		frmCreateNewUser.setLocationRelativeTo(null);

		frmCreateNewUser.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(251, 11, 170, 30);
		textField.setColumns(10);
		frmCreateNewUser.getContentPane().add(textField);

		textField_1 = new JTextField(); 
		textField_1.setBounds(251, 90, 170, 30);
		textField_1.setColumns(10);
		frmCreateNewUser.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(251, 131, 170, 30);
		textField_2.setColumns(10);
		frmCreateNewUser.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(251, 174, 170, 30);
		textField_3.setColumns(10);
		frmCreateNewUser.getContentPane().add(textField_3);

		JLabel lblNewUsername = new JLabel("Username");
		lblNewUsername.setBounds(79, 11, 120, 29);
		lblNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateNewUser.getContentPane().add(lblNewUsername);

		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setBounds(79, 51, 120, 28);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateNewUser.getContentPane().add(lblNewPassword);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(79, 90, 120, 30);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateNewUser.getContentPane().add(lblEmail);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(79, 131, 120, 30);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateNewUser.getContentPane().add(lblAddress);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setBounds(79, 174, 120, 30);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateNewUser.getContentPane().add(lblMobileNumber);

		btnSubmit = new JButton("Submit");
		btnSubmit.setToolTipText("");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textField.getText();
				String mail = textField_1.getText();
				String addr = textField_2.getText();
				String mbl = textField_3.getText();
				char[] pw = passwordField.getPassword();
				String pw1 = new String(pw);

				UserMethods.createuser(user, pw1, mail, addr, mbl);

				frmCreateNewUser.dispose();

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSubmit.setBounds(141, 243, 200, 50);
		frmCreateNewUser.getContentPane().add(btnSubmit);

		passwordField = new JPasswordField();
		passwordField.setBounds(251, 51, 170, 30);
		frmCreateNewUser.getContentPane().add(passwordField);

		frmCreateNewUser.setVisible(true);
	}
}
