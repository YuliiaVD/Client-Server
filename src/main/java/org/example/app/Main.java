package org.example.app;

import org.example.app.server.MultiClientServer;

public class Main {
    public static void main(String[] args) {

        new Thread(() -> {
            MultiClientServer server = new MultiClientServer();
            server.start();
        }).start();
    }
}
