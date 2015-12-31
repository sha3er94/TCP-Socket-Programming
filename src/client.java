import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class client implements Runnable {

    public static void main(String[] args) throws IOException {
        String serverName;
        Scanner userInput = new Scanner(System.in);
        serverName = "LocalHost";
        System.out.println("Enter Port Number: ");
        int port = userInput.nextInt();
        System.out.println("Connecting to " + serverName + " on port " + port);
        System.out.println("Enter The Number of clients");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for (int i = 1; i <= num; i++) {
            thread2 c = new thread2("thread");
            c.start();
            System.out.println("thread " + i);
            c.run(port);
        }
    }

    @Override
    public void run() {

    }

}
