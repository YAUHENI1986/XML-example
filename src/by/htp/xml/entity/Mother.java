package by.htp.xml.entity;

public class Mother {
	
	private String name;
	private String surName;
	private String maideName;
	private int age;
	private Hobby hobby;
	
	public Mother(String name, String surName, String maideName, int age) {
		super();
		this.name = name;
		this.surName = surName;
		this.maideName = maideName;
		this.age = age;
	}

	public Mother() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMaideName() {
		return maideName;
	}

	public void setMaideName(String maideName) {
		this.maideName = maideName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		String thisReturn = null;
		if(hobby!=null) {
			thisReturn = "Mother [name=" + name + ", surName=" + surName + ", maideName=" + maideName + ", age=" + age
					+ ", hobby=" + hobby + "]";
		} else {
			thisReturn = "Mother [name=" + name + ", surName=" + surName + ", maideName=" + maideName + ", age=" + age
					+ "]";
		}
		
		return thisReturn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + ((maideName == null) ? 0 : maideName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Mother other = (Mother) obj;
		if (age != other.age)
			return false;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (maideName == null) {
			if (other.maideName != null)
				return false;
		} else if (!maideName.equals(other.maideName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}
	
}
