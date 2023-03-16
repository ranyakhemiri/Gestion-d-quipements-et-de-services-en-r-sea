import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class EquImpl extends UnicastRemoteObject implements EquInter {

    private Equipement e;

    public EquImpl(Equipement eq) throws RemoteException {
        super();
        this.e = eq;
    }

    protected String community = "MCPRproject";

    public String getName() throws RemoteException {
        return e.getName();
    }

    // modifier le nom de l'equipement
    public String setName(String name, String mdp) throws RemoteException {
        String old_name = e.getName();
        String new_name = name;
        if (mdp.equals(this.community)) {
            e.setName(name);
            // si abonné aux trap nom :
            if (e.traps.containsKey("name")) {
                String msg = "Le nom a changé de " + old_name + " a " + new_name;
                e.traps.get("name").notify(msg);
            }
            return "Opération réussie";
        }
        return "Wrong access! Try again.";
    }

    // récupérer le nom du service
    public String getService() throws RemoteException {
        return e.getServices();
    }

    // modifier le nom du service
    public String setService(String s, String mdp) throws RemoteException {
        String old_service = e.getServices();
        String new_s = s;
        if (mdp.equals(this.community)) {
            e.setService(s);
            if (e.traps.containsKey("service")) {
                String msg = "Le service a changé de " + old_service + " a " + new_s;
                e.traps.get("service").notify(msg);
            }
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
        String old_address = e.getAddress();
        if (mdp.equals(this.community)) {
            e.setAddress(ad);
            if (e.traps.containsKey("address")) {
                String msg = " l adresse a changé de " + old_address + " a " + ad;
                e.traps.get("address").notify(msg);
            }
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

    public void subscribe(String type, TrapInter trap) {
        e.addTrap(type, trap);
    }

    public void unsubscribe(String type) {
        e.removeTrap(type);
    }
}