import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TrapImpl extends UnicastRemoteObject implements TrapInter {

    protected TrapImpl() throws RemoteException {
        super();
    }

    @Override
    public void notify(String msg) throws RemoteException {
        System.out.println("Attention : " + msg);

    }

}
