import java.io.*;
import java.net.*;

public class ConnectionLessConsumer
{
  public static void main(String args[])
  {
    DatagramSocket aSocket = null;
    try 
    {
      aSocket = new DatagramSocket(6789); // create socket at agreed port
      byte[] buffer = new byte[1000];
      while (true) 
      {
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        aSocket.receive(request);
        String replyString = new String(request.getData());
        System.out.printf("Consumer: Recieved: %s\n", replyString) ;
        DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(),
                request.getAddress(), request.getPort());
        aSocket.send(reply);
      }
    } catch (SocketException e)
    {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e)
    {
      System.out.println("IO: " + e.getMessage());
    } finally 
    {
      if (aSocket != null)
        aSocket.close();
    }
  }
}
