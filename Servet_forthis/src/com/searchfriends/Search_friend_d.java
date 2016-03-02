package com.searchfriends;

import java.io.IOException;

import Server.musql_me;
import Server.serverpoint;

public class Search_friend_d implements Runnable{

	   serverpoint sp;
	   
	   public Search_friend_d(serverpoint sp) {
		this.sp = sp;
	}
	public void run() {
		
		
		
		try {
			
		
			System.out.println("==============================");
			System.out.println("=================正在增加所需的好友======================");
			String username = sp.datain.readUTF();
			String myusername = sp.datain.readUTF();
			 System.out.println("接收到了，这里是好友添加服务器==============================================================================================================================>"+username+myusername);
			int pid = musql_me.mysqlQforfriendid(username);
			System.out.println("好友添加服务启动=================================================");
		    String friends = musql_me.mysqlformyfriend(myusername);
		    System.out.println("好友添加服务启动=================================================");
            String updatafriends =friends+","+pid;
            System.out.println("好友添加服务启动=================================================");
            musql_me.updataforfriend(updatafriends, myusername);//后面是我的（被增加的）用户名，他在第二个发送
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
