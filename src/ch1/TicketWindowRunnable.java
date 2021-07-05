package ch1;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TicketWindowRunnable
{


    public static void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        InputStream input = socket.getInputStream();
        while(input.read(bytes)!=0){
            System.out.println(new String(bytes));
        }
    }
    public static void main(String[] args) throws IOException {

      server();

    }
}

