/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.selfmade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sofus
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 4321;
        if (args.length == 2) {
            ip = args[0];
            port = Integer.parseInt(args[1]);
        }
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));
        Socket s;
        while (true) {
            s = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(),
                    true);
            // waits for data and reads it in until connection dies
            // readLine() blocks until the server receives a new line from client
            String str;
            while ((str = in.readLine()) != null) {
                if (str.equals("!!")) {
                    System.exit(0);
                }
                out.println(str);
            }

        }
    }
}
