package com.searchfriends;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Server.serverpoint;

import com.charconupline.server_uponlion;

public class Search_friends_main implements Runnable{

	public static void main(String args[])
	{
		try {
			ServerSocket dis = new ServerSocket(6256);
			System.out.println("好友增加删除服务器监听服务器启动，监听端口6256========================");
			Socket dos = dis.accept();
			System.out.println("好友添加服务启动=================================================");
			DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
			DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
			serverpoint sp = new serverpoint(dataoutput,datainput,dos);
			new Thread(new server_uponlion(sp)).start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	public void run() {
	
		main(null);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
