package org.wcy.demo.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 解析SAX的处理者
 * @author wcyong
 *
 * date    2015年7月23日
 */
public class XmlSAXHandler02 extends DefaultHandler {

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
		System.out.println("uri:"+uri);
		System.out.println("localName:"+localName);
		System.out.println("qName:"+qName);
		if(attributes.getLength() > 0) {
			//根据下标获取属性name和value，也可以直接传递属性name获取属性值：attributes.getValue("id")
			System.out.println("element属性值："+attributes.getQName(0)+":"+attributes.getValue(0));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("------>endElement() is invoke");
		System.out.println("uri:"+uri);
		System.out.println("localName:"+localName);
		System.out.println("qName:"+qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("------>characters() is invoke");
		System.out.println("节点元素文本内容：" + new String(ch, start, length));
	}

}
