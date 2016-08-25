package com.example.yannick.bettingappClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
/**
 * Created by Yannick on 23-8-2016.
 */
public class Client {
    private String state;
    private Game game;

    public Client() {

        state = "START";
        // Add Listeners

            /**
             * Responds to pressing the enter key in the textfield
             * by sending the contents of the text field to the
             * server and displaying the response from the server
             * in the text area.  If the response is "." we exit
             * the whole application, which closes all sockets,
             * streams and windows.
             */
        System.out.println((String) System.console().readLine());
        /**String response;
                try {
                    response = in.readLine();
                    if (response == null || response.equals("")) {
                        System.exit(0);
                    }
                } catch (IOException ex) {
                    response = "Error: " + ex;
                }
                messageArea.append(response + "\n");
                dataField.selectAll();*/
    }
    public void run() {
        Socket socket = null;
        try{
            socket = new Socket("192.168.2.14", 9090);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (state == "START") {
                String input = in.readLine();
                if (input.contains("startGame")) {
                    String[] players = input.split(" ");
                    ArrayList<Player> playerList = new ArrayList<Player>();
                    for(int i = 1; i < players.length; i++){
                         playerList.add(new Player(players[i]));
                    }
                    out.write("test\n");
                    out.flush();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {

        // Get the server address from a dialog box.

        // Make connection and initialize streams

        // Consume the initial welcoming messages from the server

    }

}
