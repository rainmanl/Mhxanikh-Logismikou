package auctions;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class AuctionCreate {


	private JTextField textField;
	private JTextField textField_2;
	private JButton btnSubmit;
	private JTable table;
	private JLabel label;
	private JSeparator separator;
	private JTextField textField_1;
	private JTextField textField_3;
	private JLabel lblinDaysDefault;

	/**
	 * Create the application.
	 */
	public AuctionCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JFrame frmCreateAuction = new JFrame();
		frmCreateAuction.setResizable(false);
		frmCreateAuction.setTitle("Create Auction");
		frmCreateAuction.setBounds(100, 100, 528, 352);
		frmCreateAuction.setLocationRelativeTo(null);

		frmCreateAuction.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(140, 52, 138, 30);
		textField.setColumns(10);
		frmCreateAuction.getContentPane().add(textField);

		textField_2 = new JTextField();
		textField_2.setBounds(140, 131, 138, 30);
		textField_2.setColumns(10);
		frmCreateAuction.getContentPane().add(textField_2);

		JLabel lblNewUsername = new JLabel("Auction Name");
		lblNewUsername.setBounds(10, 52, 120, 29);
		lblNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateAuction.getContentPane().add(lblNewUsername);

		JLabel lblNewPassword = new JLabel("Starting Bid");
		lblNewPassword.setBounds(10, 92, 120, 28);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateAuction.getContentPane().add(lblNewPassword);

		JLabel lblEmail = new JLabel("Choose Category");
		lblEmail.setBounds(10, 131, 120, 30);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCreateAuction.getContentPane().add(lblEmail);

		table = new JTable();
		table.setBounds(300, 52, 212, 150);
		frmCreateAuction.getContentPane().add(table);
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

		btnSubmit = new JButton("Submit");
		btnSubmit.setToolTipText("");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String itemname = textField.getText();
				String bid = textField_1.getText();
				String category = textField_2.getText();
				AuctionMethods.createauction(itemname, bid, category);

				frmCreateAuction.dispose();

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSubmit.setBounds(162, 248, 200, 50);
		frmCreateAuction.getContentPane().add(btnSubmit);

		label = new JLabel("List of available categories");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(300, 11, 212, 30);
		frmCreateAuction.getContentPane().add(label);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(288, 11, 102, 191);
		frmCreateAuction.getContentPane().add(separator);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 92, 138, 30);
		frmCreateAuction.getContentPane().add(textField_1);

		JLabel lblSetEndDate = new JLabel("Set End Date");
		lblSetEndDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSetEndDate.setBounds(10, 172, 120, 30);
		frmCreateAuction.getContentPane().add(lblSetEndDate);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 172, 138, 30);
		frmCreateAuction.getContentPane().add(textField_3);

		lblinDaysDefault = new JLabel("(in Days. Default is 7)");
		lblinDaysDefault.setHorizontalAlignment(SwingConstants.CENTER);
		lblinDaysDefault.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblinDaysDefault.setBounds(10, 202, 120, 19);
		frmCreateAuction.getContentPane().add(lblinDaysDefault);

		frmCreateAuction.setVisible(true);
	}
}
