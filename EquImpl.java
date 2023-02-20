import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

// dans cette classe, on définit les méthodes abstraites déclarées dans l'interface "EquInter"

public class EquImpl extends UnicastRemoteObject implements EquInter {

    // on instancie un equipement "eq"
    private Equipement eq;

    // ******** BASE DE DONNEES ********
    // on choisit de créer une HashMap pour l'equipement
    // on peut aussir choisir de créer un fichier texte en guise de base de données
    private HashMap<String, String> eqHash = new HashMap<>();

    public EquImpl(Equipement eq) throws RemoteException {
        super();
        this.eq = eq;
        eqHash.put("Name", eq.getName());
        eqHash.put("Address", eq.getAddress());
        eqHash.put("Service", eq.getService());
        eqHash.put("Id", Integer.toString(eq.getId()));
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
        return eq.getName();
    }

    // modifier le nom de l'equipement
    public void setName(String name, String mdp) throws RemoteException {
        if (mdp == community) {
            eq.setName(name);
        } else {
            System.out.println("Wrong access! Try again.");
        }
    }

    // récupérer le nom du service
    public String getService() throws RemoteException {
        return eq.getService();
    }

    // modifier le nom du service
    public void setService(String s, String mdp) throws RemoteException {
        if (mdp == community) {
            eq.setService(s);
        } else {
            System.out.println("Wrong access! Try again.");
        }

    }

    // récupérer le nom du service
    public String getAddress() throws RemoteException {
        return eq.getAddress();
    }

    // modifier le nom du service
    public void setAddress(String ad, String mdp) throws RemoteException {
        if (mdp == community) {
            eq.setAddress(ad);
        } else {
            System.out.println("Wrong access! Try again.");
        }
    }
}