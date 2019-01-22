package by.htp.xml.entity;

import java.util.ArrayList;
import java.util.List;

public class Family {
	
	private String adress;
	private Mother mother;
	private Father father;
	private List<Child> children = new ArrayList<Child>();
	
	public Family(String adress, Mother mother, Father father) {
		super();
		this.adress = adress;
		this.mother = mother;
		this.father = father;
	}
	
	public Family() {
		super();
	}
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Mother getMother() {
		return mother;
	}
	public void setMother(Mother mother) {
		this.mother = mother;
	}
	public Father getFather() {
		return father;
	}
	public void setFather(Father father) {
		this.father = father;
	}	

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> childrenList) {
		this.children = childrenList;
	}

	@Override
	public String toString() {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("Family [");
		System.out.println("adress=" + adress);
		System.out.println("mother=" + mother);
		System.out.println("father=" + father);
		System.out.println("children=" + children);
		System.out.println("]");		
		return "------------------------------------------------------------------------------------------------------";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Family other = (Family) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.equals(other.mother))
			return false;
		return true;
	}
	
}
