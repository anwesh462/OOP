
import java.net.*;
import java.io.*;
public class JServer{
    public static void main(String a[]) throws Exception{
        ServerSocket ss=new ServerSocket(5054);
        System.out.println("Connection successful");
        System.out.println("Waiting for Client message");
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream()); 
        DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
         String line="";
          while (!line.equals("Over")) {
                   line = din.readUTF();
                    Runtime rt = Runtime.getRuntime();
                    
                        Process p = rt.exec("javac " + line + ".java");
                        Process p2 = rt.exec("java " + line);
                        BufferedReader br=new BufferedReader(new InputStreamReader(p2.getInputStream()));
                        String outputLine;
                        System.out.println("Dear client, Check Client window for O/P:");
                        while ((outputLine=br.readLine()) != null) {
                            dout.writeUTF(outputLine);
                            dout.flush();
                        }
                    
}}}
