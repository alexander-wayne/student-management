import java.util.ArrayList;
import java.util.UUID;

public class Student {

	UUID id;
	String fname;
	String lname;
	ArrayList<Class> classes;

	Student(){}

	Student(String fname, String lname){
		this.id = UUID.randomUUID();
		this.fname = fname;
		this.lname = lname;
		this.classes = new ArrayList<Class>();
	}

	public UUID newID(){
		id = UUID.randomUUID();
		return id;
	}

	public void print(){
		System.out.println("ID: " + id.toString());
		System.out.println("Name: " + fname + " " + lname);
		System.out.println("Classes: ");
		for(Class _class : classes) {
			System.out.println(_class.getId());
			System.out.println(_class.getName());
		}
	}

	public UUID getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public ArrayList<Class> getClasses() {
		return classes;
	}
}
