package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class UserRating {

	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserRating() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmRateUsers = new JFrame();
		frmRateUsers.setResizable(false);
		frmRateUsers.setTitle("Rate Users");
		frmRateUsers.setBounds(100, 100, 599, 262);
		frmRateUsers.getContentPane().setLayout(null);
		frmRateUsers.setVisible(true);
		frmRateUsers.setLocationRelativeTo(null);

		JLabel lblrateSellerOf = new JLabel("<html>Rate Seller of Auction.<br>\r\nEnter Seller Username.</html>");
		lblrateSellerOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblrateSellerOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrateSellerOf.setBounds(275, 11, 298, 61);
		frmRateUsers.getContentPane().add(lblrateSellerOf);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(309, 83, 214, 33);
		frmRateUsers.getContentPane().add(textField);

		JButton button = new JButton("RATE +1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();

				UserMethods.rating(user);
				frmRateUsers.dispose();

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(370, 131, 96, 33);
		frmRateUsers.getContentPane().add(button);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(10, 43, 255, 170);
		frmRateUsers.getContentPane().add(table);
		UserMethods.showusers(table);

		JLabel lblMaxScoreIs = new JLabel("(Max Score is 100)");
		lblMaxScoreIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxScoreIs.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblMaxScoreIs.setBounds(275, 175, 298, 38);
		frmRateUsers.getContentPane().add(lblMaxScoreIs);

		JLabel lblListOfUsers = new JLabel("List of users and their scores");
		lblListOfUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfUsers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListOfUsers.setBounds(10, 11, 255, 21);
		frmRateUsers.getContentPane().add(lblListOfUsers);
	}

}
