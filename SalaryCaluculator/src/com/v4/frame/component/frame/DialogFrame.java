package com.v4.frame.component.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.xcomponent.DialogPanelFactory;
import com.frame.component.xcomponent.Dispatchable;
import com.frame.component.xcomponent.Dispatcher;
import com.frame.component.xcomponent.IDialog;
import com.v4.exception.FindErrorException;
import com.v4.frame.component.panel.IPanelFactory;

/*
 * 自定 Dialog 的共同窗口
 */
public class DialogFrame extends JDialog implements IDialog {

	private final JPanel baseContentPanel = new JPanel();
	private final List<Dispatcher> dispatchers = new ArrayList<>();
	private Object dispatchResult = null;

	/**
	 * Create the dialog.
	 */
	public DialogFrame() {
		setBounds(100, 100, 900, 450);
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
						updateDispatcher(dispatchResult);
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
	public void setContentComponent(String compName,IPanelFactory factory) {
		baseContentPanel.removeAll();
		JPanel panel = factory.getPanel(compName, this);
		if (panel == null) {
			throw new FindErrorException("沒找到 " + compName + " ,因此無法加入 Panel");
		}
		baseContentPanel.add(panel, BorderLayout.CENTER);
		Dispatchable dispatchable = (Dispatchable) panel;
		dispatchable.addDispatcher(new Dispatcher() {
			@Override
			public void receive(Object o) {
				dispatchResult = o;
			}
		});
	}

	@Override
	public void addDispatcher(Dispatcher dispatcher) {
		this.dispatchers.add(dispatcher);
	}

	@Override
	public List<Dispatcher> getDispatchers() {
		return this.dispatchers;
	}

}
