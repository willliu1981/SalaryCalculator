package test.test12;

import java.util.ArrayList;
import java.util.List;

import com.v4.frame.component.IListModelComponent;
import com.v4.frame.component.jframe.DialogFrame;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jpanel.DialogPanelFactory;
import com.v4.model.ListDialogModel;
import com.v4.model.AbsModelCell;
import com.v4.model.DefaultModelCell;
import com.v4.model.Result;

import test.test11.MyResult;

public class Test12Demo {

	public static void main(String[] args) {
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
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

		dialog.setVisible(true);

	}

}
