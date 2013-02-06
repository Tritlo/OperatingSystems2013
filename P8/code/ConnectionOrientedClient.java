//package ch3Processes.connectionOrientedSocket;
import java.net.*;
import java.io.*;

public class ConnectionOrientedClient {
  public static void main(String args[]) {
    // args[0]: message contents, args[1]: destination hostname
    Socket aSocket = null;
    try {
      int serverPort = 7896;
      aSocket = new Socket(args[1], serverPort);
      DataInputStream in = new DataInputStream(aSocket.getInputStream());
      DataOutputStream out = new DataOutputStream(aSocket.getOutputStream());
      out.writeUTF(args[0]); // UTF is a string encoding
      String data = in.readUTF(); // read a line of data from the stream
      System.out.println("Received: " + data);
    } catch (UnknownHostException e) { System.out.println("Socket:" + e.getMessage());
    } catch (EOFException e) { System.out.println("EOF:" + e.getMessage());
    } catch (IOException e) { System.out.println("readline:" + e.getMessage());
    } finally {
      if (aSocket != null)
      try {
        aSocket.close();
      } catch (IOException e) { System.out.println("close:" + e.getMessage());
      }
    }
  }
}
