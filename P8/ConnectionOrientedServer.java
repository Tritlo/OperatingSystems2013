//package ch3Processes.connectionOrientedSocket;
import java.net.*;
import java.io.*;

public class ConnectionOrientedServer {
  public static void main(String args[]) {
    try {
      int serverPort = 7896; // the server port
      ServerSocket listenSocket = new ServerSocket(serverPort);
      while (true) {
        Socket clientSocket = listenSocket.accept();
        Thread handler = new requestHandlerThread(clientSocket);
        handler.start();
        try{
        Thread.sleep(2000);
        }catch(InterruptedException e)
        {
        }
      }
    } catch (IOException e) {
      System.out.println("Listen socket:" + e.getMessage());
    }
  }
}
