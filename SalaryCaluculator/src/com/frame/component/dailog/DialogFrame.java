package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.PanelFactory;
import com.frame.component.receiver.IReceivable;
import com.frame.component.receiver.IResponse;
import com.frame.component.xcomponent.ReceivableListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogFrame extends JDialog
		implements IDailog, IReceivable, IResponse {

	private final JPanel baseContentPanel = new JPanel();
	private final List<ReceivableListener> receivableListeners = new ArrayList<>();
	private Object result;

	/**
	 * Create the dialog.
	 */
	public DialogFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		baseContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(baseContentPanel, BorderLayout.CENTER);
		baseContentPanel.setLayout(new BorderLayout(0, 0));
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
				okButton.setFont(new Font("新細明體", Font.PLAIN, 30));
				okButton.setBackground(SystemColor.controlHighlight);
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

				cancelButton.setFont(new Font("新細明體", Font.PLAIN, 30));
				cancelButton.setBackground(SystemColor.controlHighlight);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void setContentPanel(String compName) {
		baseContentPanel.removeAll();
		baseContentPanel.add(PanelFactory.getPanel(compName, this),
				BorderLayout.CENTER);
	}

	@Override
	public void addReceivableListener(ReceivableListener listener) {
		this.receivableListeners.add(listener);
	}

	@Override
	public void update() {
		receivableListeners.forEach(x -> x.update(this.getResult()));
	}

	@Override
	public Object getResult() {
		return this.result;
	}

	@Override
	public void setResult(Object o) {
		this.result = o;
	}

	@Override
	public void dispatch() {
		// TODO Auto-generated method stub

	}

}
