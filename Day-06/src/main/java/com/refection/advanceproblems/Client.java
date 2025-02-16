package com.refection.advanceproblems;

public class Client {
    @Inject  // Mark field for dependency injection
    private Service service;

    public void doSomething() {
        service.serve();
        System.out.println("🔹 Client is using the service!");
    }
}
