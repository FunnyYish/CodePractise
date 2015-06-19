package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreaderEchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int i=1;
			ServerSocket s=new ServerSocket(8189);
			while (true) {
				Socket incoming=s.accept();
				System.out.println("Spawning "+i);
				Runnable r=new ThreadedEchoHandler(incoming);
				Thread t=new Thread(r);
				t.start();
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
