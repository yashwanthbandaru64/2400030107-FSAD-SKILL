package com.fsad.annotationconfi;




public class Student {
    private int studentId;
    private String name;
    private String course;
    private int year;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", course=" + course + ", year=" + year + "]";
	}
}

