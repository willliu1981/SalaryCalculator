package com.v5.main.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.v5.model.Wage;

public class XMLRecordDataProcess implements IDataProcess<Wage> {
	private static final String WAGES = "wages";
	private static final String WAGE = "wage";
	private static final String USER = "user";
	private static final String PUNCHES = "punches";
	private static final String PUNCHE = "punche";
	private static final String PUNCHIN = "punch-in";
	private static final String PUNCHOUT = "punch-out";

	@Override
	public void load(String fileUrl, Wage wage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String fileUrl, Wage wage) {
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();

		File file = new File(fileUrl);
		Result result = null;
		try {
			TransformerHandler handler = factory.newTransformerHandler();
			if (!file.exists()) {
				file.getParentFile().mkdirs();
			}

			result = new StreamResult(new FileOutputStream(file));
			handler.setResult(result);
			handler.startDocument();

			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", WAGES, attr);

			attr.clear();
			attr.addAttribute("", "", USER, "", wage.getUser().getName());
			handler.startElement("", "", WAGE, attr);

			if (wage.getPunches().size() > 0) {
				attr.clear();
				handler.startElement("", "", PUNCHES, attr);

				wage.getPunches().stream()
						.sorted((p1,
								p2) -> (int) (p1.getPunchIn().getTime()
										- p2.getPunchIn().getTime()))
						.forEach(x -> {
							attr.clear();
							String timeStr = null;

							try {
								handler.startElement("", "", PUNCHE, attr);

								// punch in
								if (x.getPunchIn() != null) {
									attr.clear();
									handler.startElement("", "", PUNCHIN, attr);
									timeStr = x.getPunchIn().toString();
									handler.characters(timeStr.toCharArray(), 0,
											timeStr.length());
									handler.endElement("", "", PUNCHIN);
								}

								// punch out
								if (x.getPunchOut() != null) {
									attr.clear();
									handler.startElement("", "", PUNCHOUT,
											attr);
									timeStr = x.getPunchOut().toString();
									handler.characters(timeStr.toCharArray(), 0,
											timeStr.length());
									handler.endElement("", "", PUNCHOUT);
								}

								handler.endElement("", "", PUNCHE);
							} catch (SAXException e) {
								e.printStackTrace();
							}
						});

				handler.endElement("", "", PUNCHES);
			}
			handler.endElement("", "", WAGE);
			handler.endElement("", "", WAGES);

			handler.endDocument();

		} catch (TransformerConfigurationException | IOException
				| SAXException e) {
			e.printStackTrace();
		}

	}

}
