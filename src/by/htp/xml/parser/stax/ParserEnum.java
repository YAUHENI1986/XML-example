package by.htp.xml.parser.stax;

public enum ParserEnum {
	FAMILIES, FAMILY, MOTHER, FATHER, CHILDREN, CHILD, NAME, SURNAME, MAIDEN_NAME, AGE, GENDER,
	HOBBY, TITLE, TIMESPER_WEEK, SHEDULE, DAY, TIME,
	ADRESS;
	
	public static ParserEnum getElementTagName(String element) {
		switch (element) {		
		case "families":
			return FAMILIES;
		case "family":
			return FAMILY;
		case "mother":
			return MOTHER;	
		case "father":
			return FATHER;	
		case "children":
			return CHILDREN;	
		case "child":
			return CHILD;	
		case "name":
			return NAME;	
		case "surname":
			return SURNAME;
		case "maiden-name":
			return MAIDEN_NAME;	
		case "age":
			return AGE;	
		case "gender":
			return GENDER;
		case "hobby":
			return HOBBY;
		case "title":
			return TITLE;
		case "timesper-week":
			return TIMESPER_WEEK;
		case "shedule":
			return SHEDULE;
		case "time":
			return TIME;
		case "day":
			return DAY;	
		case "adress":
			return ADRESS;
		default:
			throw new EnumConstantNotPresentException(ParserEnum.class, element);
		}		
	}	
	}
