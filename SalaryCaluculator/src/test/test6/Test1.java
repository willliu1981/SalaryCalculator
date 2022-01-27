package test.test6;

import com.frame.setting.Setting;
import com.v4.frame.component.frame.DialogFactory;
import com.v4.frame.component.frame.FrameGenerator;

public class Test1 {

	public static void main(String[] args) {
		Setting.initialize();
		FrameGenerator.getFrame(DialogFactory.MONTHDIALOG, null);
	}

}
