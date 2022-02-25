package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        //TODO
        if(students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }

    public boolean showSummary()
    {
        //TODO
        if(students.size() != 0 ) {
            return true;
        }
        return false;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO
        students.get(studentId).enrollToCourse(course);
    }

    //add
    public void addGrade(String studentId, String courseId, double grade)
    {
        students.get(studentId).addGrade(courseId, grade);
    }

    @Override
    public String toString() {
        String printOut = "";

        for(Student student : this.students.values()) {
            printOut += student + "\n" + "Enrolled Courses: \n";
            if (student.getEnrolledCourses().size() != 0)
            {
                for(Course course : student.getEnrolledCourses()) {
                    printOut += course + " Grade: " + student.getGrade(course.getCode()) + "\n";
                }
            }
            else
            {
                printOut += "[]\n";
            }

        }

        return printOut;
    }
}
