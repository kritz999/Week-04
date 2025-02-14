package com.filestream.bytearraystream;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
public class ConvertImageToByteArray {


        public static void main(String[] args) {
            String inputImagePath = "Pikachu.jpg"; // Change this to your image path
            String outputImagePath = "output.jpg";

            try {
                // Convert image to byte array
                byte[] imageBytes = imageToByteArray(inputImagePath);

                // Write byte array back to image file
                byteArrayToImage(imageBytes, outputImagePath);

                // Verify if the files are identical
                if (areFilesIdentical(inputImagePath, outputImagePath)) {
                    System.out.println("The original and copied images are identical.");
                } else {
                    System.out.println("The images are not identical.");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        // Convert image to byte array
        public static byte[] imageToByteArray(String imagePath) throws IOException {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 FileInputStream fis = new FileInputStream(imagePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                return baos.toByteArray();
            }
        }

        // Convert byte array back to image
        public static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputPath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        }

        // Verify if two files are identical
        public static boolean areFilesIdentical(String filePath1, String filePath2) throws IOException {
            byte[] file1Bytes = Files.readAllBytes(new File(filePath1).toPath());
            byte[] file2Bytes = Files.readAllBytes(new File(filePath2).toPath());
            return Arrays.equals(file1Bytes, file2Bytes);
        }
    }



