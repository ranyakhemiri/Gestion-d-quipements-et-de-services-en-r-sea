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

    // récupérer le nom de l'equipement
    public String getName() throws RemoteException {
        return eq.getName();
    }

    // modifier le nom de l'equipement
    public void setName(String name) throws RemoteException {
        eq.setName(name);
    }

    // récupérer le nom du service
    public String getService() throws RemoteException {
        return eq.getService();
    }

    // modifier le nom du service
    public void setService(String s) throws RemoteException {
        eq.setService(s);
    }

    // récupérer le nom du service
    public String getAddress() throws RemoteException {
        return eq.getAddress();
    }

    // modifier le nom du service
    public void setAddress(String ad) throws RemoteException {
        eq.setAddress(ad);
    }
}