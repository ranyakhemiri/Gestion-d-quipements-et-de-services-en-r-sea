import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

// Etape 1 : instancier l'implantation   
// Etape 2 : rendre accessible les services RMI à distance 
// à l'aide de Naming

public class Serveur {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // Etape 0 : lancer l'annuaire depuis le serveur directement
        // port choisi: 1099
        LocateRegistry.createRegistry(1099);

        // Etape 1: instancier l'imp
        // a- creer la base de donnée
        try {
            File Obj = new File("db.txt");
            if (Obj.createNewFile()) {
                System.out.println("File created: "
                        + Obj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        // b- ajouter un equipement a la base de donnée
        Equipement e = new Equipement(2, "Routeur", "salle307", "Informatique");
        EquImpl o = new EquImpl(e);

        try {
            FileWriter Writer = new FileWriter("db.txt", true);
            BufferedWriter bw = new BufferedWriter(Writer);
            bw.newLine();
            bw.write("Id:" + e.getId() + "Name:" + e.getName() + ":Service:" + e.getServices() + ":Address:"
                    + e.getAddress());

            bw.close();
            System.out.println("Successfully added equipement.");
        } catch (IOException ex) {
            System.out.println("An error has occurred.");
            ex.printStackTrace();
        }

        // Etape 2: naming
        Naming.rebind("rmi://localhost:1099/equipdape", o);
    }

}