/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.simple;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sofus
 */
public class SimpleServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    // Register service on port 1254
ServerSocket s = new ServerSocket(1254);
Socket s1=s.accept(); // Wait and accept a connection
// Get a communication stream associated with the socket
OutputStream s1out = s1.getOutputStream();
DataOutputStream dos = new DataOutputStream (s1out);
// Send a string!
dos.writeUTF("Hi there");
// Close the connection, but not the server socket
dos.close();
s1out.close();
s1.close();    
    }
    
}
