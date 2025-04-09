import java.io.*;
import java.net.*;
import java.util.Scanner;

public class VideoClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 5011;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to the server.");

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter command (PLAY_VIDEO <path>, QUIT): ");
                String command = scanner.nextLine();

                output.println(command);

                if (command.startsWith("PLAY_VIDEO")) {
                    String response = input.readLine();
                    System.out.println("Server: " + response);
                } else if (command.equalsIgnoreCase("QUIT")) {
                    System.out.println("Disconnecting from server...");
                    break;
                }
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
