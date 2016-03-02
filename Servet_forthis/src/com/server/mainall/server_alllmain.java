package com.server.mainall;

import javax.print.attribute.standard.Severity;

import ipsforall.ipforall_main;
import Server.Server_main;

import com.charconupline.uplinecontr_main;
import com.searchfriends.Search_friends_main;
import com.server.friend.server_friend_main;
import com.server.ipsave.server_saveip_main;
import com.zhuce_insert.in.Server_zhuce_main;

public class server_alllmain {
	public static void main(String args[])
	{
		server_friend_main sr = new server_friend_main();
	    Server_main selogin = new Server_main();
	    uplinecontr_main upline = new uplinecontr_main();
	    server_saveip_main saveip= new server_saveip_main();
	    ipforall_main server = new ipforall_main();
	    Server_zhuce_main zhuce = new Server_zhuce_main();
	    Search_friends_main friend_serch = new Search_friends_main();
	    
	    
		new Thread(sr).start();
		new Thread(selogin).start();
		new Thread(upline).start();
		new Thread(saveip).start();
		new Thread(server).start();
		new Thread(zhuce).start();
		new Thread(friend_serch).start();
		
	}

}
