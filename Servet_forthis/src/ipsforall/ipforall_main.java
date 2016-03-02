package ipsforall;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Server.serverpoint;

public class ipforall_main implements Runnable{
	
public static void main(String args[]) throws Exception
{
	String str =null;
	
	int port_zhu =6986;
	ServerSocket sock_zhu = new ServerSocket(6986);
	System.out.println("端口"+port_zhu+"端口被占用===========ip分配器开启端口开启");
	
	while(true)
	{
		
		
		Socket dos = sock_zhu.accept();
		DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
		DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
		serverpoint sp = new serverpoint(dataoutput,datainput,dos);
		new Thread(new ipforall_do(sp)).start();
		
	
	
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
