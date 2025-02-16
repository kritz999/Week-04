package com.annotations.basic;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Links to the container annotation
@interface BugReport {
    String description();
    String reportedBy();
}

class SoftwareModule {

    @BugReport(description = "Null pointer exception occurs on empty input", reportedBy = "Alice")
    @BugReport(description = "Performance degrades with large data sets", reportedBy = "Bob")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class CreateRepeatableAnnotation {
    public static void main(String[] args) {
        try {
            // Get the class object
            Class<?> moduleClass = SoftwareModule.class;

            // Get the method object
            Method method = moduleClass.getMethod("processData");

            // Check if @BugReport is present
            if (method.isAnnotationPresent(BugReports.class)) {
                // Retrieve the annotation
                BugReports bugReports = method.getAnnotation(BugReports.class);

                // Print all bug reports
                for (BugReport report : bugReports.value()) {
                    System.out.println("Bug Description: " + report.description());
                    System.out.println("Reported By: " + report.reportedBy());
                    System.out.println("------------------------");
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
