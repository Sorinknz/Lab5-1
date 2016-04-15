import javax.swing.*;
import java.util.Scanner;

/**
 * Created by icondor on 26/03/16.
 */
public class AgendadeNume {

    /* utility methods for INPUT/OUTPUT using a GUI or Console, please leave them as they are */

    // GUI
    public static int readIntGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        int returnValue = Integer.parseInt(input);
        return returnValue;
    }

    public static double readDoubleGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        double returnValue = Double.parseDouble(input);
        return returnValue;
    }

    public static String readStringGUI(String label) {
        String input = JOptionPane.showInputDialog(null,
                label);
        return input;
    }

    public static void printGUI(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void printGUI(int text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public static void printGUI(double text) {
        JOptionPane.showMessageDialog(null, text);
    }

    // CONSOLE
    public static String readStringConsole(String label) {
        System.out.print(label);
        String input = new Scanner(System.in).nextLine();
        return input;
    }

    public static int readIntConsole(String label) {
        System.out.print(label);
        int input = new Scanner(System.in).nextInt();
        return input;
    }

    public static double readDoubleConsole(String label) {
        System.out.print(label);
        double input = new Scanner(System.in).nextDouble();
        return input;
    }

    public static void printConsole(String text) {
        System.out.println(text);
    }

    public static void printConsole(int text) {
        System.out.println(text);
    }

    public static void printConsole(double text) {
        System.out.println(text);
    }
    /* end of utility methods*/




    static String[] sirdenume = new String[3];
    static int index = 0;

    /* here starts the main class */


    public static void main(String[] arguments) {
        int optiune = 0;


        do {
            printConsole("1 - listare");
            printConsole("2 - adaugare");
            printConsole("3 - stergere");
            printConsole("4 - cautare");
            printConsole("5 - modificare");
            printConsole("6 - exit");
            optiune = readIntConsole("Alegeti un numar:");
            if (optiune == 1)
                listare();
            else if (optiune == 2) {
                String v = readStringConsole("Numele:");
                crearefaraduplicate2(v);
                if (index == sirdenume.length) {
                    System.out.println("Agenda este plina");
                }

            } else if (optiune == 3) {
                String v = readStringConsole("Numele");
                stergere(v);
            } else if (optiune == 4) {
                int r = cautare(readStringConsole("Numele"));
                System.out.println("Numele a fost gasit pe pozitia:" + r + " a agendei");
            } else if (optiune == 5) {
                String v = readStringConsole("Numele");
                modificare(v);
            } else {
                break;
            }
            //listare
            //acasa modificare
            //acasa stergere
            //cautare
            //acasa exit
            //while exit
        }
        while (optiune != 7);
    }


    public static void listare() {
        for (int i = 0; i < sirdenume.length; i++) {
            if (sirdenume[i] != null) {
                printConsole(sirdenume[i]);
            }
        }
    }

    public static void creare(String valoare) {
        sirdenume[index] = valoare;
        index++;
    }
    public static void crearefaraduplicate(String valoare) {
        int i = cautare(valoare);
        if (i == -1 || index == 0) { //negasita, deci scrieo
            sirdenume[index] = valoare;
            index++;
        } else {
            System.out.println("deja exista");
        }
    }

    public static void crearefaraduplicate2(String valoare) {
        if (index < sirdenume.length) {
            crearefaraduplicate(valoare);
        } else {
            for (int i = 0; i < sirdenume.length; i++) {
                if (sirdenume[i] == null || sirdenume[i].equals("-")) {
                    sirdenume[i] = valoare;
                    break;
                } else if (i == sirdenume.length - 1) {
                    printConsole("Adaugare imposibila!");
                    break;
                }
            }
        }
    }


    public static int cautare(String valoare) {
        int r = -1; // negasit
        for (int i = 0; i < sirdenume.length; i++) {
            if (valoare.equals(sirdenume[i])) {
                r = i; //gasit pe pozitia i
                break;
            }
        }
        return r;
    }

    public static void stergere(String valoare) {
        for (int i = 0; i < sirdenume.length; i++) {
            if (valoare.equals(sirdenume[i])) {
                sirdenume[i] = null;
            }
        }
    }

    public static void modificare(String valoare) {
        for (int i = 0; i < sirdenume.length; i++) {
            if (valoare.equals(sirdenume[i])) {
                sirdenume[i] = readStringConsole("Noul nume:");
            }
        }
    }
}
//end of main method
// end of class
