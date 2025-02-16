package com.annotations.advance;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.METHOD) // Can be applied only to methods
@interface roleAllowed {
    String value(); // Role required to access the method
}


class User {
    private String role; // User role (e.g., ADMIN, USER)

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


class SecureService {

    @roleAllowed("ADMIN") // Only ADMIN can access this method
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @roleAllowed("USER") // Only USER can access this method
    public void performUserTask() {
        System.out.println("User task executed successfully!");
    }
}


class AccessController {
    public static void checkAccessAndExecute(user user, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(roleAllowed.class)) {
                roleAllowed roleAllowed = method.getAnnotation(com.annotations.advance.roleAllowed.class);

                // Check if the user has the required role
                if (user.getRole().equals(roleAllowed.value())) {
                    method.invoke(obj); // Invoke the method if access is allowed
                } else {
                    System.out.println("Access Denied! " + user.getRole() + " cannot access " + methodName);
                }
            } else {
                method.invoke(obj); // Execute normally if no @RoleAllowed is present
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class roleAllow {

    public static void main(String[] args) {
        SecureService service = new SecureService();

        user adminUser = new user("ADMIN");
        user normalUser = new user("USER");


        AccessController.checkAccessAndExecute(adminUser, service, "performAdminTask");


        AccessController.checkAccessAndExecute(normalUser, service, "performAdminTask");


        AccessController.checkAccessAndExecute(normalUser, service, "performUserTask");


        AccessController.checkAccessAndExecute(adminUser, service, "performUserTask");
    }
}
