package by.htp.xml.entity;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
	
	private String title;
	private int timesperWeek;
	private List<Shedule> sheduleList= new ArrayList<Shedule>();

	
	public Hobby(String title, int timesperWeek) {
		super();
		this.title = title;
		this.timesperWeek = timesperWeek;
	}

	public Hobby() {
		super();
	}

	public List<Shedule> getSheduleList() {
		return sheduleList;
	}

	public void setSheduleList(List<Shedule> sheduleList) {
		this.sheduleList = sheduleList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTimesperWeek() {
		return timesperWeek;
	}

	public void setTimesperWeek(int timesperWeek) {
		this.timesperWeek = timesperWeek;
	}

	@Override
	public String toString() {
		return "Hobby [title=" + title + ", timesperWeek=" + timesperWeek + ", sheduleList=" + sheduleList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sheduleList == null) ? 0 : sheduleList.hashCode());
		result = prime * result + timesperWeek;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Hobby other = (Hobby) obj;
		if (sheduleList == null) {
			if (other.sheduleList != null)
				return false;
		} else if (!sheduleList.equals(other.sheduleList))
			return false;
		if (timesperWeek != other.timesperWeek)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
