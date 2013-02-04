import java.net.*;
public class requestHandlerThread extends Thread
{
    Socket clientSocket;

    public requestHandlerThread(Socket c)
    {
        this.clientSocket = c;
    }

    public void run()
    {
        Connection c = new Connection(clientSocket); // Handle request
    }
}
