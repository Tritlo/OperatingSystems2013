import java.io.*;
import java.net.*;

public class ConnectionLessProducer
{
  public static void main(String args[])
  { 
    DatagramSocket aSocket = null;
    try 
    {
      aSocket = new DatagramSocket();
      String stringMsg = "0";
      String prevReply = "0";
      InetAddress aHost = InetAddress.getByName("localhost"); //recieve a message from the same computer
      int serverPort = 6789; // agreed port
      while(true)
      {
	     stringMsg = "" + (Integer.parseInt(stringMsg)+1);
         byte[] message = stringMsg.getBytes();
	     DatagramPacket request = new DatagramPacket(message, message.length,
		      aHost, serverPort);
         System.out.printf("Producer: Sending: %s\n", stringMsg);
	     aSocket.send(request); //send a message
	     byte[] buffer = new byte[1000];
	     DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
	     aSocket.receive(reply); //wait for a reply
         try
         {
            Thread.sleep(2000); //have a small waiting period
         }
         catch(InterruptedException e)
         {
         }
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
