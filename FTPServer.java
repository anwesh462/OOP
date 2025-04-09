import java.io.*;
import java.net.*;

public class FTPServer{
    public static void main(String[] args)throws Exception{
        try{
            ServerSocket server=new ServerSocket(8082);
            Socket socket=server.accept();
            DataInputStream din= new DataInputStream(socket.getInputStream());
            String fileName = din.readUTF();
            System.out.println("Receiving file: " + fileName);
            FileOutputStream fout=new FileOutputStream("received_" + fileName);
            byte[] buffer = new byte[4096];
            int value;
            while ((value=din.read(buffer))!=-1){
                fout.write(buffer,0,value);
            }
            System.out.println("File received and saved as: received_" + fileName);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            }}
}


