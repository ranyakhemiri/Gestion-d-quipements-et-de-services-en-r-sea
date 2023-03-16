import java.rmi.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.MalformedURLException;

//l'idée est que l'utilisateur aura le choix d'effectuer plusieurs operations 
//qu'on a definit dans les classes relatives aux equipements 
//le client ici gère à distance l'équipement 

public class Client {
    // Agent
    Client() {
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        Scanner sc = new Scanner(System.in);

        // on cherche le chemin de l'annuaire déclaré dans le serveur
        EquInter eq = (EquInter) Naming.lookup("rmi://localhost:1099/equipdape");

        boolean state = true;
        int ind = 0;

        while (state) {
            System.out.println("1. Get name of equipment");
            System.out.println("2. Set name of equipment");
            System.out.println("3. Get address of equipment");
            System.out.println("4. Set address of equipment");
            System.out.println("5. Get service of equipment");
            System.out.println("6. Set service of equipment");
            System.out.println("7. Get next value");
            System.out.println("8. Would you like to subscribe (y) or unsubscribe (n) to name traps?");
            System.out.println("9. Would you like to subscribe (y) or unsubscribe (n) to service traps?");
            System.out.println("10. Would you like to subscribe (y) or unsubscribe (n) to address traps?");
            System.out.println("11. Quit");

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
                        ind += 1;
                        ind = ind % 4;
                        System.out.println(eq.getNext(ind));
                        break;
                    case 8:
                        String answer = sc.nextLine();
                        if (answer.equals("y")) {
                            TrapImpl nameTrap = new TrapImpl();
                            eq.subscribe("name", nameTrap);

                        } else if (answer.equals("n")) {
                            eq.unsubscribe("name");
                        } else {
                            System.out.println("Please answer by y or n!");
                        }
                        break;
                    case 9:
                        String answ = sc.nextLine();
                        if (answ.equals("y")) {
                            TrapImpl sTrap = new TrapImpl();
                            eq.subscribe("service", sTrap);

                        } else if (answ.equals("n")) {
                            eq.unsubscribe("service");
                        } else {
                            System.out.println("Please answer by y or n!");
                        }
                        break;
                    case 10:
                        String ans = sc.nextLine();
                        if (ans.equals("y")) {
                            TrapImpl adTrap = new TrapImpl();
                            eq.subscribe("address", adTrap);

                        } else if (ans.equals("n")) {
                            eq.unsubscribe("address");
                        } else {
                            System.out.println("Please answer by y or n!");
                        }
                        break;
                    case 11:
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