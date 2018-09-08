package main;

import java.util.ArrayList;

public interface StudentInterface {
	public void viewAllCourses(ArrayList<Course>courseList);
	public void viewNotFullCourses(ArrayList<Course>courseList);
	public void registerCourse(ArrayList<Course> courseList);
	public void withdrawCourse(ArrayList<Course>courseList);
	public void viewCurrentCourses(ArrayList<Course> courseList);
}
