package p3_student_management_system;

import java.util.Scanner;

public class StudentDatabaseApplication {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("How many students will be added to the database?");
		int students = stdin.nextInt();
		
		Student[] studentList = new Student[students];
		
		for(int i = 0; i < students; i++) {
			studentList[i] = new Student();
			studentList[i].enroll();
			studentList[i].payTuition();
		}	
		
		for(int j = 0; j < students; j++) {
			studentList[j].printOut();
		}
		
		
		stdin.close();

	}

}
