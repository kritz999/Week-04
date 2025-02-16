package com.javagenerics.multilevelcoursemanagementsystem;

import java.util.ArrayList;
import java.util.List;




    abstract class CourseType {
        private String courseName;
        private String instructor;

        public CourseType(String courseName, String instructor) {
            this.courseName = courseName;
            this.instructor = instructor;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getInstructor() {
            return instructor;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " - " + courseName + " (Instructor: " + instructor + ")";
        }
    }


    class ExamCourse extends CourseType {
        private int examWeightage;

        public ExamCourse(String courseName, String instructor, int examWeightage) {
            super(courseName, instructor);
            this.examWeightage = examWeightage;
        }

        public int getExamWeightage() {
            return examWeightage;
        }
    }

    class AssignmentCourse extends CourseType {
        private int assignmentCount;

        public AssignmentCourse(String courseName, String instructor, int assignmentCount) {
            super(courseName, instructor);
            this.assignmentCount = assignmentCount;
        }

        public int getAssignmentCount() {
            return assignmentCount;
        }
    }

    class ResearchCourse extends CourseType {
        private String researchTopic;

        public ResearchCourse(String courseName, String instructor, String researchTopic) {
            super(courseName, instructor);
            this.researchTopic = researchTopic;
        }

        public String getResearchTopic() {
            return researchTopic;
        }
    }

    // Step 3: Define a Generic Course Management Class
    class Course<T extends CourseType> {
        private List<T> courses = new ArrayList<>();

        public void addCourse(T course) {
            courses.add(course);
        }

        public void displayCourses() {
            for (T course : courses) {
                System.out.println(course);
            }
        }

        public List<T> getCourses() {
            return courses;
        }
    }


    class Department {
        private String name;
        private List<Course<? extends CourseType>> coursesOffered = new ArrayList<>();

        public Department(String name) {
            this.name = name;
        }

        public void addCourse(Course<? extends CourseType> course) {
            coursesOffered.add(course);
        }

        public void displayAllCourses() {
            System.out.println("\nCourses in " + name + " Department:");
            for (Course<? extends CourseType> course : coursesOffered) {
                course.displayCourses();
            }
        }
    }


    public class MultiLevelCourseManagementSystem {
        public static void main(String[] args) {
            // Creating Course Management for different types
            Course<ExamCourse> examCourses = new Course<>();
            Course<AssignmentCourse> assignmentCourses = new Course<>();
            Course<ResearchCourse> researchCourses = new Course<>();

            // Adding courses
            examCourses.addCourse(new ExamCourse("Mathematics", "Dr. Sharma", 70));
            examCourses.addCourse(new ExamCourse("Physics", "Dr. Kumar", 60));

            assignmentCourses.addCourse(new AssignmentCourse("Software Engineering", "Prof. Rao", 5));
            assignmentCourses.addCourse(new AssignmentCourse("Data Science", "Dr. Mehta", 6));

            researchCourses.addCourse(new ResearchCourse("AI & ML", "Dr. Sen", "Deep Learning"));
            researchCourses.addCourse(new ResearchCourse("Cybersecurity", "Prof. Gupta", "Network Security"));

            // Creating a Department and adding courses
            Department csDepartment = new Department("Computer Science");
            csDepartment.addCourse(examCourses);
            csDepartment.addCourse(assignmentCourses);
            csDepartment.addCourse(researchCourses);

            // Display all courses in the department
            csDepartment.displayAllCourses();
        }
    }




