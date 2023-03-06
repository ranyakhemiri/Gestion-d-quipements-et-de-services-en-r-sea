import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    protected String community = "MCPRproject";

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
    public String setName(String name, String mdp) throws RemoteException {
        if (mdp.equals(this.community)) {
            e.setName(name);
            return "Opération réussie";
        } else {
            return "Wrong access! Try again.";
        }
    }

    // récupérer le nom du service
    public String getService() throws RemoteException {
        return e.getServices();
    }

    // modifier le nom du service
    public String setService(String s, String mdp) throws RemoteException {
        if (mdp.equals(this.community)) {
            e.setService(s);
            return "Opération réussie";
        } else {
            return "Wrong access! Try again.";
        }
    }

    // récupérer l'adresse
    public String getAddress() throws RemoteException {
        return e.getAddress();
    }

    // modifier l'adresse
    public String setAddress(String ad, String mdp) throws RemoteException {
        if (mdp.equals(this.community)) {
            e.setAddress(ad);
            return "Opération réussie";

        } else {
            return "Wrong access! Try again.";
        }
    }

    public String getNext(int i) {
        if (i == 1) {
            return "Name:  " + e.eqHash.get("Name");
        } else if (i == 2) {
            return "Service:  " + e.eqHash.get("Service");
        } else if (i == 3) {
            return "Address:  " + e.eqHash.get("Address");
        } else
            return "Id:  " + e.eqHash.get("Id");
    }

}