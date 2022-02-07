package test.test3.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.test3.xcomponent.ReceivableButton;
import test.test3.xcomponent.ReceivableLabel;

public class DemoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DemoFrame() {
		initMainComponent();
		contentPane.setLayout(new BorderLayout(0, 0));
		{
			ReceivableLabel receivableLabel = new ReceivableLabel("內容") {
				@Override
				public void update(Object o) {
					this.setText("內容: " + (String) o);
				}
			};
			receivableLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 48));
			contentPane.add(receivableLabel, BorderLayout.CENTER);

			ReceivableButton receivableButton = new ReceivableButton("月份") {
				@Override
				public void update(Object o) {
					this.setText((String) o);
				}
			};
			receivableButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DateDailog dailog = new DateDailog();
					dailog.addReceivableListener(receivableButton);
					dailog.addReceivableListener(receivableLabel);
				}
			});
			receivableButton.setFont(new Font(Font.SERIF, Font.PLAIN, 48));
			receivableButton.setBackground(new Color(240, 240, 240));
			receivableButton.setFocusable(false);
			contentPane.add(receivableButton, BorderLayout.NORTH);
		}

	}

	private void initMainComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
