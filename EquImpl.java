import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Scanner;

// dans cette classe, on définit les méthodes abstraites déclarées dans l'interface "EquInter"

public class EquImpl extends UnicastRemoteObject implements EquInter {

    private Equipement e;

    public EquImpl(Equipement eq) throws RemoteException {
        super();
        this.e = eq;
    }

    // ******** SECURITE LA BASE DE DONNEES ********
    // on s'inspire de SNMP et on choisit la notion de community
    // définie de manière permanent et case-sensitive ici
    private String community = "MCPRproject";

    // ******** MANIPULATION DE LA BASE DE DONNEES ********
    // il faut ajouter la vérification de community à chaque manipulation
    // mais on proposera deux types d'accès
    // acces en lecture seulement
    // acces en lecture/ecriture où on demandera le mot de passe par exemple pour
    // modifier un attribut

    public String getName() throws RemoteException {
        return e.getName();
    }

    // modifier le nom de l'equipement
    public void setName(String name, String mdp) throws RemoteException {
        if (mdp == this.community) {
            e.setName(name);
            // this will automatically override the old value
        } else {
            System.out.println("Wrong access! Try again.");
        }
    }

    // récupérer le nom du service
    public String getService() throws RemoteException {
        return e.getServices();
    }

    // modifier le nom du service
    public void setService(String s, String mdp) throws RemoteException {
        e.setService(s);
    }

    // récupérer le nom du service
    public String getAddress() throws RemoteException {
        return e.getAddress();
    }

    // modifier le nom du service
    public void setAddress(String ad, String mdp) throws RemoteException {
        if (mdp == community) {
            e.setAddress(ad);
        } else {
            System.out.println("Wrong access! Try again.");
        }
    }

    public String getNext(int i) {
        if (i == 1) {
            return e.eqHash.get("Name");
        } else if (i == 2) {
            return e.eqHash.get("Service");
        } else if (i == 3) {
            return e.eqHash.get("Address");
        } else
            return e.eqHash.get("Id");
    }
}