package com.filestream.bufferedstream;

import java.io.*;

public class EfficientFileCopy {

    public static void main(String[] args) {
        float start = System.nanoTime();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("input.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))){

                byte[] buffer = new byte[4096];
                int bytesRead;

                while((bytesRead = bis.read(buffer))!=-1){
                    bos.write(buffer,0,bytesRead);
                }

                System.out.println("File copied successfully with buffering.");

            }catch (IOException e) {
            e.printStackTrace();

            float end = System.nanoTime();
            System.out.println((start-end)+"ns");

        }

        }
}
