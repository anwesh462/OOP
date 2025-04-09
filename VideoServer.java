import java.io.*;
import java.net.*;

public class VideoServer {
    public static void main(String[] args) {
        int port = 5011;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String command = input.readLine();
                if (command != null && command.startsWith("PLAY_VIDEO")) {
                    String videoPath = command.substring(11).trim(); // Extract the video path
                    System.out.println("Requested to play video: " + videoPath);

                    File videoFile = new File(videoPath);
                    if (videoFile.exists() && videoFile.isFile()) {
                        try {
                            // Use the default OS media player to open the video
                            String os = System.getProperty("os.name").toLowerCase();
                            if (os.contains("win")) {
                                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", videoPath});
                            } else if (os.contains("mac")) {
                                Runtime.getRuntime().exec(new String[]{"open", videoPath});
                            } else if (os.contains("nix") || os.contains("nux")) {
                                Runtime.getRuntime().exec(new String[]{"xdg-open", videoPath});
                            }
                            output.println("VIDEO PLAYING");
                        } catch (Exception e) {
                            output.println("ERROR: Unable to play the video. " + e.getMessage());
                        }
                    } else {
                        output.println("ERROR: Video file not found.");
                    }
                } else if (command != null && command.equals("QUIT")) {
                    System.out.println("Client disconnected.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
