package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;
    double average;

    private List<Course> enrolledCourses;
    private Map<String, Double> grades;

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );

        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void enrollToCourse( Course course )
    {
        //TODO
        this.enrolledCourses.add(course);
    }

    @Override
    public List<Course> findPassedCourses()
    {
        //TODO
        List<Course> courses = new ArrayList<>();

        for(Map.Entry<String, Double> entry : grades.entrySet()) {
            if(entry.getValue() >= PASS_MIN_GRADE) {
                courses.add(findCourseById(entry.getKey()));
            }
        }
        return courses;
    }

    public Course findCourseById( String courseId )
    {
        //TODO
        Course c = null;

        for(int i = 0; i < enrolledCourses.size(); i++) {
            if(enrolledCourses.get(i).getCode().equals(courseId)) {
                c = enrolledCourses.get(i);
            }
        }

        return c;
    }

    public Double getGrade(String courseId) {

        double grade = 0.0;
        if(grades.get(courseId) != null) {
            grade = grades.get(courseId);
        }
        return grade;
    }
    public void addGrade(String courseId, double grade) {

        grades.put(courseId, grade);
        //return null;
    }
    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO
        return this.enrolledCourses;
        //return null;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
