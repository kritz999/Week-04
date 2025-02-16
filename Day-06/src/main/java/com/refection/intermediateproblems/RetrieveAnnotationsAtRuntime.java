package com.refection.intermediateproblems;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Define a custom annotation @Author
@Retention(RetentionPolicy.RUNTIME)  // Annotation available at runtime
@Target(ElementType.TYPE)  // Can be applied to classes
@interface Author {
    String name();
}
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("This is a Book class.");
    }
}

public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) {


        Class<Book> cls = Book.class;

        // Check if @Author annotation is present
        if (cls.isAnnotationPresent(Author.class)) {
            // Retrieve the annotation
            Author author = cls.getAnnotation(Author.class);

            // Display the annotation value
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No Author annotation found.");
        }
    }
}