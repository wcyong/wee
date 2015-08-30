package org.wcy.wee.demo.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 解析SAX的处理者
 * @author wcyong
 *
 * date    2015年7月23日
 */
public class XmlSAXHandler01 extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("------>startDocument() is invoke");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("------>endDocument() is invoke");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("------>startElement() is invoke");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("------>endElement() is invoke");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("------>characters() is invoke");
	}

}
