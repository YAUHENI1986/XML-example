package by.htp.xml.parser.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FamilyDomParser {
	
	private static final String XML_FILE_PATH = "resources/family.xml";	

	public static void main(String[] args) {		
		readCatalog();
	}	
	
	public static void readCatalog() {		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(XML_FILE_PATH);
			
			parseDocumentSecond(document);
			
		} catch (ParserConfigurationException | SAXException |IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static void parseDocumentSecond(Document document){		
		Element root = document.getDocumentElement();
		NodeList nodes = root.getElementsByTagName("family");
		
		for(int i = 0; i<nodes.getLength(); i++) {
			Element current = (Element)nodes.item(i);
			String name = current.getNodeName();
			System.out.println(name);
			String adress = current.getAttribute("adress");
			System.out.println(adress);			
			
			Element mother = getSingleChild(current, "mother");
			System.out.println(mother.getNodeName());
			NodeList list = mother.getChildNodes();
			for(int g = 0; g<list.getLength(); g++) {
				String text = list.item(g).getTextContent().trim();
				System.out.println(text);
			}
			
			Element father = getSingleChild(current, "father");
			System.out.println(father.getNodeName());
			list = father.getChildNodes();
			for(int g = 0; g<list.getLength(); g++) {
				String text = list.item(g).getTextContent().trim();
				System.out.println(text);
			}
			
			Element children = getSingleChild(current, "children");
			System.out.println(children.getNodeName());
			list = children.getChildNodes();
			for(int g = 0; g<list.getLength(); g++) {
				String text = list.item(g).getTextContent().trim();
				System.out.println(text);
			}
		}		
	}
	
	private static Element getSingleChild(Element element, String childName) {
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element)nList.item(0);
		return child;		
	}
	
}
