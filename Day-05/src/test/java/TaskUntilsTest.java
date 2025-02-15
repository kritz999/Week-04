package com.junittest.basicunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

class TaskUntilsTest {
    private final TaskUtils taskUtils = new TaskUtils();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fails if execution > 2s
    void testLongRunningTask() {
        assertEquals("Task Completed", taskUtils.longRunningTask());
    }


}