import java.net.*;
import java.io.*;
public class Client1{
    public static void main(String a[])throws Exception{
        Socket s=new Socket("localhost",5009);
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while(!str.equals("over")){
            System.out.println("Enter message:");
            str=br.readLine();
            dout.writeUTF(str);
            dout.flush();
        }
    }
}
