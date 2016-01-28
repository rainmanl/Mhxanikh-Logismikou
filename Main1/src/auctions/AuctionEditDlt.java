package auctions;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuctionEditDlt {

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AuctionEditDlt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmEditdeleteAuciton = new JFrame();
		frmEditdeleteAuciton.setResizable(false);
		frmEditdeleteAuciton.setTitle("Edit/Delete Auciton");
		frmEditdeleteAuciton.setBounds(100, 100, 712, 467);
		frmEditdeleteAuciton.setLocationRelativeTo(null);
		frmEditdeleteAuciton.getContentPane().setLayout(null);
		frmEditdeleteAuciton.setLocationRelativeTo(null);
		frmEditdeleteAuciton.setVisible(true);

		JButton btnSearch = new JButton("SHOW AUCTIONS CREATED BY YOU");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AuctionMethods.showmyauction(table);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(170, 11, 346, 33);
		frmEditdeleteAuciton.getContentPane().add(btnSearch);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 262, 166, 30);
		frmEditdeleteAuciton.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 302, 166, 30);
		frmEditdeleteAuciton.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 341, 166, 30);
		frmEditdeleteAuciton.getContentPane().add(textField_3);

		JLabel lblNewCategory = new JLabel("New Category");
		lblNewCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewCategory.setBounds(10, 341, 144, 30);
		frmEditdeleteAuciton.getContentPane().add(lblNewCategory);

		JLabel lblNewStartingBid = new JLabel("New Starting Bid");
		lblNewStartingBid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewStartingBid.setBounds(10, 302, 144, 28);
		frmEditdeleteAuciton.getContentPane().add(lblNewStartingBid);

		JLabel lblNewAuctionName = new JLabel("New Auction Name");
		lblNewAuctionName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewAuctionName.setBounds(10, 262, 144, 29);
		frmEditdeleteAuciton.getContentPane().add(lblNewAuctionName);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setEnabled(false);
		table.setBounds(119, 76, 450, 82);
		frmEditdeleteAuciton.getContentPane().add(table);

		JTextPane txtpnAuctionName = new JTextPane();
		txtpnAuctionName.setText("Auction Name");
		txtpnAuctionName.setForeground(Color.WHITE);
		txtpnAuctionName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAuctionName.setEditable(false);
		txtpnAuctionName.setBackground(Color.DARK_GRAY);
		txtpnAuctionName.setBounds(119, 55, 150, 19);
		frmEditdeleteAuciton.getContentPane().add(txtpnAuctionName);

		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Category");
		txtpnCategory.setForeground(Color.WHITE);
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCategory.setEditable(false);
		txtpnCategory.setBackground(Color.DARK_GRAY);
		txtpnCategory.setBounds(269, 55, 150, 19);
		frmEditdeleteAuciton.getContentPane().add(txtpnCategory);

		JTextPane txtpnStaringBid = new JTextPane();
		txtpnStaringBid.setText("Staring Bid");
		txtpnStaringBid.setForeground(Color.WHITE);
		txtpnStaringBid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnStaringBid.setEditable(false);
		txtpnStaringBid.setBackground(Color.DARK_GRAY);
		txtpnStaringBid.setBounds(419, 55, 150, 19);
		frmEditdeleteAuciton.getContentPane().add(txtpnStaringBid);

		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String newname = textField_1.getText();
				String bid = textField_2.getText();
				String category = textField_3.getText();
				AuctionMethods.editauction(name, newname, bid, category);

				frmEditdeleteAuciton.dispose();

			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(93, 382, 137, 33);
		frmEditdeleteAuciton.getContentPane().add(btnEdit);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(340, 262, 38, 153);
		frmEditdeleteAuciton.getContentPane().add(separator);

		JLabel lblAreYouSure = new JLabel("Are you sure you want to delete the Auction?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAreYouSure.setBounds(340, 262, 346, 33);
		frmEditdeleteAuciton.getContentPane().add(lblAreYouSure);

		JLabel label = new JLabel("This option CANNOT be undone!!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(358, 322, 328, 31);
		frmEditdeleteAuciton.getContentPane().add(label);

		JButton button = new JButton("YES");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				AuctionMethods.deleteauction(name);

				textField.setText(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(358, 364, 127, 51);
		frmEditdeleteAuciton.getContentPane().add(button);

		JButton button_1 = new JButton("NO");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);

			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBounds(559, 364, 127, 51);
		frmEditdeleteAuciton.getContentPane().add(button_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(55, 169, 578, 19);
		frmEditdeleteAuciton.getContentPane().add(separator_1);

		JLabel lblEnterNameOf_1 = new JLabel("Enter name of Auction you want to edit or delete");
		lblEnterNameOf_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNameOf_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterNameOf_1.setBounds(91, 189, 328, 33);
		frmEditdeleteAuciton.getContentPane().add(lblEnterNameOf_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(432, 189, 174, 33);
		frmEditdeleteAuciton.getContentPane().add(textField);
	}
}
