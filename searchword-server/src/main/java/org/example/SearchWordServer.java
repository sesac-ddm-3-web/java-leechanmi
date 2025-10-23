package org.example;

import org.example.config.ApplicationContext;
import org.example.service.SearchWordService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SearchWordServer {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();

        Thread jobThread = new Thread(context.getJobRunner(), "job-runner");
        jobThread.start();

        Thread serverThread = new Thread(() -> runServer(9999, context), "tcp-server");
        serverThread.start();

        try {
            serverThread.join();
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    private static void runServer(int port, ApplicationContext context) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("[SERVER] listen " + port);
            while (true) {
                Socket client = server.accept();
                new Thread(() -> handle(client, context), "client-" + client.getPort()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket client, ApplicationContext context) {
        System.out.println("[CLIENT CONNECTED] " + client.getInetAddress());

        try (
            var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ) {
            String request;
            while ((request = in.readLine()) != null) {
                SearchWordService service = context.getService();
                service.upsertSearchWord(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}