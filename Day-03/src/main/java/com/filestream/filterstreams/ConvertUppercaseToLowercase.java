package com.filestream.filterstreams;

import java.io.*;

public class ConvertUppercaseToLowercase {


    public static void main(String[] args) {
        String inputFilePath = "input.txt"; // Change this to your text file path
        String outputFilePath = "output.txt";

        try {
            convertFileToLowerCase(inputFilePath, outputFilePath);
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Convert text file contents to lowercase and write to another file
    public static void convertFileToLowerCase(String inputPath, String outputPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
        }
    }
    }

