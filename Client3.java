//run a app in Server from client
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client3 {
public static void main(String[] args) {
try (Socket socket = new Socket("localhost", 5003)) {
    System.out.println("Connected to the server.");

    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the command or application to run on the server: ");
    String appCommand = scanner.nextLine();

    writer.println(appCommand);
}
catch (IOException ex) {
    System.out.println("I/O error: " + ex.getMessage());
}
}}
