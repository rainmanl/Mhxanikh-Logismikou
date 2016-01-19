package user;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mainProgram.MainMethods;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Color;

public class UserEdit {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSubmit;
	private JLabel lblYourUsername;
	private JLabel label_1;
	private JLabel lblNewEmail;
	private JLabel lblNewAddress;
	private JLabel lblNewMobileNumber;
	private JPasswordField passwordField;
	private JTable table;
	private JTextPane txtpnUsername;
	private JTextPane txtpnEmail;
	private JTextPane txtpnAddress;
	private JTextPane txtpnMobile;
	private JTextPane txtpnUserRating;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmEditUserAccount = new JFrame();
		frmEditUserAccount.setResizable(false);
		frmEditUserAccount.setTitle("Edit User Account Information\t");
		frmEditUserAccount.setBounds(100, 100, 676, 439);
		frmEditUserAccount.getContentPane().setLayout(null);
		frmEditUserAccount.setLocationRelativeTo(null);

		textField_1 = new JTextField();
		textField_1.setBounds(360, 213, 170, 30);
		textField_1.setColumns(10);
		frmEditUserAccount.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(360, 254, 170, 30);
		textField_2.setColumns(10);
		frmEditUserAccount.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(360, 295, 170, 30);
		textField_3.setColumns(10);
		frmEditUserAccount.getContentPane().add(textField_3);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String mail = textField_1.getText();
				String addr = textField_2.getText();
				String mbl = textField_3.getText();
				char[] pw = passwordField.getPassword();
				String pw1 = new String(pw);

				UserMethods.edituser(pw1, mail, addr, mbl);

				frmEditUserAccount.dispose();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSubmit.setBounds(246, 338, 200, 50);
		frmEditUserAccount.getContentPane().add(btnSubmit);

		lblYourUsername = new JLabel("Logged in as " + MainMethods.loggeduser());
		lblYourUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourUsername.setBounds(192, 11, 280, 30);
		frmEditUserAccount.getContentPane().add(lblYourUsername);

		label_1 = new JLabel("New Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(165, 174, 120, 28);
		frmEditUserAccount.getContentPane().add(label_1);

		lblNewEmail = new JLabel("New E-mail");
		lblNewEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewEmail.setBounds(165, 213, 120, 30);
		frmEditUserAccount.getContentPane().add(lblNewEmail);

		lblNewAddress = new JLabel("New Address");
		lblNewAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewAddress.setBounds(165, 254, 120, 30);
		frmEditUserAccount.getContentPane().add(lblNewAddress);

		lblNewMobileNumber = new JLabel("New Mobile Number");
		lblNewMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewMobileNumber.setBounds(165, 297, 155, 30);
		frmEditUserAccount.getContentPane().add(lblNewMobileNumber);

		passwordField = new JPasswordField();
		passwordField.setBounds(360, 174, 170, 30);
		frmEditUserAccount.getContentPane().add(passwordField);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setRowSelectionAllowed(false);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setEnabled(false);
		table.setBounds(10, 90, 650, 17);
		frmEditUserAccount.getContentPane().add(table);

		UserMethods.viewinfo(table);

		txtpnUsername = new JTextPane();
		txtpnUsername.setText("Username");
		txtpnUsername.setForeground(Color.WHITE);
		txtpnUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(Color.DARK_GRAY);
		txtpnUsername.setBounds(10, 69, 130, 19);
		frmEditUserAccount.getContentPane().add(txtpnUsername);

		txtpnEmail = new JTextPane();
		txtpnEmail.setText("E-mail");
		txtpnEmail.setForeground(Color.WHITE);
		txtpnEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(Color.DARK_GRAY);
		txtpnEmail.setBounds(140, 69, 130, 19);
		frmEditUserAccount.getContentPane().add(txtpnEmail);

		txtpnAddress = new JTextPane();
		txtpnAddress.setText("Address");
		txtpnAddress.setForeground(Color.WHITE);
		txtpnAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAddress.setEditable(false);
		txtpnAddress.setBackground(Color.DARK_GRAY);
		txtpnAddress.setBounds(270, 69, 130, 19);
		frmEditUserAccount.getContentPane().add(txtpnAddress);

		txtpnMobile = new JTextPane();
		txtpnMobile.setText("Mobile");
		txtpnMobile.setForeground(Color.WHITE);
		txtpnMobile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnMobile.setEditable(false);
		txtpnMobile.setBackground(Color.DARK_GRAY);
		txtpnMobile.setBounds(400, 69, 130, 19);
		frmEditUserAccount.getContentPane().add(txtpnMobile);

		txtpnUserRating = new JTextPane();
		txtpnUserRating.setText("User Rating");
		txtpnUserRating.setForeground(Color.WHITE);
		txtpnUserRating.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnUserRating.setEditable(false);
		txtpnUserRating.setBackground(Color.DARK_GRAY);
		txtpnUserRating.setBounds(530, 69, 130, 19);
		frmEditUserAccount.getContentPane().add(txtpnUserRating);

		frmEditUserAccount.setVisible(true);

	}
}
