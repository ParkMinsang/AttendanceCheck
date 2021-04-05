package model;

public class StudentDTO implements Comparable<StudentDTO>{
	String location, name;
	int ban;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	@Override
	public String toString() {
		return "StudentDTO [location=" + location + ", name=" + name + ", ban=" + ban + "]";
	}
	@Override
	public int compareTo(StudentDTO o) {
		return Integer.compare(this.ban, o.ban);
	}
}
