package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements StudentInterface,java.io.Serializable{
	// Scanner
	transient Scanner input = new Scanner(System.in);
	
	// arraylist
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	// default constructor
	public Student(){
		
	}
	
	// constructor
	public Student(String fname, String lname,
					String username, String password) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}
	
	// fname and lname constructor
	public Student(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// Methods
	// View all Courses
	@Override
	public void viewAllCourses(ArrayList<Course>courseList) {
		System.out.println("List of All Courses: ");
		System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n", 
				"Course Name","Course ID", "Maximum Students", "Current Students",
				"Course Instructor", "Course Number","Course Location");
		for (Course course : courseList) {
			System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n",
					course.getCourseName(), course.getCourseID(),
					course.getCourseMax(), course.getCourseCurrent(),
					course.getCourseInstructor(), course.getCourseNumber(), 
					course.getCourseLocation());
		}
	}
	
	// View Not Full Courses
	@Override
	public void viewNotFullCourses(ArrayList<Course> courseList) {
		System.out.println("Available Courses:");
		System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n", 
				"Course Name","Course ID", "Maximum Students", "Current Students",
				"Course Instructor", "Course Number","Course Location");
		for (Course course : courseList) {
			if (course.getCourseCurrent() < course.getCourseMax()) {
				System.out.printf("%-40.40s  %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s %-40.40s%n",
						course.getCourseName(), course.getCourseID(),
						course.getCourseMax(), course.getCourseCurrent(),
						course.getCourseInstructor(), course.getCourseNumber(), 
						course.getCourseLocation());
				
			}
		}
		
	}
	
	// Register for a Course
	@Override
	public void registerCourse(ArrayList<Course> courseList) {
		// Create Scanner
		Scanner input = new Scanner(System.in);
		
		// get course info
		System.out.println("Enter Course Name: ");
		String courseName = input.nextLine();
		
		System.out.println("Enter Course Section Number: ");
		int courseNumber = input.nextInt();
		input.nextLine();
		
		// search for the course
		for (Course course : courseList) {
			
			// check requirements to add
			if (course.getCourseName().equals(courseName)
				&& course.getCourseNumber() == courseNumber
				&& !(course.getCourseMax() == course.getCourseCurrent())) {
				
				// add this student to the course + course's studentCourseList
				course.addStudent(this);
				this.courseList.add(course);
				course.setCourseCurrent(course.getCourseCurrent() + 1);
				
				System.out.println("Course Added!");
				break;
			}
		}
		
	}

	// Withdraw from a Course 
	@Override
	public void withdrawCourse(ArrayList<Course>courseList) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// get course info
		System.out.println("Enter Course Name: ");
		String courseName = input.nextLine();
		System.out.println("Enter Course Section Number: ");
		int courseNumber = input.nextInt();
		input.nextLine();
		System.out.println("Enter Student First Name: ");
		String fname = input.nextLine();
		System.out.println("Enter Student Last Name: ");
		String lname = input.nextLine();
		
		// search for course
		for (Course course : courseList) {
			// check requirements to add
			if (course.getCourseName().equals(courseName)
				&& course.getCourseNumber() == courseNumber){
				course.removeStudent(this);
				course.setCourseCurrent(course.getCourseCurrent()-1);
			}
		}
		
	}
	
	// view current courses
	@Override
	public void viewCurrentCourses(ArrayList<Course> courseList) {
		System.out.println("Displaying courses currently registered in:");
		for (Course course : this.getCourseList()) {
			System.out.println(course.getCourseName());
		}
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	public void setStudentCourses(ArrayList<Course> courses) {
		this.courseList = courseList;
	}
	
}

