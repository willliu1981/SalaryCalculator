package test.test12;

import com.v4.frame.component.IListModelComponent;
import com.v4.frame.component.jframe.DialogFrame;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jpanel.DialogPanelFactory;
import com.v4.model.ListDialogModel;
import com.v4.model.ModelCell;

public class Test12Demo {

	public static void main(String[] args) {
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
		DialogFrame dialog = (DialogFrame) FrameAndDialogGenerator.getFrame(
				DialogFrameFactory.LISTDIALOG, new DialogPanelFactory());

		IListModelComponent<ListDialogModel> dia = (IListModelComponent<ListDialogModel>) dialog
				.getContentComponent();
		ListDialogModel model = new ListDialogModel();
		ModelCell cell1 = new ModelCell("A");
		ModelCell cell2 = new ModelCell("B");
		ModelCell cell3 = new ModelCell("C");
		model.addElement(cell1);
		model.addElement(cell2);
		model.addElement(cell3);
		dia.setModel(model);

		dialog.setVisible(true);
	}

}
