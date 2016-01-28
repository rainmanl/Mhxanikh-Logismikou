package user;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import admin.AdminMethods;
import auctions.AuctionCreate;
import auctions.AuctionEditDlt;
import auctions.AuctionSearch;
import mainProgram.MainMethods;

public class User {

	/**
	 * Create the application.
	 */
	public User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmUser = new JFrame();
		frmUser.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmUser.setResizable(false);
		frmUser.setTitle("User");
		frmUser.setBounds(100, 100, 460, 384);
		frmUser.getContentPane().setLayout(null);
		frmUser.setLocationRelativeTo(null);
		frmUser.setVisible(true);

		JButton btnNewAuction = new JButton("New Auction");
		btnNewAuction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AuctionCreate();
			}
		});
		btnNewAuction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewAuction.setBounds(231, 119, 211, 51);
		frmUser.getContentPane().add(btnNewAuction);

		JButton btnEdit = new JButton("Edit Payment Information");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PaymentInfo();

			}
		});
		btnEdit.setBounds(10, 119, 211, 51);
		frmUser.getContentPane().add(btnEdit);

		JButton btnSearchAuction = new JButton("Search Auction");
		btnSearchAuction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AuctionSearch();
			}
		});
		btnSearchAuction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearchAuction.setBounds(10, 181, 211, 51);
		frmUser.getContentPane().add(btnSearchAuction);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMethods.userlogout();
				frmUser.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogOut.setBounds(10, 300, 432, 45);
		frmUser.getContentPane().add(btnLogOut);

		JButton btnEditAuction = new JButton("Edit Auction");
		btnEditAuction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AuctionEditDlt();
			}
		});
		btnEditAuction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditAuction.setBounds(231, 181, 211, 51);
		frmUser.getContentPane().add(btnEditAuction);

		JButton button = new JButton("Delete Account");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserDelete();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(231, 57, 211, 51);
		frmUser.getContentPane().add(button);

		JButton button_1 = new JButton("Edit Account");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UserEdit();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(10, 57, 211, 51);
		frmUser.getContentPane().add(button_1);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(10, 11, 432, 45);
		lblWelcome.setText("Welcome " + MainMethods.loggeduser() + "!!");
		// prints on the corresponding label the username of the logged in user
		frmUser.getContentPane().add(lblWelcome);

		JButton btnRateUser = new JButton("Rate User");
		btnRateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserRating();
			}
		});
		btnRateUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRateUser.setBounds(10, 243, 432, 45);
		frmUser.getContentPane().add(btnRateUser);

		// calling method for setting button enabled/disabled
		AdminMethods.getbuttonstate();
		AdminMethods.buttonset(btnRateUser);

	}
}
