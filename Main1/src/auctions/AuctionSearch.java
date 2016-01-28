package auctions;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JSeparator;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class AuctionSearch {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	private JTable table_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public AuctionSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmAuctionSearch = new JFrame();
		frmAuctionSearch.setResizable(false);
		frmAuctionSearch.setTitle("Auction Search");
		frmAuctionSearch.setBounds(100, 100, 744, 729);
		frmAuctionSearch.getContentPane().setLayout(null);
		frmAuctionSearch.setLocationRelativeTo(null);

		JLabel lblHereYouCan = new JLabel("Here you can search for an auction");
		lblHereYouCan.setBounds(148, 11, 263, 37);
		lblHereYouCan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereYouCan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmAuctionSearch.getContentPane().add(lblHereYouCan);

		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(10, 438, 720, 159);
		frmAuctionSearch.getContentPane().add(table_1);

		JLabel lblListOfAuctions = new JLabel("List of auctions matching the selected category and price");
		lblListOfAuctions.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfAuctions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListOfAuctions.setBounds(10, 382, 720, 19);
		frmAuctionSearch.getContentPane().add(lblListOfAuctions);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.setRowCount(0);

				String category = textField.getText();
				String above = textField_1.getText();
				String below = textField_2.getText();

				AuctionMethods.search(table_1, category, above, below);

			}
		});
		btnNewButton.setBounds(190, 334, 130, 37);
		frmAuctionSearch.getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JTextPane txtpnAuctionName = new JTextPane();
		txtpnAuctionName.setForeground(Color.WHITE);
		txtpnAuctionName.setBackground(Color.DARK_GRAY);
		txtpnAuctionName.setEditable(false);
		txtpnAuctionName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAuctionName.setText("Auction Name");
		txtpnAuctionName.setBounds(10, 418, 144, 19);
		frmAuctionSearch.getContentPane().add(txtpnAuctionName);

		JTextPane txtpnPriceIn = new JTextPane();
		txtpnPriceIn.setForeground(Color.WHITE);
		txtpnPriceIn.setBackground(Color.DARK_GRAY);
		txtpnPriceIn.setEditable(false);
		txtpnPriceIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnPriceIn.setText("Price in \u20AC");
		txtpnPriceIn.setBounds(154, 418, 144, 19);
		frmAuctionSearch.getContentPane().add(txtpnPriceIn);

		JTextPane txtpnOwnercreator = new JTextPane();
		txtpnOwnercreator.setForeground(Color.WHITE);
		txtpnOwnercreator.setBackground(Color.DARK_GRAY);
		txtpnOwnercreator.setEditable(false);
		txtpnOwnercreator.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnOwnercreator.setText("Owner/Creator");
		txtpnOwnercreator.setBounds(442, 418, 144, 19);
		frmAuctionSearch.getContentPane().add(txtpnOwnercreator);

		JTextPane txtpnTimeRemaining = new JTextPane();
		txtpnTimeRemaining.setForeground(Color.WHITE);
		txtpnTimeRemaining.setBackground(Color.DARK_GRAY);
		txtpnTimeRemaining.setEditable(false);
		txtpnTimeRemaining.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnTimeRemaining.setText("Time Left (days)");
		txtpnTimeRemaining.setBounds(298, 418, 144, 19);
		frmAuctionSearch.getContentPane().add(txtpnTimeRemaining);

		JLabel lblEnterDesiredAuction = new JLabel("Enter Desired Auction Name to Bid");
		lblEnterDesiredAuction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterDesiredAuction.setBounds(10, 606, 310, 33);
		frmAuctionSearch.getContentPane().add(lblEnterDesiredAuction);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(337, 606, 188, 33);
		frmAuctionSearch.getContentPane().add(textField_3);

		JButton btnNewButton_1 = new JButton("BID");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auction = textField_3.getText();
				String bid = textField_4.getText();

				AuctionMethods.bid(auction, bid);

				textField_3.setText(null);
				textField_4.setText(null);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(582, 606, 148, 33);
		frmAuctionSearch.getContentPane().add(btnNewButton_1);

		JLabel lblPresssearchTo = new JLabel("Press \"Search\" to search for Auctions");
		lblPresssearchTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPresssearchTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresssearchTo.setBounds(190, 290, 360, 33);
		frmAuctionSearch.getContentPane().add(lblPresssearchTo);

		table = new JTable();
		table.setBounds(109, 111, 223, 168);
		frmAuctionSearch.getContentPane().add(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setEnabled(false);
		table.setShowHorizontalLines(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(0, 0));
		table.setSurrendersFocusOnKeystroke(true);

		AuctionMethods.catlist(table);

		textField = new JTextField();
		textField.setBounds(383, 110, 211, 28);
		frmAuctionSearch.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblListOfAvailable = new JLabel("List of available categories");
		lblListOfAvailable.setBounds(109, 73, 223, 30);
		frmAuctionSearch.getContentPane().add(lblListOfAvailable);
		lblListOfAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfAvailable.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("Enter Desired Category");
		lblNewLabel.setBounds(383, 73, 211, 27);
		frmAuctionSearch.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblEnterDesiredPrice = new JLabel("<html>You can also<br>\r\nEnter Desired Price Range<html>");
		lblEnterDesiredPrice.setBounds(383, 166, 211, 37);
		frmAuctionSearch.getContentPane().add(lblEnterDesiredPrice);
		lblEnterDesiredPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDesiredPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblMinimum = new JLabel("Minimum");
		lblMinimum.setBounds(370, 214, 74, 27);
		frmAuctionSearch.getContentPane().add(lblMinimum);
		lblMinimum.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblMaxmum = new JLabel("Maximum");
		lblMaxmum.setBounds(370, 252, 74, 27);
		frmAuctionSearch.getContentPane().add(lblMaxmum);
		lblMaxmum.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_2 = new JTextField();
		textField_2.setBounds(454, 251, 71, 28);
		frmAuctionSearch.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(454, 214, 71, 28);
		frmAuctionSearch.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblpriceIsIn = new JLabel("(Price is in \u20AC)");
		lblpriceIsIn.setBounds(535, 252, 94, 27);
		frmAuctionSearch.getContentPane().add(lblpriceIsIn);
		lblpriceIsIn.setFont(new Font("Tahoma", Font.ITALIC, 15));

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(353, 73, 31, 206);
		frmAuctionSearch.getContentPane().add(separator);

		JButton btnClearTable = new JButton("Clear Table");
		btnClearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.setRowCount(0);
			}
		});

		btnClearTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClearTable.setBounds(423, 334, 130, 37);
		frmAuctionSearch.getContentPane().add(btnClearTable);

		JLabel lblEnterDesiredBidding = new JLabel("Enter Desired Higher Bidding Price(\u20AC)");
		lblEnterDesiredBidding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterDesiredBidding.setBounds(10, 648, 310, 33);
		frmAuctionSearch.getContentPane().add(lblEnterDesiredBidding);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(337, 648, 188, 33);
		frmAuctionSearch.getContentPane().add(textField_4);

		JTextPane txtpnLastHighBid = new JTextPane();
		txtpnLastHighBid.setText("Last High Bid");
		txtpnLastHighBid.setForeground(Color.WHITE);
		txtpnLastHighBid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLastHighBid.setEditable(false);
		txtpnLastHighBid.setBackground(Color.DARK_GRAY);
		txtpnLastHighBid.setBounds(586, 418, 144, 19);
		frmAuctionSearch.getContentPane().add(txtpnLastHighBid);
		frmAuctionSearch.setVisible(true);
	}
}
