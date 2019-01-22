package by.htp.xml.parser.stax;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Hobby;
import by.htp.xml.entity.Mother;
import by.htp.xml.entity.Shedule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXFamilyParser {

	public static void main(String[] args) throws FileNotFoundException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("resources/family.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Family> familyList = process(reader);
			
			for(Family family: familyList) {
				System.out.println(family);
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}		
	}

	private static List<Family> process(XMLStreamReader reader) throws XMLStreamException {
		List<Family> familyList = new ArrayList<Family>();
		
		Family family = null;
		Mother mother = null;
		Father father = null;
		Child child = null;
		Hobby hobby = null;
		Shedule shedule = null;
		ParserEnum element = null;
		StringBuilder currentParent = new StringBuilder();
		
		while(reader.hasNext()) {
			int type = reader.next();
			
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				element = ParserEnum.getElementTagName(reader.getLocalName());
				switch (element) {
				case FAMILY:
					family = new Family();
					String adress = reader.getAttributeValue(null, "adress");
					family.setAdress(adress);
					break;
				case MOTHER:
					mother = new Mother();
					currentParent.replace(0, currentParent.length(), "mother");
					break;
				case FATHER:
					father = new Father();
					currentParent.replace(0, currentParent.length(), "father");
					break;
				case CHILD:
					child = new Child();
					currentParent.replace(0, currentParent.length(), "child");
					break;
				case HOBBY:
					hobby = new Hobby();
					break;
				case SHEDULE:
					shedule = new Shedule();
					currentParent.replace(0, currentParent.length(), "shedule");
					break;
				default:
					break;
				}
				break;
				
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if(text.isEmpty()) {
					break;
				}
				switch(element) {
				case NAME:
					if(currentParent.toString().equals("mother")) {
						mother.setName(text);
					} else if (currentParent.toString().equals("father")) {
						father.setName(text);
					} else if (currentParent.toString().equals("child")) {
						child.setName(text);
					}
					break;
				case MAIDEN_NAME:
					if(currentParent.toString().equals("mother")) {
						mother.setMaideName(text);
					}
					break;
				case SURNAME:
					if(currentParent.toString().equals("mother")) {
						mother.setSurName(text);
					} else if (currentParent.toString().equals("father")) {
						father.setSurName(text);
					} else if (currentParent.toString().equals("child")) {
						child.setSurName(text);
					}
					break;
				case AGE:
					if(currentParent.toString().equals("mother")) {
						mother.setAge(Integer.parseInt(text));
					} else if (currentParent.toString().equals("father")) {
						father.setAge(Integer.parseInt(text));
					} else if (currentParent.toString().equals("child")) {
						child.setAge(Integer.parseInt(text));
					}
					break;
				case GENDER:
					if(currentParent.toString().equals("child")) {
						child.setGender(text);
					}
					break;
				case TITLE:
					hobby.setTitle(text);
					break;
				case TIMESPER_WEEK:
					hobby.setTimesperWeek(Integer.parseInt(text));;
					break;
				case DAY:
					if(shedule.getDay() == null) {
						shedule.setDay(text);
					} else {
						hobby.getSheduleList().add(shedule);
						shedule = new Shedule();
						shedule.setDay(text);
					}					
					break;
				case TIME:
					if(shedule.getTime() == null) {
						shedule.setTime(text);
					}
					break;
				default:
					break;
				}
				break;
			
			case XMLStreamConstants.END_ELEMENT:
				element = ParserEnum.getElementTagName(reader.getLocalName());
				switch (element) {
				case FAMILY:
					familyList.add(family);
					break;
				case MOTHER:
					family.setMother(mother);
					break;
				case FATHER:
					family.setFather(father);
					break;
				case CHILD:
					family.getChildren().add(child);
					break;
				case HOBBY:
					mother.setHobby(hobby);
					break;
				case SHEDULE:
					hobby.getSheduleList().add(shedule);
				default:
					break;
				}				
				break;
			}
		}
		
		return familyList;
	}

}
