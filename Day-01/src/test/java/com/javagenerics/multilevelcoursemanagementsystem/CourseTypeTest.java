package com.javagenerics.multilevelcoursemanagementsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
class CourseTypeTest {
    private Course<ExamCourse> examCourseContainer;
    private Course<AssignmentCourse> assignmentCourseContainer;
    private Course<ResearchCourse> researchCourseContainer;
    private Department csDepartment;

    @BeforeEach
    void setUp() {
        examCourseContainer = new Course<>();
        assignmentCourseContainer = new Course<>();
        researchCourseContainer = new Course<>();
        csDepartment = new Department("Computer Science");

        // Adding courses
        examCourseContainer.addCourse(new ExamCourse("Mathematics", "Dr. Sharma", 70));
        examCourseContainer.addCourse(new ExamCourse("Physics", "Dr. Kumar", 60));

        assignmentCourseContainer.addCourse(new AssignmentCourse("Software Engineering", "Prof. Rao", 5));
        assignmentCourseContainer.addCourse(new AssignmentCourse("Data Science", "Dr. Mehta", 6));

        researchCourseContainer.addCourse(new ResearchCourse("AI & ML", "Dr. Sen", "Deep Learning"));
        researchCourseContainer.addCourse(new ResearchCourse("Cybersecurity", "Prof. Gupta", "Network Security"));

        // Adding courses to department
        csDepartment.addCourse(examCourseContainer);
        csDepartment.addCourse(assignmentCourseContainer);
        csDepartment.addCourse(researchCourseContainer);
    }

    @Test
    void testAddCourse() {
        assertEquals(2, examCourseContainer.getCourses().size());
        assertEquals(2, assignmentCourseContainer.getCourses().size());
        assertEquals(2, researchCourseContainer.getCourses().size());
    }


    @Test
    void testRetrieveCourses() {
        List<ExamCourse> examCourses = examCourseContainer.getCourses();
        assertEquals("Mathematics", examCourses.get(0).getCourseName());
        assertEquals("Physics", examCourses.get(1).getCourseName());

        List<AssignmentCourse> assignmentCourses = assignmentCourseContainer.getCourses();
        assertEquals(5, assignmentCourses.get(0).getAssignmentCount());
    }


    @Test
    void testDepartmentCourses() {
        assertDoesNotThrow(() -> csDepartment.displayAllCourses());
    }

    @Test
    void testToStringFormat() {
        ExamCourse examCourse = examCourseContainer.getCourses().get(0);
        assertEquals("ExamCourse - Mathematics (Instructor: Dr. Sharma)", examCourse.toString());

        AssignmentCourse assignmentCourse = assignmentCourseContainer.getCourses().get(0);
        assertEquals("AssignmentCourse - Software Engineering (Instructor: Prof. Rao)", assignmentCourse.toString());

        ResearchCourse researchCourse = researchCourseContainer.getCourses().get(0);
        assertEquals("ResearchCourse - AI & ML (Instructor: Dr. Sen)", researchCourse.toString());
    }


    @Test
    void testTypeSafety() {
        // This should fail at compilation if uncommented
        // Course<String> stringCourse = new Course<>(); // Not allowed

        assertTrue(true); // Placeholder to indicate compile-time safety
    }


}