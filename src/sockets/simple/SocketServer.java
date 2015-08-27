/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author sofus
 */
public class SocketServer {

    ServerSocket server;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    String line;

    public void listenSocket() {

        try {
            InetAddress bind = InetAddress.getByName("localhost");
            server = new ServerSocket(4321, 50, bind);
            client = server.accept();
            in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(),
                    true);

            while (true) {

                line = in.readLine();
                System.out.println("Recieved from client: "+line);
                    //Send data back to client
                out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IO failed" + e.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        SocketServer ss = new SocketServer();
        ss.listenSocket();
    }
}
