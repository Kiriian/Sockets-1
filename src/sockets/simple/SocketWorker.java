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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofus
 */
public class SocketWorker implements Runnable{
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String line;

    public SocketWorker(Socket soc) {
    socket=soc;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),
                    true);

            while (true) {
                line = in.readLine();
                System.out.println("Worker "+Thread.currentThread().getName());
                //Send data back to client
                out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
