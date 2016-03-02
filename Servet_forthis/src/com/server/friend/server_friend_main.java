package com.server.friend;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


import Server.serverpoint;

public class server_friend_main implements Runnable{


	public static void main(String[] args) throws Exception {
		
		System.out.println("好友列表查询启动，监听8726...........");
		ServerSocket dis = new ServerSocket(8726);
		

		while(true)
		{
			
			
			Socket dos = dis.accept();
			DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
			DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
			serverpoint sp = new serverpoint(dataoutput,datainput,dos);
			new Thread(new server_friends(sp)).start();
			
		
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
