/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sofus
 */
public class SocketClient implements Runnable {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String echo;
    String line;

    public SocketClient(Socket soc) {
        socket = soc;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),
                    true);

            while (true) {
                System.out.println("Write a line");
                line= scanner.nextLine();
                out.println(line);
                echo = in.readLine();
                System.out.println("Got " + echo +" back from server");
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
               String ip = "localhost";
        int port=4321;
        if(args.length==2){
     ip = args[0];
     port = Integer.parseInt(args[1]);
  }

        Socket ss = new Socket(ip,port);
        
        SocketClient sw = new SocketClient(ss);
        Thread t1 = new Thread(sw);
        t1.start();
    }

}
