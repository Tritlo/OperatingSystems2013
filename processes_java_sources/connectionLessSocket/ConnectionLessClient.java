package ch3Processes.connectionLessSocket;
import java.io.*;
import java.net.*;

public class ConnectionLessClient {
  public static void main(String args[]) { // args[0]: message contents,
                                           // args[1]: destination hostname
    DatagramSocket aSocket = null;
    try {
      aSocket = new DatagramSocket();
      byte[] message = args[0].getBytes();
      InetAddress aHost = InetAddress.getByName(args[1]);
      int serverPort = 6789; // agreed port
      DatagramPacket request = new DatagramPacket(message, message.length,
          aHost, serverPort);
      aSocket.send(request);
      byte[] buffer = new byte[1000];
      DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
      aSocket.receive(reply);
      System.out.println("Reply: " + new String(reply.getData()));
    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    } finally {
      if (aSocket != null)
        aSocket.close();
    }
  }
}
