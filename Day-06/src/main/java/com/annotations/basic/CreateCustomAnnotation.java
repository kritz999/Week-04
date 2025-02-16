package com.annotations.basic;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME) // Annotation is available at runtime
@Target(ElementType.METHOD) // Can only be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}


class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}




public class CreateCustomAnnotation {
    public static void main(String[] args) {
        try {
            // Get the class object
            Class<?> taskClass = TaskManager.class;

            // Get the method object
            Method method = taskClass.getMethod("completeTask");

            // Check if @TaskInfo is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Retrieve the annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Display annotation details
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
