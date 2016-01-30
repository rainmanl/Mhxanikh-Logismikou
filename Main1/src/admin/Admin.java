package admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import auctions.AuctionMethods;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

import java.awt.Font;

import mainProgram.*;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class Admin {

	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmAdmin = new JFrame();
		frmAdmin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAdmin.setResizable(false);
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 442, 556);
		frmAdmin.getContentPane().setLayout(null);
		frmAdmin.setVisible(true);
		frmAdmin.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("Create or Delete Categories");
		panel.setBorder(new TitledBorder(null, "Categories", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 24, 282, 145);
		frmAdmin.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cat = textField.getText();
				AdminMethods.catcreate(cat);
				textField.setText(null);
			}
		});
		btnCreate.setBounds(172, 38, 100, 30);
		panel.add(btnCreate);

		textField = new JTextField();
		textField.setBounds(10, 38, 152, 30);
		panel.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 79, 152, 30);
		panel.add(textField_2);

		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cat = textField_2.getText();
				AdminMethods.catdelete(cat);
				textField_2.setText(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(172, 79, 100, 30);
		panel.add(button);

		JButton btnLogot = new JButton("Log Out");
		btnLogot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMethods.adminlogout();
				frmAdmin.dispose();
			}
		});
		btnLogot.setBounds(245, 467, 184, 50);
		frmAdmin.getContentPane().add(btnLogot);

		JButton btnStats = new JButton("Statistics");
		btnStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new AdminStats();

			}
		});
		btnStats.setBounds(10, 467, 184, 50);
		frmAdmin.getContentPane().add(btnStats);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Set auction time limit");
		panel_1.setBorder(
				new TitledBorder(null, "Auction Time limit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(302, 24, 127, 145);
		frmAdmin.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnSetTime = new JButton("Set Time");
		btnSetTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String date = textField_3.getText();
				DateFormat date1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				Date date2 = null;
				try {
					date2 = date1.parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long date3 = date2.getTime();

				AdminMethods.timeset(date3);
				textField_3.setText(null);

			}
		});
		btnSetTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSetTime.setBounds(10, 28, 107, 30);
		panel_1.add(btnSetTime);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 104, 107, 30);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblinDays = new JLabel("(in Days)");
		lblinDays.setBounds(10, 66, 107, 27);
		panel_1.add(lblinDays);
		lblinDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblinDays.setFont(new Font("Tahoma", Font.ITALIC, 11));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("Edit Category");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Edit Category",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 180, 282, 276);
		frmAdmin.getContentPane().add(panel_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 111, 136, 23);
		panel_2.add(textField_4);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_1.getText();
				String newname = textField_4.getText();

				AdminMethods.catedit(name, newname);
				textField_1.setText(null);
				textField_4.setText(null);

			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(32, 145, 99, 35);
		panel_2.add(btnEdit);

		JLabel lblEnterExistingCategory = new JLabel("Enter Existing Category Name");
		lblEnterExistingCategory.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEnterExistingCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterExistingCategory.setBounds(10, 11, 144, 23);
		panel_2.add(lblEnterExistingCategory);

		JLabel lblEnterNewCategory = new JLabel("Enter New Category Name");
		lblEnterNewCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewCategory.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEnterNewCategory.setBounds(10, 77, 136, 23);
		panel_2.add(lblEnterNewCategory);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 43, 136, 23);
		panel_2.add(textField_1);

		table = new JTable();
		table.setEnabled(false);
		table.setBounds(164, 37, 108, 190);
		panel_2.add(table);

		AuctionMethods.catlist(table);

		JTextPane txtpnCategoryList = new JTextPane();
		txtpnCategoryList.setText("Category List");
		txtpnCategoryList.setForeground(Color.WHITE);
		txtpnCategoryList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnCategoryList.setEditable(false);
		txtpnCategoryList.setBackground(Color.DARK_GRAY);
		txtpnCategoryList.setBounds(164, 15, 108, 19);
		panel_2.add(txtpnCategoryList);

		JButton btnUpdateList = new JButton("Update List");
		btnUpdateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				AuctionMethods.catlist(table);
			}
		});
		btnUpdateList.setBounds(164, 238, 109, 27);
		panel_2.add(btnUpdateList);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setToolTipText("Enable or disable user ratings");
		panel_3.setBorder(new TitledBorder(null, "User Ratings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(302, 273, 127, 145);
		frmAdmin.getContentPane().add(panel_3);

		JButton button_1 = new JButton("Enable");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMethods.enablerate();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(10, 43, 107, 30);
		panel_3.add(button_1);

		JButton button_2 = new JButton("Disable");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMethods.disablerate();

			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_2.setBounds(10, 84, 107, 30);
		panel_3.add(button_2);
	}
}
