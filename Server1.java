import java.net.*;
import java.io.*;
public class Server1{
    public static void main(String a[]) throws Exception{
        ServerSocket ss=new ServerSocket(5006);
        System.out.println("Connection successful");
        System.out.println("Waiting for Client message");
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());  
        String str="";
        while(!str.equals("over")){
            str=din.readUTF();
            System.out.println("Client Msg:"+str);
        }
    din.close();
    s.close();
    ss.close();
    }
}
