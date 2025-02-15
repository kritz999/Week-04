package com.junittest.basicunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
class FileProcessorTest {
    private final FileProcessor fileProcessor = new FileProcessor();
    private final String testFile = "testFile.txt";
    private final String nonExistentFile = "nonExistent.txt";

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(Path.of(testFile)); // Ensure a clean start
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(testFile)); // Clean up after test
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, File Testing!";
        fileProcessor.writeToFile(testFile, content);

        // Verify the file exists
        assertTrue(Files.exists(Path.of(testFile)), "File should exist after writing.");

        // Verify content is correctly written & read
        assertEquals(content, fileProcessor.readFromFile(testFile), "File content should match.");
    }

    @Test
    void testReadNonExistentFileThrowsIOException() {
        // Ensure the file does not exist
        assertFalse(Files.exists(Path.of(nonExistentFile)), "File should not exist.");

        // Verify IOException is thrown when trying to read a non-existent file
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(nonExistentFile));
    }
}