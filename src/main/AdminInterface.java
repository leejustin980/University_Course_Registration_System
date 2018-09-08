package main;

import java.util.ArrayList;

public interface AdminInterface {
	// course management
	public void createCourse(ArrayList<Course>courseList);
	public void deleteCourse(ArrayList<Course> courseList, ArrayList<User> users);
	public void editCourse(ArrayList<Course> courseList);
	public void displayCourseInfo(ArrayList<Course> courseList);
	public void registerStudent(ArrayList<User>userList);
	
	// reports for admin
	public void viewAllCourses(ArrayList<Course> courseList);
	public void viewFullCourses(ArrayList<Course> courseList);
	public void writeFile(ArrayList<Course> courseList);
	public void viewStudents(ArrayList<Course> courseList, ArrayList<User> userList );
	public void viewStudentCourses(ArrayList<User> userList);
	public void sortCourses(ArrayList<Course> courseList, int low, int high);
}
