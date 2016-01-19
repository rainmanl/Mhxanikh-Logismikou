package mainProgram;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Error() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmError = new JFrame();
		frmError.setResizable(false);
		frmError.setTitle("ERROR");
		frmError.setBounds(100, 100, 302, 167);
		frmError.getContentPane().setLayout(null);
		frmError.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("<html>ERROR!<br>\r\nPLEASE TRY AGAIN.</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 276, 64);
		frmError.getContentPane().add(lblNewLabel);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmError.dispose();
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOk.setBounds(111, 84, 68, 29);
		frmError.getContentPane().add(btnOk);
		frmError.setVisible(true);
	}
}
