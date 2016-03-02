package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class server_login_d implements Runnable{
   serverpoint sp;
   
   public server_login_d(serverpoint sp) {
	this.sp = sp;
}


public void run(){
	System.out.println("================线程开始运行==============");
	ResultSet rs =null;
	String str =null;
	int port = 8888;
	int port_zhu =8889;
	

	try {
		String username= sp.datain.readUTF();
		String pass = sp.datain.readUTF();
		System.out.println("服务器收到了来自客户端的用户名===>"+username);
		System.out.println("服务器收到了来自客户端的密码===>"+pass);
		rs = musql_me.mysqlQ(username);
		System.out.println("===============服务器检测数据库信息准备返回数据===============");
		rs.last();
		System.out.println("===============服务器检测数据库信返回的位数信息===============");
		int s = rs.getRow();
		rs.first();
		System.out.println("==================="+s+"====================");
		String pss= rs.getString("password");
		if(s==0)
		{
			sp.dataout.writeInt(0);//0表示错误，没有查到该用户名相对应的密码
			sp.dataout.flush();
		}
		else if(s>1)
		{
			sp.dataout.writeInt(1);//1表示查到多个用户名
			sp.dataout.flush();
			
		}
		else if(pass.equals(pss))
		{
			
		                             //2表示正确，该用户名以及密码匹配
			
			sp.dataout.writeInt(2);
			sp.dataout.flush();
		}
		else
		{
			System.out.println("error         因为"+pss+"!="+pass);
			sp.dataout.writeInt(3);//3表示错误，查到该用户名的密码与输入的不匹配
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
