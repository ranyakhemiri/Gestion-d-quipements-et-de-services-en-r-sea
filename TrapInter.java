import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrapInter extends Remote {
    public void notify(String msg) throws RemoteException;
}
