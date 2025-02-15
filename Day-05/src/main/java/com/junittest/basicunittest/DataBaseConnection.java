package com.junittest.basicunittest;

public class DataBaseConnection {
    private boolean isConnected = false;

    // Simulate database connection
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Simulate disconnecting from the database
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    // Method to check connection status
    public boolean isConnected() {
        return isConnected;
    }
}
