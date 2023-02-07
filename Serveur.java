import java.net.MalformedURLException;
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
        // port choisi: 1099
        LocateRegistry.createRegistry(1099);

        //Etape 1: instancier l'imp
		Equipement e = new Equipement(1,"Routeur", "salle307" , "Informatique");
        EquImpl obj = new EquImpl(e);

        //Etape 2: naming 
        Naming.rebind("rmi://localhost:1099/equipdape",obj);
    }

}