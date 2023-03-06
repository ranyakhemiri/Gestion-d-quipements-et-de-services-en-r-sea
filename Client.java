import java.rmi.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.MalformedURLException;

//l'idée est que l'utilisateur aura le choix d'effectuer plusieurs operations 
//qu'on a definit dans les classes relatives aux equipements 
//le client ici gère à distance l'équipement 

public class Client {
    Client() {
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        // pour pouvoir taper un choix à partir du clavier
        Scanner sc = new Scanner(System.in);

        // on cherche le chemin de l'annuaire déclaré dans le serveur
        EquInter eq = (EquInter) Naming.lookup("rmi://localhost:1099/equipdape");

        // pour garder le menu affiché
        boolean state = true;

        // indice pour le getNext pour connaitre la position du
        int ind = 0;

        // boucle du menu
        while (state) {
            System.out.println("1. Get name of equipment");
            System.out.println("2. Set name of equipment");
            System.out.println("3. Get address of equipment");
            System.out.println("4. Set address of equipment");
            System.out.println("5. Get service of equipment");
            System.out.println("6. Set service of equipment");
            System.out.println("7. Get next value");
            System.out.println("8. Quit");
            // on implemente un try/catch au cas de mauvais input de la part de
            // l'utilisateur
            // car le format obligatoire est un entier
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("The name of the equipment is : ");
                        System.out.println(eq.getName());
                        break;
                    case 2:
                        System.out.println("Enter new name : ");
                        String new_name = sc.nextLine();
                        System.out.println("Enter password for access : ");
                        String psswd2 = sc.nextLine();
                        System.out.println(eq.setName(new_name, psswd2));
                        break;
                    case 3:
                        System.out.println("The address of the equipment is : ");
                        System.out.println(eq.getAddress());
                        break;
                    case 4:
                        System.out.println("Enter new address : ");
                        String new_add = sc.nextLine();
                        System.out.println("Enter password for access : ");
                        String psswd4 = sc.nextLine();
                        System.out.println(eq.setAddress(new_add, psswd4));
                        break;
                    case 5:
                        System.out.println("The service of the equipment is : ");
                        System.out.println(eq.getService());
                        break;
                    case 6:
                        System.out.println("Enter new service : ");
                        String new_service = sc.nextLine();
                        System.out.println("Enter password for access : ");
                        String psswd6 = sc.nextLine();
                        System.out.println(eq.setService(new_service, psswd6));
                        System.out.println("");
                        break;
                    case 7:
                        // a chaque appel de getnext, on incremente l'indice ind
                        // par contre, il faut le diviser par 4 parce qu'on a 4 clés au total a
                        // parcourir
                        // apres on refait le parcours depuis le début (comme une boucle)
                        ind += 1;
                        ind = ind % 4;
                        System.out.println(eq.getNext(ind));
                        break;
                    case 8:
                        state = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input type.");
                sc.next();
            }
        }
        sc.close();

    }
}