package com.filestream.pipedstreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.*;
public class InterThreadCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            System.err.println("Error initializing piped streams: " + e.getMessage());
        }
    }
}

class Writer implements Runnable {
    private PipedOutputStream pos;

    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try (PipedOutputStream output = pos) {
            String message = "Hello from Writer Thread!";
            output.write(message.getBytes());
            System.out.println("Writer: Message sent.");
        } catch (IOException e) {
            System.err.println("Writer error: " + e.getMessage());
        }
    }
}

class Reader implements Runnable {
    private final PipedInputStream pis;

    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (PipedInputStream input = pis) {
            byte[] buffer = new byte[1024];
            int length = input.read(buffer);
            String message = new String(buffer, 0, length);
            System.out.println("Reader: Received message - " + message);
        } catch (IOException e) {
            System.err.println("Reader error: " + e.getMessage());
        }
    }
}



