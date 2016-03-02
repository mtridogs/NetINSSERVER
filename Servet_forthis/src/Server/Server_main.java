package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_main implements Runnable{
	
public static void main(String args[]) throws Exception
{
	String str =null;
	int port = 8888;
	ServerSocket dis = new ServerSocket(8888);
	System.out.println("端口"+port+"被占用=========服务登陆端口开启");

	while(true)
	{
		Socket dos = dis.accept();
		DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
		DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
		serverpoint sp = new serverpoint(dataoutput,datainput,dos);
		new Thread(new server_login_d(sp)).start();
		System.out.println("==========      next     =======kai shi xun huan===========      next      ===");
	}	
}


public void run() {
	
	try {
		main(null);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
