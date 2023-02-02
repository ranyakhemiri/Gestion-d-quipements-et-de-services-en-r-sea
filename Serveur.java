import java.nio.charset.MalformedInputException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

// Etape 1 : instancier l'implantation   
// Etape 2 : rendre accessible les services RMI à distance 
// à l'aide de Naming

public class Serveur {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        // Etape 0 : lancer l'annuaire depuis le serveur directement 
        // port choisi: 1090
        LocateRegistry.createRegistry(1090);

        //Etape 1: instancier l'imp
        EquImpl obj = new EquImpl();

        //Etape 2: naming 
        Naming.rebind("rmi://localhost:1090/equipdape",obj);
    }

}