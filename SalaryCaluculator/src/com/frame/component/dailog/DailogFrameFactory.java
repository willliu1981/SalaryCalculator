package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.IFrame;
import com.frame.component.PanelFactory;
import com.frame.component.xcomponent.XListener;
import com.frame.component.xcomponent.XPanel;

public class DailogFrameFactory extends JFrame
		implements IFrame, WindowListener {
	private static DailogFrameFactory thisFrame = new DailogFrameFactory();

	private JPanel contentPane;
	private XListener listener;

	/**
	 * Create the frame.
	 */
	private DailogFrameFactory() {
		initialize();
	}

	public void initialize() {
		IFrame.super.initialize();
	}

	public void initMainComponent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1019, 523);
		this.setTitle("Dailog");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	public void setListener(XListener listener) {
		this.listener = listener;
	}

	private void setContentPanel(String name) {
		contentPane.removeAll();
		contentPane.add(PanelFactory.getPanel(name, this), BorderLayout.CENTER);
	}

	public static DailogFrameFactory getFrameInstance(String name) {
		thisFrame.setContentPanel(name);
		thisFrame.setVisible(true);
		return thisFrame;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("dailot f factory  open**");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		XPanel panel = (XPanel) contentPane.getComponent(0);
		this.listener.update(panel.getReslut());
		System.out.println("dailot f factory **" + panel.getReslut());
	}

	@Override
	public void windowClosed(WindowEvent e) {
		XPanel panel = (XPanel) contentPane.getComponent(0);
		this.listener.update(panel.getReslut());
		System.out.println("dailot f factory closed**" + panel.getReslut());

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
