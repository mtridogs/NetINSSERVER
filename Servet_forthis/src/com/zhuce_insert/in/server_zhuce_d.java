package com.zhuce_insert.in;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Server.musql_me;
import Server.serverpoint;

public class server_zhuce_d implements Runnable{
   serverpoint sp;
   
   public server_zhuce_d(serverpoint sp) {
	this.sp = sp;
}


public void run(){
	System.out.println("================线程开始运行==============");
	ResultSet rs =null;
	String str =null;
	int port_zhu =8889;
	

	try {
		
		String username= sp.datain.readUTF();
		String pass = sp.datain.readUTF();
		String nname = sp.datain.readUTF();
		String emain = sp.datain.readUTF();

		Integer ls = musql_me.mysqlQforzhuce(username);

		
		if(ls.equals(0))
		{
			musql_me.insertmysql(username,pass,nname,emain);
			sp.dataout.writeInt(0);//0表示完成了注册。
			sp.dataout.flush();
		}
		else 
		{
			
			sp.dataout.writeInt(1);
			sp.dataout.flush();
		}
		
		
		
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
}
