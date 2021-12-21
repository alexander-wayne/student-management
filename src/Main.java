import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Student> all_students = new ArrayList<Student>();
	static ArrayList<Class> all_classes= new ArrayList<Class>();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){

		String choice = "";

		while(choice.compareTo("quit") != 0){
			System.out.println("What would you like to do?");
			System.out.println("1. New Student");
			System.out.println("2. New Class");
			System.out.println("3. Add Student to Class");
			System.out.println("4. Modify Student");
			System.out.println("5. Modify Class");
			System.out.println("6. View All Students");
			System.out.println("7. View All Classes");
			System.out.println("8. Quit");

			choice = scanner.nextLine();

			switch(choice){
				case "1":
				case "new student":
					newStudent();
					break;
				case "2":
				case "new class":
					newClass();
					break;
				case "3":
				case "add student to class":
					addStudentToClass();
					break;
				case "4":
				case "modify student":
					modifyStudent();
					break;
				case "5":
				case "modify class":
					modifyClass();
					break;
				case "6":
				case "view all students":
					viewAllStudents();
					break;
				case "7":
				case "view all classes":
					viewAllClasses();
					break;
				case "8":
				case "quit":
					return;
			}

		}
	}

	static void newStudent(){
		System.out.println("Please enter the new student's first name: ");
		String fname = scanner.nextLine();
		System.out.println("Please enter the new student's last name: ");
		String lname = scanner.nextLine();
		Student newStudent = new Student(fname, lname);

		for(Student student : all_students){
			while(student.id.compareTo(newStudent.id) == 0){
				newStudent.newID();
			}
		}

		all_students.add(newStudent);
		System.out.println("Success");
	}

	static void newClass(){
		System.out.println("Please enter the new class's name: ");
		String name = scanner.nextLine();
		Class newClass = new Class(name);

		for(Class _class : all_classes){
			System.out.println(_class.id);
			while(_class.id.compareTo(newClass.id) == 0){
				newClass.newID();
			}
		}

		all_classes.add(newClass);
		System.out.println("Success");
	}
	
	static void addStudentToClass(){
		viewAllStudents();
		System.out.println("Enter the id of the student: ");
		System.out.println("Enter 'Cancel' to Cancel the Operation");
		String studentID = scanner.nextLine();
		if(studentID.compareTo("Cancel") == 0){
			System.out.println("Canceled");
			return;
		}
		viewAllClasses();
		System.out.println("Enter the id of the class: ");
		System.out.println("Enter 'Cancel' to Cancel the Operation");
		String classID = scanner.nextLine();
		if(classID.compareTo("Cancel") == 0){
			System.out.println("Canceled");
			return;
		}
		
		for(int i = 0; i < all_classes.size(); i++){
			if(all_classes.get(i).id.toString().compareTo(classID) == 0){
				for(int j = 0; j < all_students.size(); j++){
					if(all_students.get(j).id.toString().compareTo(studentID) == 0){
						all_classes.get(i).students.add(all_students.get(j));
						all_students.get(j).classes.add(all_classes.get(i));
						System.out.println("Success");
						return;
					}
				}
			}
		}
		
		System.out.println("ERROR: Not Found");
	}

	static void modifyStudent(){
		viewAllStudents();
		System.out.println("Please enter the id of the student you wish to modify: ");
		String id = scanner.nextLine();
		
		for(int i = 0; i < all_students.size(); i++){
			if(all_students.get(i).id.toString().compareTo(id) == 0) {
				System.out.println("What would you like to modify?");
				System.out.println("1: First Name");
				System.out.println("2: Last Name");
				System.out.println("3: Cancel");
				
				String modChoice = scanner.nextLine();
				String newName;
				
				switch (modChoice){
					case "first name":
					case "1":
						System.out.println("Enter the modified name");
						newName = scanner.nextLine();
						all_students.get(i).setFname(newName);
						System.out.println("Success");
						break;
					case "last name":
					case "2":
						System.out.println("Enter the modified name");
						newName = scanner.nextLine();
						all_students.get(i).setLname(newName);
						System.out.println("Success");
						break;
					case "3":
					case "cancel":
						System.out.println("Canceled");
						break;
					default:
						System.out.println("Invalid Choice");
						break;
				}
				
				return;
			}
		}
		
		System.out.println("ERROR: Student not found");
		return;
	}
	
	static void modifyClass(){
		viewAllClasses();
		System.out.println("Please enter the id of the class you wish to modify: ");
		String id = scanner.nextLine();
		
		for(int i = 0; i < all_classes.size(); i++){
			if(all_classes.get(i).id.toString().compareTo(id) == 0) {
				
				System.out.println("What is the new name of the class?");
				
				String nameChoice = scanner.nextLine();
				String newName;
				
				if(nameChoice.compareTo("cancel") == 0){
					System.out.println("Canceled");
					return;
				}
				
				System.out.println("Enter the modified name");
				newName = scanner.nextLine();
				all_classes.get(i).setName(newName);
				System.out.println("Success");
				return;
			}
		}
		
		System.out.println("ERROR: Class not found");
		return;
	}

	static void viewAllStudents(){
		for(Student student : all_students){
			student.print();
		}
	}

	static void viewAllClasses(){
		System.out.println(all_classes.size());
		for(Class _class : all_classes){
			_class.print();
		}
	}

}
