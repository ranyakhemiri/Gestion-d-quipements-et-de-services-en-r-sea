import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EquInter extends Remote {
    public String getName() throws RemoteException;

    public String setName(String name, String mdp) throws RemoteException;

    public String getService() throws RemoteException;

    public String setService(String s, String mdp) throws RemoteException;

    public String getAddress() throws RemoteException;

    public String setAddress(String ad, String mdp) throws RemoteException;

    public String getNext(int i) throws RemoteException;
}