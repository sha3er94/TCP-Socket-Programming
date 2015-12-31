import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server extends Thread {

    public ServerSocket serverSocket;
    public server t;
    public server(ServerSocket welcomeSocket)
    {
        serverSocket = welcomeSocket;
        try {
            serverSocket.setSoTimeout(100000);
        } catch (SocketException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            //System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            try (Socket server = serverSocket.accept()) 
            {
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                Integer x = in.readInt();
                System.out.println("Hellox : "+x );
                Integer y = in.readInt();
                System.out.println("Helloy : "+y);
                Integer sum = (x + y);
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeInt(sum);
            }
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");

        } catch (IOException e) {
        }
    }

    public static void main(String[] args,  ServerSocket welcomeSocket) throws IOException {
       // while (true)
        { //server t = new server(welcomeSocket);
       // t.start();
        }
      
    }
   

}
