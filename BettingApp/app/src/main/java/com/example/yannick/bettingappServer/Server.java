package com.example.yannick.bettingappServer;

/**
 * Created by Yannick on 23-8-2016.
 */

import java.io.IOException;
import java.net.ServerSocket;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class Server {

    /**
     * Runs the server.
     */

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                try {
                     new ServerPlayer(listener.accept()).start();
                }catch (IOException e){

                }
            }
        }catch (Exception e) {
            listener.close();
        }
    }
}

