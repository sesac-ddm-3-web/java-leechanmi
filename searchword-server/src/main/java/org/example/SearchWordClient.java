package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SearchWordClient {
    private static String SERVER_HOST = "localhost";
    private static int SERVER_PORT = 9999;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    private Scanner scanner;
    private
    void connect() throws IOException {
        socket = new Socket(SERVER_HOST, SERVER_PORT);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        scanner = new Scanner(System.in);
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    private void sendMessage(String message) {
        output.println(message);
    }

    private String receiveMessage() throws IOException {
        return input.readLine();
    }

    public void start() {
        try {
            connect();
            while(true) {
                System.out.print("검색어: ");
                String input = scanner.nextLine().trim();
                // sendMessage("입력된 검색어:"+ input);
                sendMessage(input);
            }
        } catch (IOException e) {
            System.err.println("서버 연결 실패: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    private void disconnect() {
        try {
            if (scanner != null) scanner.close();
            if (input != null) input.close();
            if (output != null) output.close();
            if (socket != null && !socket.isClosed()) socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (IOException e) {
            System.err.println("연결 종료 중 오류: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SearchWordClient searchWordClient = new SearchWordClient();
        searchWordClient.start();
    }
}
