package com.example.yannick.bettingappServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yannick on 23-8-2016.
 */
public class ServerPlayer extends Thread{
    private int id;
    private String name;
    private Socket socket;

    public ServerPlayer(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            System.out.println(socket==null);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                System.out.println("k\n");
                String input = in.readLine();
                if(input!=null) {
                    System.out.println(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
