import java.net.*;
import java.io.*;
public class Comand{
    public static void main(String a[]) throws Exception{
        ServerSocket ss=new ServerSocket(5004);
         System.out.println("waiting for client....");
        Socket s=ss.accept();
        System.out.println("connected with client....Start now....");
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String line="";
         while(!line.equals("stop")){              
                line = din.readUTF();
                System.out.println("Received command: " + line);
                Process p= new ProcessBuilder("bash", "-c", line).start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuilder sb= new StringBuilder();
                String result;
                 while ((result = reader.readLine()) != null) {
                 sb.append(result).append("\n");
                 }
                 
                         dout.writeUTF(sb.toString());
                 
         }
    }
}
