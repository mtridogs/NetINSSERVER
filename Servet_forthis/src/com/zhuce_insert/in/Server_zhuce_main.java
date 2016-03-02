package com.zhuce_insert.in;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Server.serverpoint;

public class Server_zhuce_main implements Runnable{
	
public static void main(String args[]) throws Exception
{
	String str =null;
	
	int port_zhu =8889;
	
	ServerSocket sock_zhu = new ServerSocket(8889);

	while(true)
	{
		Socket dos = sock_zhu.accept();
		DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
		DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
		serverpoint sp = new serverpoint(dataoutput,datainput,dos);
		new Thread(new server_zhuce_d(sp)).start();
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
