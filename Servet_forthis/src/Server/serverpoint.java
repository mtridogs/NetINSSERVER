package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.ResultSet;

public class serverpoint {
public DataOutputStream dataout =null;
public DataInputStream datain = null;
public Socket so= null;
public ResultSet rs =null;


public serverpoint(DataOutputStream dataout,DataInputStream datain,Socket so)
{
this.dataout = dataout;
this.datain = datain;
this.so = so;

}

public DataOutputStream getDataout() {
	return dataout;
}

public void setDataout(DataOutputStream dataout) {
	this.dataout = dataout;
}

public DataInputStream getDatain() {
	return datain;
}

public void setDatain(DataInputStream datain) {
	this.datain = datain;
}

public Socket getSo() {
	return so;
}

public void setSo(Socket so) {
	this.so = so;
}

	
	
	
}
