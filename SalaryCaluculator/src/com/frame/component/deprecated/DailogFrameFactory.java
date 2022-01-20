package com.frame.component.deprecated;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.IFrame;
import com.frame.component.PanelFactory;
import com.frame.component.dailog.DialogPanel;
import com.frame.component.receiver.IReceivable;
import com.frame.component.xcomponent.ReceivableListener;

public class DailogFrameFactory extends JFrame
		implements IFrame, WindowListener, IReceivable {

	private DialogPanel content;
	private JPanel contentPane;
	private ReceivableListener listener;
	private List<ReceivableListener> listeners = new ArrayList<>();

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

	public void setListener(ReceivableListener listener) {
		this.listener = listener;
	}

	private void setContentPanel(String name) {
		contentPane.removeAll();
		contentPane.add(
				content = (DialogPanel) PanelFactory.getPanel(name, this),
				BorderLayout.CENTER);
	}

	public static DailogFrameFactory getFrameInstance(String name) {
		DailogFrameFactory frame = new DailogFrameFactory();
		frame.setContentPanel(name);
		frame.setVisible(true);
		frame.addWindowListener(frame);
		return frame;
	}

	@Override
	public void dispose() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		update();
	}

	@Override
	public void windowClosed(WindowEvent e) {
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

	@Override
	public void addReceivableListener(ReceivableListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void update() {
		listeners.forEach(x -> x.update(content.getResult()));
	}

}
