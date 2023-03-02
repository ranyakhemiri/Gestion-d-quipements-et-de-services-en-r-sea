import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TrapClient {
    public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {

        // Recherche dans l'annuaire et transtypage
        TrapInter obj = (TrapInter) Naming.lookup("rmi://localhost:1099/TrapServer");

        // Création de l'ODT
        Equipement e = new Equipement(1, "Routeur", "salle307", "Informatique");
        EquImpl o = new EquImpl(e);
        // Appel de la méthode distante
        String message = obj.trapNom(o);
        // Affichage du résultat
        System.out.println(message);

    }
}
