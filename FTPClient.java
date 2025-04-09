import java.io.*;
import java.net.*;

public class FTPClient{

    public static void main(String[] args)throws Exception{
            Socket s= new Socket("localhost", 8082);
            System.out.println("Connected to the server.");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            System.out.println("enter the file path :");
            String str=br.readLine();
            File file=new File(str); // Replace with your file's path
            if (!file.exists()){
                System.out.println("File does not exist.");
                return;
            }
            dout.writeUTF(file.getName());
            FileInputStream fin=new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int value;
            while ((value=fin.read(buffer))!=-1){
                dout.write(buffer, 0,value);
            }
            System.out.println("File sent successfully.");
            }
}