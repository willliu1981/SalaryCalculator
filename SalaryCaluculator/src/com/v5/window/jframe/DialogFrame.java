package com.v5.window.jframe;

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

import com.v5.dispatcher.Dispatchable;
import com.v5.dispatcher.Dispatcher;
import com.v5.dispatcher.model.Result;
import com.v5.exception.FindErrorException;
import com.v5.frame.component.jpanel.factory.DialogPanelFactory;
import com.v5.window.factory.IDialog;
import com.v5.window.interfaces.IHasContentComponent;
import com.v5.window.jpanel.factory.IPanelFactory;
import com.v5.xml.XMLFactory;


/*
 * 自定 Dialog 的共同窗口
 * 藉由設定 Panel 取得自定義的視窗
 */
public class DialogFrame extends JDialog
		implements IDialog, IHasContentComponent {

	private final JPanel baseContentPanel = new JPanel();
	private final List<Dispatcher<Result>> dispatchers = new ArrayList<>();
	private Result dispatchResult = null;
	private JPanel contentPanel = null;

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
	public void setContentComponent(String compName, IPanelFactory factory) {
		baseContentPanel.removeAll();
		if (factory instanceof DialogPanelFactory) {
			contentPanel = (JPanel)   XMLFactory .getXMLClassInstance(compName);
		} else {
			if (contentPanel == null) {
				throw new FindErrorException(
						"沒找到 " + compName + " ,因此無法加入 Panel");
			}
		}
		baseContentPanel.add(contentPanel, BorderLayout.CENTER);
		Dispatchable dispatchable = (Dispatchable) contentPanel;
		dispatchable.addDispatcher(new Dispatcher<Result>() {

			@Override
			public void receive(Object o) {
				// TODO Auto-generated method stub

			}

			@Override
			public void receive(Result result) {
				dispatchResult = result;
			}

		});
	}

	@Override
	public void addDispatcher(Dispatcher<Result> dispatcher) {
		this.dispatchers.add(dispatcher);
	}

	@Override
	public List<Dispatcher<Result>> getDispatchers() {
		return this.dispatchers;
	}

	@Override
	public JPanel getContentComponent() {
		// TODO Auto-generated method stub
		return this.contentPanel;
	}

}
