import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EquInter extends Remote {
    public String getName() throws RemoteException;

    public void setName(String name, String mdp) throws RemoteException;

    public String getService() throws RemoteException;

    public void setService(String s, String mdp) throws RemoteException;

    public String getAddress() throws RemoteException;

    public void setAddress(String ad, String mdp) throws RemoteException;

    public String getNext() throws RemoteException;
}