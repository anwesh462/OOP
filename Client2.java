import java.net.*;
import java.io.*;
public class Client2{
    public static void main(String a[])throws Exception{
        Socket s=new Socket("localhost",5054);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String str="",str1="";
        while(!str.equals("stop")){
            System.out.print("Client Msg:");
            str=br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str1=din.readUTF();
            System.out.println("Server Msg:"+str1);
        }
        dout.close();
        s.close();
    }
}
