package com.charconupline;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import Server.musql_me;
import Server.server_login_d;
import Server.serverpoint;

public class server_uponlion implements Runnable{
	   serverpoint sp;
	   
	   public server_uponlion(serverpoint sp) {
		this.sp = sp;
	}
		
	public void run(){
		
		try {
			System.out.println("=======================================");
			String username = sp.datain.readUTF();
			System.out.println("===============================>IP上线的用户名为"+username);
			musql_me.updateuponlion(username);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
		
	
    
}
