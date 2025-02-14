package com.filestream.filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

  public class FileHandling {

        public static void main(String[] args) {
            String sourceFile = "input.txt";
            String destinationFile = "output.txt";

            try (FileInputStream fis = new FileInputStream(sourceFile);
                 FileOutputStream fos = new FileOutputStream(destinationFile)) {

                int byteData;
                while ((byteData = fis.read()) != -1) {
                    fos.write(byteData);
                }

                System.out.println("File copied successfully.");
            } catch (FileNotFoundException e) {
                System.out.println(" Source file not found.");
            } catch (IOException e) {
                System.out.println(" An IO exception occurred.");
                e.printStackTrace();
            }
        }
    }

