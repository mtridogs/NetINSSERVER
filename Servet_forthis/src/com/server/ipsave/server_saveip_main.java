package com.server.ipsave;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Server.server_login_d;
import Server.serverpoint;

public class server_saveip_main implements Runnable{
	
public static void main(String args[]) throws Exception
{
	String str =null;
    System.out.println("IP´¢´æ·þÎñÆ÷Æô¶¯£¬¼àÌý¶Ë¿Ú5675=============================");
	ServerSocket dis = new ServerSocket(5675);
	

	while(true)
	{
		Socket dos = dis.accept();
		System.out.println("==============kai shi xun huan==============");
		
		DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
		
		DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
		
		String ip =datainput.readUTF();
		
		String username = datainput.readUTF();
		
		serverpoint sp = new serverpoint(dataoutput,datainput,dos);
		new Thread(new server_saveip(sp,ip,username)).start();
	}	
}


public void run() {
	try {
		main(null);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
