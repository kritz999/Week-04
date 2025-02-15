package com.junittest.basicunittest;

public class TaskUntils {
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // 3-second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }


}
