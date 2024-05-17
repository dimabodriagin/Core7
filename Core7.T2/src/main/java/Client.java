import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("netology.homework", Server.LOCALHOST_PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in);
        ) {
            System.out.println(reader.readLine());
            writer.println(scanner.nextLine());

            System.out.println(reader.readLine());
            writer.println(scanner.nextLine());

            System.out.println(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
