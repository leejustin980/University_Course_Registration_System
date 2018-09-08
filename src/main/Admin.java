package main;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Admin extends User implements AdminInterface, java.io.Serializable{
	// Create a Scanner
	transient Scanner input = new Scanner(System.in);
	
	// data fields
	String username;
	String password;
	String fname;
	String lname;
	
	// default constructor
	public Admin() {
		
	}
	
	//constructor
	public Admin(String fname, String lname, String username, String password) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	// Course Management Methods
	
	// create a new course
	@Override
	public void createCourse(ArrayList<Course> courseList) {
		// name
		System.out.println("New Course Name: ");
		String courseName = input.nextLine();
		
		// id
		System.out.println("New Course ID: ");
		String courseID = input.nextLine();
		
		// max
		// setting max to default 3
		System.out.println("New Course Max: ");
		int courseMax = input.nextInt();
		input.nextLine();
		
		// instructor
		System.out.println("New Course Instructor Name: ");
		String courseInstructor = input.nextLine();
		
		// number
		System.out.println("New Course Number: ");
		int courseNum = input.nextInt();
		input.nextLine();
		
		// location
		System.out.println("New Course Location: ");
		String courseLocation = input.nextLine();
		
		// add it
		Course newCourse = new Course(courseName, courseID,
									courseMax, courseInstructor,
									courseNum,courseLocation);
		// set new course current # of students to 0
		newCourse.setCourseCurrent(0);
		courseList.add(newCourse);
		System.out.println("Course Added!");
	}

	// Delete a Course
	@Override
	public void deleteCourse(ArrayList<Course> courseList, ArrayList<User> userList) {
		// get course ID you want to delete
		System.out.println("What is the course ID? ");
		String deleteID = input.nextLine();
		
		// remove from courseList
		for (int i=0;i<courseList.size();i++) {
			if (courseList.get(i).getCourseID().equals(deleteID)) {
				courseList.remove(courseList.get(i));
				System.out.println("Course removed!");
			}
		}
		
	}
	
	// edit menu
	public void editMenu() {
		System.out.println("Edit Menu");
		System.out.println("1. Edit course name");
		System.out.println("2. Edit course ID");
		System.out.println("3. Edit course instructor name");
	}
			
	// edit course
	@Override
	public void editCourse(ArrayList<Course> courseList) {
		// get which course to edit
		System.out.println("Enter the ID of the course you want to edit: ");
		String editID = input.nextLine();
		
		// display edit menu
		editMenu();
		int editAns = input.nextInt();
		input.nextLine();
		
		// iterate through to find the right course
		for (int i=0;i<courseList.size();i++) {
			if (courseList.get(i).getCourseID().equals(editID)) {
				if (editAns == 1) {
					System.out.println("Enter new course name: ");
					courseList.get(i).setCourseName(input.nextLine());
				} else if (editAns == 2) {
					System.out.println("Enter new course ID: ");
					courseList.get(i).setCourseID(input.nextLine());
				} else if (editAns == 3) {
					System.out.println("Enter new course instructor name: ");
					courseList.get(i).setCourseInstructor(input.nextLine());
				}
			}
		}
		
	}

	@Override
	public void displayCourseInfo(ArrayList<Course> courseList) {
		System.out.println("Please enter the course id of the class you want to view:");
		String courseID = input.nextLine();
		for (Course course : courseList) {
			if (courseID.equals(course.getCourseID())) {
				System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n", 
						"Course name","Course ID", "Maximum # of Students", "Current # of Students",
						"Course Instructor", "Section number","Course location");
				System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n",
						course.getCourseName(), course.getCourseID(),
						course.getCourseMax(), course.getCourseCurrent(),
						course.getCourseInstructor(), course.getCourseNumber(),
						course.getCourseLocation());
				ArrayList<Student> studentList = course.getStudentList();
				System.out.printf("%-40.40s%n", "Students");
				for (Student student : studentList) {
					System.out.printf("%-40.40s%n",student.getFname() + " " + student.getLname());
				}
			}
		}
	}
	
	@Override
	public void registerStudent(ArrayList<User>userList) {
		// add a student to the userlist
		// get first name
		System.out.println("What is the student's first name? ");
		String fname = input.nextLine();
		
		// get last name
		System.out.println("What is the student's last name? ");
		String lname = input.nextLine();
		
		// get username
		System.out.println("What is the student's username? ");
		String username = input.nextLine();
		
		// get password
		System.out.println("What is the student's password? ");
		String password = input.nextLine();
		
		// make a new student
		Student newStudent = new Student(fname, lname, username, password);
		userList.add(newStudent);
		System.out.println("Student Added!");
		
	}
	
	// Admin Reports
	// View All Courses
	@Override
	public void viewAllCourses(ArrayList<Course> courseList) {
		System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n", 
				"Course Name","Course ID", "Maximum Students", "Current Students",
				"Course Instructor", "Course Number","Course Location");
		for (Course course : courseList) {
			System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n",
					course.getCourseName(), course.getCourseID(),
					course.getCourseMax(), course.getCourseCurrent(),
					course.getCourseInstructor(), course.getCourseNumber(), course.getCourseLocation());
		}
	}
	
	// View Full Courses
	@Override
	public void viewFullCourses(ArrayList<Course> courseList) {
		System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n", 
				"Course Name","Course ID", "Maximum Students", "Current Students",
				"Course Instructor", "Course Number","Course Location");
		for (Course course : courseList) {
			// check if full
			if (course.getCourseCurrent() == course.getCourseMax()) {
				System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n",
					course.getCourseName(), course.getCourseID(),
					course.getCourseMax(), course.getCourseCurrent(),
					course.getCourseInstructor(), course.getCourseNumber(),
					course.getCourseLocation());
			}
		}
	}
	
	// Write to File
	@Override
	public void writeFile(ArrayList<Course> courseList) {
		String fileName = "CoursesFull.txt";
		try {
			FileWriter fileWriter = new FileWriter("src/CoursesFull.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (Course course : courseList) {
				if (course.getCourseCurrent() == course.getCourseMax()) {
					bufferedWriter.write(course.getCourseName() + "\t" + course.getCourseID() + "\t" + 
						course.getCourseInstructor() + "\t" + course.getCourseNumber() + 
						"\t" + course.getCourseLocation() + "\n");
				}
			}
			System.out.println("Written to CoursesFull.txt");
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.out.println(
	                "Error writing to file '"
	                + fileName + "'");
		}
	}
	
	// View Students in a course
	@Override
	public void viewStudents(ArrayList<Course> courseList, ArrayList<User> userList) {
		System.out.println("Enter Course ID: ");
		String courseID = input.nextLine();
		for (Course course : courseList) {
			if (course.getCourseID().equals(courseID)) {
				System.out.println("Listing students for " + course.getCourseName() + ":");
				for (Student student : course.getStudentList()) {
					System.out.println(student.getFname() + " " + student.getLname());
				}
			}
		}
	}

	// view student courses
	@Override
	public void viewStudentCourses(ArrayList<User> userList) {
		System.out.println("Enter Student First Name: ");
		String fname = input.nextLine();
		System.out.println("Enter Student Last Name: ");
		String lname = input.nextLine();
		
		System.out.println("List of Course Names: ");
		for (User user : userList) {
			if (user instanceof Student) {
				if ((((Student) user).getFname()).equals(fname)
						&& ((((Student) user).getLname()).equals(lname))) {
					ArrayList<Course> studentCourseList = ((Student) user).getCourseList();
					for (Course course : studentCourseList) {
						System.out.println(course.getCourseName());
					}
				}
			}
		}
	}
	
	// sort method - sorts Courses by how many students are enrolled low to high
	@Override
	public void sortCourses(ArrayList<Course> courseList, int low, int high) {
		if (low < high) {
			int minIndex = low;
			Course min = courseList.get(low);
			for (int i=low+1;i<=high;i++) {
				if (courseList.get(i).compareTo(min) == -1) {
					min = courseList.get(i);
					minIndex = i;
				}
			}
			courseList.set(minIndex, courseList.get(low));
			courseList.set(low, min);
			// call the method again
			sortCourses(courseList, low + 1, high);
		}
	}
}

