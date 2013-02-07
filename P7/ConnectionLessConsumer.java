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
      byte[] buffer = new byte[1000]; //create a buffer to be able to recieve a message
      while (true) 
      {
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        aSocket.receive(request); //Listen for a message
        String replyString = new String(request.getData());
        System.out.printf("Consumer: Recieved: %s\n", replyString) ; //Print the message
        DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(),
                request.getAddress(), request.getPort());
        aSocket.send(reply); //Send a reply to confirm having recieved the message
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
