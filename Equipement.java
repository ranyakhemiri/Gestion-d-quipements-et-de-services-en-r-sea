import java.util.HashMap;

public class Equipement {
    // ******** BASE DE DONNEES ********
    // on choisit de créer une HashMap pour l'equipement
    // on peut aussir choisir de créer un fichier texte en guise de base de données
    public HashMap<String, String> eqHash = new HashMap<>();

    // pour des raisons de sécurité, on laisse les attributs "private"
    // et on crée des getteurs et setteurs
    // qu'on utilisera dans l'implémentation (classe EquImpl)

    // constructeur
    public Equipement(int id, String name, String ad, String s) {
        eqHash.put("Name", name);
        eqHash.put("Address", ad);
        eqHash.put("Service", s);
        eqHash.put("Id", Integer.toString(id));
    }

    // ******* getters *******
    public String getName() {
        return eqHash.get("Name");
    }

    public String getServices() {
        return eqHash.get("Service");
    }

    public String getAddress() {
        return eqHash.get("Address");
    }

    public String getId() {
        return eqHash.get("Id");
    }

    // ******* setters *******

    // on suppose qu'on peut pas changer l'id
    // une fois que l'objet a été créé

    public void setName(String name) {
        eqHash.replace("Name", name);
    }

    public void setAddress(String ad) {
        eqHash.put("Address", ad);
    }

    public void setService(String s) {
        eqHash.put("Service", s);
    }

}
