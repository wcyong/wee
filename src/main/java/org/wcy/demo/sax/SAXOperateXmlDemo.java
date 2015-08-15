package org.wcy.demo.sax;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.wcy.demo.sax.model.Attribute;
import org.wcy.demo.sax.model.Node;
import org.wcy.demo.sax.model.User;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 使用SAX操作xml的简单例子
 * 
 * @author wcyong
 * 
 *         date 2015年7月23日
 */
public class SAXOperateXmlDemo {
	
	public static List<Node> nodeList = null;
	public static Node node = null;
	
	public static List<User> userList = null;
	public static User user = null;
	

	public static void main(String[] args) {
		SAXOperateXmlDemo demo = new SAXOperateXmlDemo();
		//demo.parseXml01();
		//demo.parseXml02();
		demo.parseXml03();
		//demo.parseXml04();
		//demo.buildXml();
	}

	/**
	 * 1.先由SAXParserFactory这个工厂的实例生产一个SAXParser解析器
	 * 2.根据读取的xml路径，传递给SAXParser这个解析器，再调用parse()方法
	 * 3.在parse()方法中需要传递DefaultHandler这个类的扩展类的实例，因为它才会真正去一步步去解析xml文档的
	 * 4.在DefaultHandler扩展类中需要重写startDocument()，endDocument()等等方法，因为他们方法内部有返回的具体文档的结果
	 */
	public void parseXml01() {
		try {
			// 获取SAX分析器的工厂实例，专门负责创建SAXParser分析器
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 获取SAXParser分析器的实例
			SAXParser parser = factory.newSAXParser();
			// 和其他解析方式一样，也要间接通过InputStream输入流对象获取xml信息
			// 1、直接指定绝对路径获取文件输入流对象
			// InputStream inputStream = new FileInputStream(xmlPath);
			// 2、使用类的相对路径查找xml路径
			InputStream inputStream = this.getClass().getResourceAsStream("/demo/sax/user01.xml");
			// 3、也可以指定路径完成InputStream输入流的实例化操作
			// InputStream inputStream = new FileInputStream(new File(xmlPath));
			// 4、使用InputSource输入源作为参数也可以转换xml
			// InputSource inputSource = new InputSource(inputStream);

			// 解析xml文档
			//这里传递了自定义的XmlSAXHandler()管理者参数来解析xml,不像以前都是直接调用返回的Document对象
			parser.parse(inputStream, new XmlSAXHandler01());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parseXml02() {
		try {
			//获取SAX分析器的工厂实例，专门负责创建SAXParser分析器  
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//获取SAXParser分析器的实例  
			SAXParser parser = factory.newSAXParser();
			InputStream inputStream = this.getClass().getResourceAsStream("/demo/sax/user02.xml");
			
			//解析xml文档  
			parser.parse(inputStream, new XmlSAXHandler02());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void parseXml03() {
		try {
			//获取SAX分析器的工厂实例，专门负责创建SAXParser分析器  
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//获取SAXParser分析器的实例  
			SAXParser parser = factory.newSAXParser();
			InputStream is = this.getClass().getResourceAsStream("/demo/sax/user03.xml");
			
			//解析xml
			parser.parse(is, new XmlSAXHandler03());
			
			//迭代list
			if(SAXOperateXmlDemo.nodeList.size() > 0) {
				for(Node node : SAXOperateXmlDemo.nodeList) {
					System.out.println("--------------------------------");
					System.out.println("【节点】"+node.getName()+"："+node.getText());
					List<Attribute> attributeList = node.getAttributeList();
					if(attributeList != null) {
						for(Attribute attribute : attributeList) {
							System.out.println("【属性】" + attribute.getName() + "：" + attribute.getValue());
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parseXml04() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			InputStream is = this.getClass().getResourceAsStream("/demo/sax/user04.xml");
			
			parser.parse(is, new XmlSAXHandler04());
			
			//迭代list
			if(SAXOperateXmlDemo.userList.size() > 0) {
				for(User user : SAXOperateXmlDemo.userList) {
					System.out.println("-----------------------------------------");  
	                System.out.println("【Id】" + user.getId());  
	                System.out.println("【姓名】" + user.getName());  
	                System.out.println("【年龄】" + user.getAge());  
	                System.out.println("【爱好】" + user.getHobby());  
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成xml文档
	 * 1.创建保存xml的结果流对象StreamResult
	 * 2.然后利用SAXTransformerFactory这个工厂创建TransformerHandler这个操作者
	 * 3.操作这个TransformerHandler获取Transformer，利用Transformer创建节点信息
	 */
	public void buildXml() {
		try {
			//创建保存xml的结果流对象
			Result resultXml = new StreamResult(new FileOutputStream("c:\\user.xml"));
			//获取sax生产工厂对象实例  
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			//获取sax生产处理者对象实例
			TransformerHandler transformerHandler = factory.newTransformerHandler();
			transformerHandler.setResult(resultXml);
			
			//获取sax生产器
			Transformer transformer = transformerHandler.getTransformer();
			//xml的编码格式
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			////换行
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			//开始封装document文档对象，这里和解析一样都是成双成对的构造标签
			transformerHandler.startDocument();
			AttributesImpl attrImpl = new AttributesImpl();
			transformerHandler.startElement("", "", "Users", attrImpl);
			
			attrImpl.addAttribute("", "", "id", "string", "123");
			transformerHandler.startElement("", "", "user", attrImpl);  
			transformerHandler.characters("这个是用户的信息".toCharArray(), 0, "这个是用户的信息".length());  
			transformerHandler.endElement("", "", "user"); 
			
			transformerHandler.endElement("", "", "Users");  
	        //因为没有appendChild等等添加子元素的方法，sax提供的是构造在startElement()和endElement()区间内的标签为包含的节点的父节点  
			transformerHandler.endDocument();  
	          
	        System.out.println("xml文档生成成功！"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
	}

}
