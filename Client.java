import java.rmi.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.MalformedURLException;

//l'idée est que l'utilisateur aura le choix d'effectuer plusieurs operations 
//qu'on a definit dans les classes relatives aux equipements 
//le client ici gère à distance l'équipement 

public class Client{
    Client(){
        
    }
    public static void main (String[] args) throws MalformedURLException, RemoteException, NotBoundException{
        //pour pouvoir taper un choix à partir du clavier 
        Scanner sc= new Scanner(System.in);

        //on cherche le chemin de l'annuaire déclaré dans le serveur
        EquInter eq = (EquInter)Naming.lookup("rmi://localhost:1099/equipdape");
        
        boolean state = true;
        
        //boucle du menu
        while (state){
            System.out.println("1. Get name of equipment");
            System.out.println("2. Set name of equipment");
            System.out.println("3. Get address of equipment");
            System.out.println("4. Set address of equipment");
            System.out.println("5. Get service of equipment");
            System.out.println("6. Set service of equipment");
            System.out.println("7. Quit");
        

        //on implemente un try/catch au cas de mauvais input de la part de l'utilisateur
        //car le format obligatoire est un entier 
        try {
            int choice = sc.nextInt(); 
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.println("The name of the equipment is : ");
                    System.out.println(eq.getName());
                    break;
                case 2:
                    System.out.println("Enter new name : ");
                    String new_name = sc.nextLine();
                    eq.setName(new_name);
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("The address of the equipment is : ");
                    System.out.println(eq.getAddress());
                    break;
                case 4:
                    System.out.println("Enter new address : ");
                    String new_add = sc.nextLine();
                    eq.setAddress(new_add);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("The service of the equipment is : ");
                    System.out.println(eq.getService());
                    break;
                case 6:
                    System.out.println("Enter new service : ");
                    String new_service = sc.nextLine();
                    eq.setService(new_service);
                    System.out.println("");
                    break;
                case 7:
                    state=false;
                    break;

            }
        } 
        catch (InputMismatchException e){
            System.out.println("Wrong input type.");
            sc.next();
        	}
        }
        sc.close();
        
    }
}