package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class UserDelete {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserDelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmDeleteUser = new JFrame();
		frmDeleteUser.setResizable(false);
		frmDeleteUser.setTitle("Delete User");
		frmDeleteUser.setBounds(100, 100, 528, 314);
		frmDeleteUser.getContentPane().setLayout(null);
		frmDeleteUser.setLocationRelativeTo(null);

		JLabel lblareYouSure = new JLabel("Are you sure you want to delete your User Account?\r\n");
		lblareYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblareYouSure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblareYouSure.setBounds(55, 121, 414, 43);
		frmDeleteUser.getContentPane().add(lblareYouSure);

		JButton btnNewButton = new JButton("YES");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textField.getText();
				char[] pw = passwordField.getPassword();
				String pw1 = new String(pw);

				UserMethods.deleteuser(user, pw1);
				frmDeleteUser.dispose();
			}
		});
		btnNewButton.setBounds(99, 217, 127, 51);
		frmDeleteUser.getContentPane().add(btnNewButton);

		JButton btnOxi = new JButton("NO");
		btnOxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDeleteUser.dispose();
			}
		});
		btnOxi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOxi.setBounds(300, 217, 127, 51);
		frmDeleteUser.getContentPane().add(btnOxi);

		JLabel lblThisOptionCant = new JLabel("This option CANNOT be undone!!");
		lblThisOptionCant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblThisOptionCant.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisOptionCant.setBounds(99, 175, 328, 31);
		frmDeleteUser.getContentPane().add(lblThisOptionCant);

		textField = new JTextField();
		textField.setBounds(268, 11, 159, 31);
		frmDeleteUser.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblConfirmUsername = new JLabel("Confirm Username");
		lblConfirmUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmUsername.setBounds(96, 11, 147, 31);
		frmDeleteUser.getContentPane().add(lblConfirmUsername);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(96, 55, 147, 31);
		frmDeleteUser.getContentPane().add(lblConfirmPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(268, 55, 159, 31);
		frmDeleteUser.getContentPane().add(passwordField);

		frmDeleteUser.setVisible(true);
	}
}
