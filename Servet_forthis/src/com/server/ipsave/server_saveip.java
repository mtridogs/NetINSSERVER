package com.server.ipsave;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Server.musql_me;
import Server.serverpoint;

public class server_saveip implements Runnable{
	serverpoint sp = null;
	String username=null;
	String ip =null;
   public server_saveip(serverpoint sp,String ip,String username)
   {
	    this.sp=sp;
	    this.username=username;
	    this.ip = ip;
   }

public void run() {
	try {
		
		musql_me.updateip(username,ip);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
}
	
  
	
	
	
	
	
	
	
}
