package test.test3.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import test.test3.xcomponent.IReceivable;
import test.test3.xcomponent.ReceivableListener;

public class DateDailog extends JDialog implements IReceivable {

	private final JPanel contentPanel = new JPanel();
	private List<ReceivableListener> receiverListeners = new ArrayList<>();
	private JTextField textField;


	/**
	 * Create the dialog.
	 */
	public DateDailog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		{
			textField = new JTextField();
			textField.setFont(new Font("新細明體", Font.PLAIN, 30));
			contentPanel.add(textField);
			textField.setColumns(18);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						update();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void addReceivableListener(ReceivableListener listener) {
		this.receiverListeners.add(listener);
	}

	@Override
	public void update() {
		receiverListeners
		.forEach(x -> x.update(textField.getText()));
	}

}
