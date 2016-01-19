package user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.SwingConstants;

import mainProgram.MainMethods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentInfo {
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the application.
	 */
	public PaymentInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmPaymentinfo = new JFrame();
		frmPaymentinfo.setResizable(false);
		frmPaymentinfo.setTitle("Payment Info");
		frmPaymentinfo.setBounds(100, 100, 480, 321);
		frmPaymentinfo.getContentPane().setLayout(null);
		frmPaymentinfo.setLocationRelativeTo(null);

		JLabel lblYourUsername = new JLabel("Logged in as " + MainMethods.loggeduser());
		lblYourUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourUsername.setBounds(85, 11, 280, 30);
		frmPaymentinfo.getContentPane().add(lblYourUsername);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(293, 52, 164, 30);
		frmPaymentinfo.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(293, 91, 164, 30);
		frmPaymentinfo.getContentPane().add(textField_2);

		JLabel lblEnterYourCredit = new JLabel("Edit your Credit Card Number");
		lblEnterYourCredit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterYourCredit.setBounds(10, 52, 250, 28);
		frmPaymentinfo.getContentPane().add(lblEnterYourCredit);

		JLabel lblEnterYourBank = new JLabel("Edit your Bank Account Number");
		lblEnterYourBank.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterYourBank.setBounds(10, 91, 250, 28);
		frmPaymentinfo.getContentPane().add(lblEnterYourBank);

		JLabel lblDefaultValueFor = new JLabel(
				"<html>(Default values for Credit Card Number<br>\r\nand Bank Account Number is null.)</html>");
		lblDefaultValueFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefaultValueFor.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDefaultValueFor.setBounds(10, 232, 447, 50);
		frmPaymentinfo.getContentPane().add(lblDefaultValueFor);

		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String card = textField_1.getText();
				String bank = textField_2.getText();

				UserMethods.payment(card, bank);
				frmPaymentinfo.dispose();

			}
		});
		button.setToolTipText("");
		button.setFont(new Font("Tahoma", Font.BOLD, 22));
		button.setBounds(129, 146, 200, 50);
		frmPaymentinfo.getContentPane().add(button);

		frmPaymentinfo.setVisible(true);

	}

}
