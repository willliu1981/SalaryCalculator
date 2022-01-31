package test.test12;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.v4.frame.component.IListModelComponent;
import com.v4.frame.component.jframe.DialogFrame;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jframe.JFrameFactory;
import com.v4.frame.component.jpanel.DialogPanelFactory;
import com.v4.frame.component.jpanel.JFramePanelFactory;
import com.v4.listener.Dispatcher;
import com.v4.model.DefaultModelCell;
import com.v4.model.ListDialogModel;
import com.v4.model.ListDialogResult;
import com.v4.model.Result;

public class Test12Demo {

	public static void main(String[] args) {
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
		FrameAndDialogGenerator.setFactory(new JFrameFactory());
		DialogFrame dialog = (DialogFrame) FrameAndDialogGenerator.getFrame(
				DialogFrameFactory.LISTDIALOG, new DialogPanelFactory());

		IListModelComponent<ListDialogModel> dia = (IListModelComponent<ListDialogModel>) dialog
				.getContentComponent();
		ListDialogModel<DefaultModelCell> model = new ListDialogModel<>();
		DefaultModelCell cell1 = new DefaultModelCell("A");
		DefaultModelCell cell2 = new DefaultModelCell("B");
		DefaultModelCell cell3 = new DefaultModelCell("C");
		model.addElement(cell1);
		model.addElement(cell2);
		model.addElement(cell3);
		dia.setModel(model);
		dialog.addDispatcher(new Dispatcher() {

			@Override
			public void receive(Object o) {
				// TODO Auto-generated method stub

			}

			@Override
			public void receive(Result result) {
				ListDialogResult r = (ListDialogResult) result;
				DefaultModelCell cell = (DefaultModelCell) r.get();
				System.out.println(cell.getName());
			}

		});

		JFrame f = (JFrame) FrameAndDialogGenerator
				.getFrame(JFrameFactory.TESTJFRAME, new JFramePanelFactory());
		JButton b = new JButton("test");
		f.getContentPane().add(b);
		b.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				dialog.setVisible(true);

			}
		});

		f.setVisible(true);
	}

}
