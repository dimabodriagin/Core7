import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer LOCALHOST_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket((LOCALHOST_PORT))) {
            System.out.println("Server started");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    out.println("Write your name: ");
                    String clientName = in.readLine();

                    out.println("Are you child? (yes/no)");
                    String answer = in.readLine();
                    if (answer.equals("no")) {
                        System.out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", clientName);
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", clientName));
                        break;
                    }
                    System.out.printf("Welcome to the kids area, %s! Let's play!", clientName);
                    out.println(String.format("Welcome to the kids area, %s! Let's play!", clientName));

                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
