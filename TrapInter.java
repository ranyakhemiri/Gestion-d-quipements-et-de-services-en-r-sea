import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrapInter extends Remote {
    public String trapNom(EquInter e) throws RemoteException;
}
