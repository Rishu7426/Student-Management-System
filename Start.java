
import java.io.*;

import com.student.manage.Student;
import com.student.manage.StudentDB;
public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App :");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to Display student");
			System.out.println("PRESS 4 to Update student");
			System.out.println("PRESS 5 to Exit App");
			
			int c= Integer.parseInt(br.readLine());
			
			
			if(c==1) {
				//add student
				System.out.println("Enter user name :");
				String name= br.readLine();
				
				System.out.println("Enter user phone :");
				String phone= br.readLine();
				
				System.out.println("Enter user city :");
				String city= br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDB.insertStudentToDB(st);
				if(answer==true) {
					System.out.println("Student is added successfully...");
				}else {
					System.out.println("Something went wrong.....Try Again!");
				}
				System.out.println(st);
				
			}else if(c==2) {
				//delete student
				System.out.println("Enter user id :");
				int userId= Integer.parseInt(br.readLine());
				boolean ans= StudentDB.deleteStudent(userId);
				if(ans==true) {
					System.out.println(userId+ " Id Deleted..");
				}else {
					System.out.println("Something went wrong.....Try Again!");
				}
			}else if(c==3) {
				//display student
				StudentDB.showAllStudent();
				
			}else if(c==4) {
				//update student
				System.out.println("Enter student id");
				int id = Integer.parseInt(br.readLine());

                System.out.println("Enter new Name (or press Enter to keep current):");
                String name = br.readLine();

                System.out.println("Enter new Phone (or press Enter to keep current):");
                String phone = br.readLine();

                System.out.println("Enter new City (or press Enter to keep current):");
                String city = br.readLine();

                boolean updated = StudentDB.updateStudent(id, name, phone, city);
                if (updated) {
                    System.out.println("Student record updated successfully!");
                } else {
                    System.out.println("Something went wrong, please try again.");
                }
				
			}else if(c==5){
				//exit app
				break;
			}
		}
		System.out.println("Thankyou for using my Application.......");
		System.out.println("program Existed...");
	}

}
