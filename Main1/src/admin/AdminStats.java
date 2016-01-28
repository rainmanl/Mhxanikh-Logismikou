package admin;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminStats {
	private JTable table;

	public AdminStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmStatistics = new JFrame();
		frmStatistics.setResizable(false);
		frmStatistics.setTitle("Statistics");
		frmStatistics.setBounds(100, 100, 1067, 529);
		frmStatistics.setVisible(true);
		frmStatistics.getContentPane().setLayout(null);
		frmStatistics.setLocationRelativeTo(null);

		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStatistics.dispose();
			}
		});
		btnClose.setBounds(904, 450, 147, 40);
		frmStatistics.getContentPane().add(btnClose);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 11, -202, 168);
		frmStatistics.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(210, 24, -135, 174);
		frmStatistics.getContentPane().add(panel_2);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(11, 72, 1040, 272);
		frmStatistics.getContentPane().add(table);

		AdminMethods.auctionlist(table);

		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("Auction Name");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane_4.setEditable(false);
		textPane_4.setBackground(Color.DARK_GRAY);
		textPane_4.setBounds(11, 52, 130, 19);
		frmStatistics.getContentPane().add(textPane_4);

		JTextPane txtpnSumOfBidders = new JTextPane();
		txtpnSumOfBidders.setText("Sum of Bidders");
		txtpnSumOfBidders.setForeground(Color.WHITE);
		txtpnSumOfBidders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnSumOfBidders.setEditable(false);
		txtpnSumOfBidders.setBackground(Color.DARK_GRAY);
		txtpnSumOfBidders.setBounds(921, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnSumOfBidders);

		JTextPane txtpnLastBidin = new JTextPane();
		txtpnLastBidin.setText("Last Bid(in \u20AC)");
		txtpnLastBidin.setForeground(Color.WHITE);
		txtpnLastBidin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLastBidin.setEditable(false);
		txtpnLastBidin.setBackground(Color.DARK_GRAY);
		txtpnLastBidin.setBounds(791, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnLastBidin);

		JTextPane txtpnLastBidder = new JTextPane();
		txtpnLastBidder.setText("Last Bidder");
		txtpnLastBidder.setForeground(Color.WHITE);
		txtpnLastBidder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLastBidder.setEditable(false);
		txtpnLastBidder.setBackground(Color.DARK_GRAY);
		txtpnLastBidder.setBounds(661, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnLastBidder);

		JTextPane txtpnCreatorowner = new JTextPane();
		txtpnCreatorowner.setText("Creator/Owner");
		txtpnCreatorowner.setForeground(Color.WHITE);
		txtpnCreatorowner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCreatorowner.setEditable(false);
		txtpnCreatorowner.setBackground(Color.DARK_GRAY);
		txtpnCreatorowner.setBounds(531, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnCreatorowner);

		JTextPane txtpnTtl = new JTextPane();
		txtpnTtl.setText("TTL(in days)");
		txtpnTtl.setForeground(Color.WHITE);
		txtpnTtl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnTtl.setEditable(false);
		txtpnTtl.setBackground(Color.DARK_GRAY);
		txtpnTtl.setBounds(401, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnTtl);

		JTextPane txtpnStartingBid = new JTextPane();
		txtpnStartingBid.setText("Starting Bid(in \u20AC)");
		txtpnStartingBid.setForeground(Color.WHITE);
		txtpnStartingBid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnStartingBid.setEditable(false);
		txtpnStartingBid.setBackground(Color.DARK_GRAY);
		txtpnStartingBid.setBounds(271, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnStartingBid);

		JTextPane txtpnCategory = new JTextPane();
		txtpnCategory.setText("Category");
		txtpnCategory.setForeground(Color.WHITE);
		txtpnCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCategory.setEditable(false);
		txtpnCategory.setBackground(Color.DARK_GRAY);
		txtpnCategory.setBounds(141, 52, 130, 19);
		frmStatistics.getContentPane().add(txtpnCategory);

		JLabel lblListOfAuctions = new JLabel("LIST OF AUCTIONS");
		lblListOfAuctions.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfAuctions.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListOfAuctions.setBounds(10, 11, 1041, 30);
		frmStatistics.getContentPane().add(lblListOfAuctions);

	}
}
