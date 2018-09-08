package main;

import java.util.ArrayList;

public class Course implements java.io.Serializable, Comparable<Course>{
	// data fields
	String courseName;
	String courseID;
	int courseMax;
	int courseCurrent;
	String courseInstructor;
	int courseNumber;
	String courseLocation;
	
	// need a separate arraylist of students for student List in the course
	ArrayList <Student> studentList = new ArrayList<Student>();
	
	// default constructor
	public Course() {
	}
	
	// constructor
	public Course(String courseName, String courseID,
				int courseMax, int courseCurrent,
				String courseInstructor, int courseNumber,
				String courseLocation) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseMax = courseMax;
		this.courseCurrent = courseCurrent;
		this.courseInstructor = courseInstructor;
		this.courseNumber = courseNumber;
		this.courseLocation = courseLocation;
		
	}
	
	// constructor w/o current # of students in course
	public Course(String courseName, String courseID,
				int courseMax, String courseInstructor,
				int courseNumber, String courseLocation) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseMax = courseMax;
		this.courseInstructor = courseInstructor;
		this.courseNumber = courseNumber;
		this.courseLocation = courseLocation;
		setCourseCurrent(0);
		}
	
	// getters and setters
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getCourseMax() {
		return courseMax;
	}

	public void setCourseMax(int courseMax) {
		this.courseMax = courseMax;
	}

	public int getCourseCurrent() {
		return courseCurrent;
	}

	public void setCourseCurrent(int courseCurrent) {
		this.courseCurrent = courseCurrent;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	// Additional Methods
	
	// add student to the course
	public void addStudent(Student student) {
		this.studentList.add(student);
	}
	
	// remove student to the course
	public void removeStudent(Student student) {
		this.studentList.remove(student);
	}
	
	// compareTo method that checks if current # of students in a course is more or less
	// used in sort method in admin class
	@Override
	public int compareTo(Course course) {
		if (this.getCourseCurrent() > course.getCourseCurrent()) {
			return 1;
		} else if (this.getCourseCurrent() == course.getCourseCurrent()) {
			return 0;
		}
		return -1;
	}
}

