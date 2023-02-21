import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class test {
    private int i;

    public test() {
        this.i = 0;
    }

    public String getNext() {
        try {
            Scanner myReader = new Scanner(new File("db.txt"));
            int j = 0;
            while (myReader.hasNextLine() && (j < i)) {
                String data = myReader.nextLine();
                j = j + 1;
                if (j == i) {
                    System.out.println(data);
                }
                this.i = i + 1;
            }
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws RemoteException {
        Equipement e = new Equipement(1, "A", "A", "A");
        EquImpl eq = new EquImpl(e);
        test t = new test()
        System.out.println(eq.getName());
        eq.setName("C", "MCPRprject");
        System.out.println(eq.getName());
        System.out.println(test.getNext());
    }

}
