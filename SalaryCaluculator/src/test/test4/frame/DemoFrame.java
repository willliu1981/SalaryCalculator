package test.test4.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test.test4.xcomponent.ReceivableListener;

public class DemoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DemoFrame() {
		initMainComponent();
		contentPane.setLayout(new BorderLayout(0, 0));
		{
			JLabel receivableLabel = new JLabel("內容");
			receivableLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 48));
			contentPane.add(receivableLabel, BorderLayout.CENTER);

			JButton receivableButton = new JButton("月份");
			;
			receivableButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DateDailog dailog = new DateDailog();
					dailog.addReceivableListener(new ReceivableListener() {
						@Override
						public void update(Object o) {
							receivableButton.setText( (String) o);
							receivableLabel.setText("月份:" + (String) o);
						}
					});
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
