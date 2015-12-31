import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class thread2 extends Thread {

    private Thread t;
    private String threadName;
    public int Port;
    public String serverName;

    public int getPort() {
        return Port;
    }

    thread2(String name) {
        threadName = name;
    }

    public void run(int Port) {
        System.out.println("Running " + threadName);

        OutputStream outToServer = null;
        try {
            Socket clientSocket = new Socket(serverName, Port);
            System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
            outToServer = clientSocket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            //   System.out.println("thread " + i);
            Random rand = new Random();
            System.out.println("first number: ");
            Integer x = rand.nextInt(50);
            System.out.println(x);
            System.out.println("second number: ");
            Integer y = rand.nextInt(50);
            System.out.println(y);
            out.writeInt(x);
            out.writeInt(y);
            InputStream inFromServer = clientSocket.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Server responds: " + in.readInt());
            clientSocket.close();
            Thread.sleep(1000);
        } catch (IOException ex) {
            Logger.getLogger(thread2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(thread2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                outToServer.close();
            } catch (IOException ex) {
                Logger.getLogger(thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }

    }

}
