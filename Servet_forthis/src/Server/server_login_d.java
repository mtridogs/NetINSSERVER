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
	System.out.println("================�߳̿�ʼ����==============");
	ResultSet rs =null;
	String str =null;
	int port = 8888;
	int port_zhu =8889;
	

	try {
		String username= sp.datain.readUTF();
		String pass = sp.datain.readUTF();
		System.out.println("�������յ������Կͻ��˵��û���===>"+username);
		System.out.println("�������յ������Կͻ��˵�����===>"+pass);
		rs = musql_me.mysqlQ(username);
		System.out.println("===============������������ݿ���Ϣ׼����������===============");
		rs.last();
		System.out.println("===============������������ݿ��ŷ��ص�λ����Ϣ===============");
		int s = rs.getRow();
		rs.first();
		System.out.println("==================="+s+"====================");
		String pss= rs.getString("password");
		if(s==0)
		{
			sp.dataout.writeInt(0);//0��ʾ����û�в鵽���û������Ӧ������
			sp.dataout.flush();
		}
		else if(s>1)
		{
			sp.dataout.writeInt(1);//1��ʾ�鵽����û���
			sp.dataout.flush();
			
		}
		else if(pass.equals(pss))
		{
			
		                             //2��ʾ��ȷ�����û����Լ�����ƥ��
			
			sp.dataout.writeInt(2);
			sp.dataout.flush();
		}
		else
		{
			System.out.println("error         ��Ϊ"+pss+"!="+pass);
			sp.dataout.writeInt(3);//3��ʾ���󣬲鵽���û���������������Ĳ�ƥ��
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
