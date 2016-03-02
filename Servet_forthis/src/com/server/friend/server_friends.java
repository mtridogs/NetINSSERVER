package com.server.friend;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import Server.musql_me;

import Server.serverpoint;

public class server_friends implements Runnable{

	   serverpoint sp;
	   
	   public server_friends(serverpoint sp) {
		this.sp = sp;
	}


	public void run() {
		
		try {
			
			String str =null;
             System.out.println("开始查询好友列表.........");

		    String username = sp.datain.readUTF();  
		  
		    String[] name = musql_me.mysqlQforfriend(username);


		    for(int l=0;l<name.length;l++)
			{
		    	
		    	if(name[l]==null)
		    	{  sp.dataout.writeUTF("error");  sp.dataout.flush();}
		    	else
		    	{  sp.dataout.writeUTF(name[l]);  sp.dataout.flush();}
			}
		    
		    for(int l=0;l<15;l++)
		    {
		    	
		    	if(name[l]==null)
		    		{
		    		
		    		sp.dataout.writeUTF("未知"); sp.dataout.flush();}
		    	else
		    	{
		    
		    	String onup = musql_me.mysqlQforfriendsuplineforone(name[l]);
		    	sp.dataout.writeUTF(onup);
		    	sp.dataout.flush();
		    	}
		    }
		
		
			
			//datainput.close();
			//dataoutput.close();
			///dos.close();
			//dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	
	
	
	
}
