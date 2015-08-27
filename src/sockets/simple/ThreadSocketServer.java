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
public class ThreadSocketServer {

    ServerSocket server;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    String line;

    private ThreadSocketServer(ServerSocket ss) {
       server=ss;
    }

    public void listenSocket() {

        try {
           
            while (true){
            client = server.accept();
            SocketWorker sw = new SocketWorker(client);
            new Thread(sw).start();
                System.out.println("Spawned a new worker");
            }
            
        } catch (IOException e) {
            System.out.println("IO failed" + e.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) throws IOException {
         String ip = "localhost";
        int port = 4321;
        if (args.length == 2) {
            ip = args[0];
            port = Integer.parseInt(args[1]);
        }
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));

        ThreadSocketServer sos = new ThreadSocketServer(ss);
        sos.listenSocket();
    }
}
