package Server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;




public class musql_me {
	
static String url ="jdbc:mysql://127.0.0.1:3306/test";
static String name ="root";
static String passwrod = "root";
static String url_comm ="jdbc:mysql://127.0.0.1:3306/comm";
 String nameuser = null;
 String passuser = null;






public static void insertmysql(String username,String password,String nname,String emain) throws Exception
{
	serverpoint sp=null;
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("================׼����ӡ��Ϣ=========================");
	System.out.println();
	
	String sql = "insert into root_key(username,password,nname,email) values('"+username+"','"+password+"','"+nname+"','"+emain+"');";
	System.out.println(sql+"�Ѿ����������ݿ�");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	Statement stmt = (Statement) conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("��������" + rows + "������");
	}
	
}

public static ResultSet mysqlQ(String str) throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select password from root_key where username='"+str+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯ������001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
  
	System.out.println("���ݿ�һ����ȡ�ĸ���Ϊ======>"+rs.getFetchSize());	
	rs.last();
	int s = rs.getRow();
	rs.first();
	System.out.println("=================�����ݿ����ܹ���ȡ������"+s+"����Ϣ=================");
	System.out.println("============׼����ӡ���ݿ������Ϣ=============");
	if(rs.next()!=false)
	while(rs.next())
	{
		//System.out.println(s);
		System.out.print("��ȡ��������Ϣ����ϢΪ"+rs.getString("password"));
		
	}
	else
	{
		System.out.println("û����ȡ������Ϣ"+rs.next());
		
	}
	System.out.println("=============���ݿ���ȡ���==========");
	return rs;
}

public static void updateuponlion(String username) throws Exception
{
	serverpoint sp=null;
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("================׼����ӡ��Ϣ=========================");
	System.out.println();
	
	String sql = "update root_key set online =1 where username ='"+username+"';";
	System.out.println(sql+"�Ѿ����������ݿ�");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	Statement stmt = (Statement) conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("��������" + rows + "������");
	}
	
}
	
	
public static int mysqlQforzhuce(String str) throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select password from root_key where username='"+str+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯ������001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
  
	System.out.println("���ݿ�һ����ȡ�ĸ���Ϊ======>"+rs.getFetchSize());	
	rs.last();
	int s = rs.getRow();
	rs.first();
	System.out.println("=================�����ݿ����ܹ���ȡ������"+s+"����Ϣ=================");
	System.out.println("============׼����ӡ���ݿ������Ϣ=============");
	return s;
}


public static String[] mysqlQforfriend(String str) throws ClassNotFoundException, SQLException//================================
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select friend from root_key where username='"+str+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯ������001======");
	String[] nnames= new String[15];
	String friends=null;
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	
	Statement stmt =  (Statement) conn.createStatement();
	System.out.println("==========  ����������========");
	ResultSet rs = stmt.executeQuery(sql);
	rs.first();
	System.out.println("==========  ����������========sql����û����");
	System.out.println(sql);
	System.out.println(rs.getString(1));
	
    friends = rs.getString(1).toString();
    System.out.println("==========  ����������========");
    String[] friendsline = friends.split(",");
    System.out.println("==========  ����������========");
    System.out.println("friendsline"+friendsline[0]);
    String[] nname =new String[15];//<==============
	for(int l=0;l<friendsline.length;l++)
	{
		nname[l]=mysqlQforfriends(friendsline[l]);
	}
	rs.last();
	int s = rs.getRow();
	rs.first();
	System.out.println("=================�����ݿ����ܹ���ȡ������"+s+"����Ϣ=================");
	System.out.println("============׼����ӡ���ݿ������Ϣ=============");
	System.out.println("=============���ݿ���ȡ���,���������ǳ�==========");
	return nname;
}

public static String mysqlQforfriends(String friend) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select nname from root_key where pid='"+friend+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯ������001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	System.out.println("=============��ѯ��һ��=================");
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("=============��ѯ�ڶ���=================");
	
	rs.first();
	
	String nname = rs.getString("nname");
	
	System.out.print("nname===>"+nname+"friend----------------->"+friend);
	
	return nname;
}


public static String mysqlQforfriendsuplineforone(String friend) throws ClassNotFoundException, SQLException
{
	System.out.println("=========================����ִ�е�mysqlQforfriendsuplineforone======================"+friend);
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select online from root_key where nname='"+friend+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯ������001======");

	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	
	Statement stmt =  (Statement) conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	
	rs.first();
	
    String s = rs.getString("online");
   
	return s;
}

public static void updateip(String username,String ip) throws Exception
{
	serverpoint sp=null;
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("================׼����ӡ��Ϣ========׼����ӡIP��ַ����Ϣ=================");
	System.out.println();
	
	String sql = "update root_key set bip = '"+ip+"' where username ='"+username+"';";
	System.out.println(sql+"�Ѿ����������ݿ�");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	Statement stmt = (Statement) conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("��������" + rows + "�����ݣ�������IP��ַ�����ݴ�ӡ");
	}
	
}
public static String mysqlQforip(String str) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select bip from root_key where nname='"+str+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯIP����������======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
 
	
	
	
	rs.first();
	String s = rs.getString("bip");

	return s;
}

public static int mysqlQforfriendid(String username) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select pid from root_key where username='"+username+"';";//===========!
	System.out.println("========�����Ƿ����������ݿ��ѯ������001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	System.out.println("=============��ѯ��һ��=================");
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("=============��ѯ�ڶ���=================");
	rs.first();
	int ipd = rs.getInt("pid");
	

	return ipd;
}


public static void updataforfriend(String friendsnew,String myusername) throws Exception
{
	serverpoint sp=null;
	Class.forName("com.mysql.jdbc.Driver");

	
	String sql = "update root_key set friend ="+"'"+ myusername+"'"+" where username ='"+friendsnew+"';";
	
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	
	Statement stmt = (Statement) conn.createStatement();
	System.out.println();
	
	
	
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("��������" + rows + "������");
	}
	
}




public static String mysqlformyfriend(String myusername) throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select friend from root_key where username='"+myusername+"';";//===========!
	
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
  
   

	rs.first();
	
   String friends = rs.getString("friend");
	
	
	
	return friends;
}




}
