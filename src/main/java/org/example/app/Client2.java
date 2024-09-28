package org.example.app;

import org.example.app.utils.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket(Constants.HOST, Constants.SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("[CLIENT] Підключено до сервера");

            String userCommand;
            while (true) {
                System.out.print("Введіть команду (exit для виходу): ");
                userCommand = userInput.readLine();
                out.println(userCommand);

                if ("exit".equalsIgnoreCase(userCommand.trim())) {
                    System.out.println("[CLIENT] Вихід з програми");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
