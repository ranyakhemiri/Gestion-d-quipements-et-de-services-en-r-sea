import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EquInter extends Remote{
public String getName() throws RemoteException; 
public void setName(String name) throws RemoteException; 
public String getService() throws RemoteException; 
public void setService(String s) throws RemoteException; 
public String getAddress() throws RemoteException;
public void setAddress(String ad) throws RemoteException;

}