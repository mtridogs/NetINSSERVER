package com.charconupline;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.zhuce_insert.in.server_zhuce_d;

import Server.musql_me;
import Server.serverpoint;

public class uplinecontr_main implements Runnable{
public static  void main(String args[]) throws Exception

{
	
	
	
	ServerSocket dis = new ServerSocket(5689);
	System.out.println("上线监听服务器启动========================");
	Socket dos = dis.accept();
	DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
	DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
	serverpoint sp = new serverpoint(dataoutput,datainput,dos);
	new Thread(new server_uponlion(sp)).start();
	
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
