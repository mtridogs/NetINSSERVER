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
			System.out.println("=================������������ĺ���======================");
			String username = sp.datain.readUTF();
			String myusername = sp.datain.readUTF();
			 System.out.println("���յ��ˣ������Ǻ�����ӷ�����==============================================================================================================================>"+username+myusername);
			int pid = musql_me.mysqlQforfriendid(username);
			System.out.println("������ӷ�������=================================================");
		    String friends = musql_me.mysqlformyfriend(myusername);
		    System.out.println("������ӷ�������=================================================");
            String updatafriends =friends+","+pid;
            System.out.println("������ӷ�������=================================================");
            musql_me.updataforfriend(updatafriends, myusername);//�������ҵģ������ӵģ��û��������ڵڶ�������
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
