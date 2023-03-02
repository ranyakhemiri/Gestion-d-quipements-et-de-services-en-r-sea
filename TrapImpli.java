import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class TrapImpli extends UnicastRemoteObject implements TrapInter {

    public TrapImpli() throws RemoteException {
        super();
    }

    // methode distante à utiliser: getName
    public String trapNom(EquInter e) throws RemoteException {
        return "The name of the equipment has been changed to " + e.getName();
    }

    public static void main(String args[]) throws Exception {
        // Démarre le rmiregistry
        LocateRegistry.createRegistry(1099);
        // Crée l'objet Serveur
        TrapImpli obj = new TrapImpli();
        // Nomme l'objet Serveur
        Naming.rebind("TrapServer", obj);
        System.out.println("TrapServer déclaré auprès du serveur de noms");
    }
}
