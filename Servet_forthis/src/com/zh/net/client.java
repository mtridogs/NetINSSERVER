package com.zh.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client implements Runnable{
	  static String  ip = "10.25.130.137";
	  static int port  = 8888;

	public void client() throws Exception
	{
		Socket dos2;
		Thread.sleep(1000);
		dos2 = new Socket(ip,port);
		Scanner scan = new Scanner(System.in);
		String dataout= null;
		DataOutputStream dataoutput2 = new DataOutputStream(new BufferedOutputStream(dos2.getOutputStream()));
	while(true){
		dataout = scan.next();
		dataoutput2.writeUTF(dataout);
		dataoutput2.flush();
		System.out.println("send done.......");
		}
			
	
	}
	public void run(){
		try {
			client();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
