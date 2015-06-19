package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	public static void main(String[] args) {
		try {
			ServerSocket s=new ServerSocket(8189);
			Socket incoming = s.accept();
			try {
				InputStream inStream=incoming.getInputStream();
				OutputStream outputStream=incoming.getOutputStream();
				Scanner in=new Scanner(inStream);
				PrintWriter out =new PrintWriter(outputStream,true);
				out.println("Hello!Enter BYE to exit.");
				//echo client input
				boolean done=false;
				while (!done&&in.hasNextLine()) {
					String line=in.nextLine();
					out.println("Echo: "+line);
					if(line.trim().equals("BYE")) done = true;
				}
			} finally{
				incoming.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
