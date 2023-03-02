import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

// Etape 1 : instancier l'implantation   
// Etape 2 : rendre accessible les services RMI à distance 
// à l'aide de Naming

public class Serveur extends UnicastRemoteObject implements TrapInter {

    public Serveur() throws RemoteException {
        super();
    }

    // methode distante à utiliser: getName
    public String trapNom(EquInter e) throws RemoteException {
        return "The name of the equipment has been changed to " + e.getName();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // Etape 0 : lancer l'annuaire depuis le serveur directement
        // port choisi: 1099
        LocateRegistry.createRegistry(1099);

        // Etape 1: instancier l'imp

        Equipement e = new Equipement(1, "Routeur", "salle307", "Informatique");
        EquImpl o = new EquImpl(e);

        // Etape 2: naming
        Naming.rebind("rmi://localhost:1099/equipdape", o);
        Naming.rebind("rmi://localhost:1099/TrapServer", o);

    }

}