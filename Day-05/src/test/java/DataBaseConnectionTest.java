package com.junittest.basicunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DataBaseConnectionTest {
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testDatabaseConnection() {
        assertTrue(dbConnection.isConnected(), "Database should be connected before the test runs.");
    }

    @Test
    void testDatabaseDisconnection() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected.");
    }
}