import java.util.ArrayList;
import java.util.UUID;

public class Class {
	
	UUID id;
	String name;
	ArrayList<Student> students;
	
	Class(){}

	Class(String name){
		this.id = UUID.randomUUID();
		this.name = name;
		this.students = new ArrayList<Student>();
	}

	public UUID newID(){
		id = UUID.randomUUID();
		return id;
	}

	public void print(){
		System.out.println("ID: " + id.toString());
		System.out.println("Name: " + name);
		System.out.println("Students: ");
		for(Student student : students) {
			System.out.println(student.getId());
			System.out.println(student.getFname() + " " + student.getLname());
		}
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

}
