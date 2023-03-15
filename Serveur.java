import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        LocateRegistry.createRegistry(1099);

        Equipement e = new Equipement(3, "Routeur", "salle307", "Informatique");
        EquImpl o = new EquImpl(e);

        Naming.rebind("rmi://localhost:1099/equipdape", o);
    }

}