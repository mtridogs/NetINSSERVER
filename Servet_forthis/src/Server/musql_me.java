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
	System.out.println("================准备打印信息=========================");
	System.out.println();
	
	String sql = "insert into root_key(username,password,nname,email) values('"+username+"','"+password+"','"+nname+"','"+emain+"');";
	System.out.println(sql+"已经被插入数据库");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	Statement stmt = (Statement) conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("您增加了" + rows + "行数据");
	}
	
}

public static ResultSet mysqlQ(String str) throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select password from root_key where username='"+str+"';";//===========!
	System.out.println("========这里是服务器的数据库查询处理函数001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
  
	System.out.println("数据库一次提取的个数为======>"+rs.getFetchSize());	
	rs.last();
	int s = rs.getRow();
	rs.first();
	System.out.println("=================从数据库里总共提取出来了"+s+"个信息=================");
	System.out.println("============准备打印数据库提出信息=============");
	if(rs.next()!=false)
	while(rs.next())
	{
		//System.out.println(s);
		System.out.print("提取出来了信息，信息为"+rs.getString("password"));
		
	}
	else
	{
		System.out.println("没有提取出来信息"+rs.next());
		
	}
	System.out.println("=============数据库提取完毕==========");
	return rs;
}

public static void updateuponlion(String username) throws Exception
{
	serverpoint sp=null;
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("================准备打印信息=========================");
	System.out.println();
	
	String sql = "update root_key set online =1 where username ='"+username+"';";
	System.out.println(sql+"已经被插入数据库");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	Statement stmt = (Statement) conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("您增加了" + rows + "行数据");
	}
	
}
	
	
public static int mysqlQforzhuce(String str) throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select password from root_key where username='"+str+"';";//===========!
	System.out.println("========这里是服务器的数据库查询处理函数001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
  
	System.out.println("数据库一次提取的个数为======>"+rs.getFetchSize());	
	rs.last();
	int s = rs.getRow();
	rs.first();
	System.out.println("=================从数据库里总共提取出来了"+s+"个信息=================");
	System.out.println("============准备打印数据库提出信息=============");
	return s;
}


public static String[] mysqlQforfriend(String str) throws ClassNotFoundException, SQLException//================================
{
	
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select friend from root_key where username='"+str+"';";//===========!
	System.out.println("========这里是服务器的数据库查询处理函数001======");
	String[] nnames= new String[15];
	String friends=null;
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	
	Statement stmt =  (Statement) conn.createStatement();
	System.out.println("==========  我们在这里========");
	ResultSet rs = stmt.executeQuery(sql);
	rs.first();
	System.out.println("==========  我们在这里========sql提问没问题");
	System.out.println(sql);
	System.out.println(rs.getString(1));
	
    friends = rs.getString(1).toString();
    System.out.println("==========  我们在这里========");
    String[] friendsline = friends.split(",");
    System.out.println("==========  我们在这里========");
    System.out.println("friendsline"+friendsline[0]);
    String[] nname =new String[15];//<==============
	for(int l=0;l<friendsline.length;l++)
	{
		nname[l]=mysqlQforfriends(friendsline[l]);
	}
	rs.last();
	int s = rs.getRow();
	rs.first();
	System.out.println("=================从数据库里总共提取出来了"+s+"个信息=================");
	System.out.println("============准备打印数据库提出信息=============");
	System.out.println("=============数据库提取完毕,返回所有昵称==========");
	return nname;
}

public static String mysqlQforfriends(String friend) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select nname from root_key where pid='"+friend+"';";//===========!
	System.out.println("========这里是服务器的数据库查询处理函数001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	System.out.println("=============查询第一次=================");
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("=============查询第二次=================");
	
	rs.first();
	
	String nname = rs.getString("nname");
	
	System.out.print("nname===>"+nname+"friend----------------->"+friend);
	
	return nname;
}


public static String mysqlQforfriendsuplineforone(String friend) throws ClassNotFoundException, SQLException
{
	System.out.println("=========================程序执行到mysqlQforfriendsuplineforone======================"+friend);
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select online from root_key where nname='"+friend+"';";//===========!
	System.out.println("========这里是服务器的数据库查询处理函数001======");

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
	System.out.println("================准备打印信息========准备打印IP地址的信息=================");
	System.out.println();
	
	String sql = "update root_key set bip = '"+ip+"' where username ='"+username+"';";
	System.out.println(sql+"已经被插入数据库");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);
	Statement stmt = (Statement) conn.createStatement();
	int rows = stmt.executeUpdate(sql);
	
	if (rows > 0) {
		System.out.println("您增加了" + rows + "行数据，这里是IP地址的数据打印");
	}
	
}
public static String mysqlQforip(String str) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.jdbc.Driver");
	String sql = "select bip from root_key where nname='"+str+"';";//===========!
	System.out.println("========这里是服务器的数据库查询IP反馈处理函数======");
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
	System.out.println("========这里是服务器的数据库查询处理函数001======");
	Connection conn = (Connection) DriverManager.getConnection(url_comm,name,passwrod);//========!
	Statement stmt =  (Statement) conn.createStatement();
	System.out.println("=============查询第一次=================");
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("=============查询第二次=================");
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
		System.out.println("您增加了" + rows + "行数据");
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
