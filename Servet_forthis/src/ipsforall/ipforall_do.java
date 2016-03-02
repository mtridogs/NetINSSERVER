package ipsforall;

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

public class ipforall_do implements Runnable{
   serverpoint sp;
   
   public ipforall_do(serverpoint sp) {
	this.sp = sp;
}


public void run(){
	System.out.println("================线程开始运行==============");
	ResultSet rs =null;
	String str =null;
	int port_zhu =8889;
	

	try {
		String username= sp.datain.readUTF();
        String sends =musql_me.mysqlQforip(username);
        sp.dataout.writeUTF(sends);
        sp.dataout.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
}
