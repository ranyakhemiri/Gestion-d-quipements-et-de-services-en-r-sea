import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EquImpl extends UnicastRemoteObject implements EquInter {

    private Equipement e;

    public EquImpl(Equipement eq) throws RemoteException {
        super();
        this.e = eq;
    }

    protected String community = "MCPRproject";
    private boolean trap;

    public String getName() throws RemoteException {
        return e.getName();
    }

    // modifier le nom de l'equipement
    public String setName(String name, String mdp) throws RemoteException {
        String old_name = e.getName();
        String new_name = name;
        if (mdp.equals(this.community)) {
            e.setName(name);
            if (trap) {
                return "NOTIFICATION : The name changed from " + old_name + "to : " + new_name;

            } else
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
        if (mdp.equals(this.community)) {
            e.setService(s);
            if (trap) {
                return "NOTIFICATION : The service changed from " + old_service + "to : " + s;
            } else
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
            if (trap) {
                return "NOTIFICATION : The address changed from " + old_address + "to : " + ad;
            } else
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

    public void subscribe() {
        this.trap = true;
    }

    public void unsubscribe() {
        this.trap = false;
    }

}