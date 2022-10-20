import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int width;
    static int high;
    static int levelFire;
    static int levelGrow;
    static LinkedList<String> listForest = new LinkedList();
    static String[] allStatic={"B","-","S"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            width =0;
            high =0;
            levelFire =0;
            boolean checkInput = true;
            while (checkInput) {
                checkInput = false;
                try {
                    abfrage();
                    playArray();
                    playField();
                    while (true){
                        Thread.sleep(5000);
                        oneRound();
                        playField();

                    }
                } catch (Exception ex) {
                    System.out.println("Ungueltige Eingabe!!!!! Error: " + ex.getMessage());
                    checkInput = true;
                }
            }

        }

    }
    public static void abfrage(){
        System.out.println("Wie hoch soll der Wald werden?");
        high = Integer.parseInt(scanner.nextLine());
        System.out.println("Wie breit soll der Wald werden?");
        width = Integer.parseInt(scanner.nextLine());
        System.out.println("Wie hoch soll die Wahrscheinlichkeit sein, das er beginnt zubrennen?");
        System.out.println("Gebe eine Zahl zwischen 1 und 10 ein wobei, bei 10 die Wahrscheinlichkeit sehr hoch ist.");
        levelFire = Integer.parseInt(scanner.nextLine());
        System.out.println("Wie hoch soll die Wahrscheinlichkeit sein, dass ein Neuer Baum wächst?");
        System.out.println("Gebe eine Zahl zwischen 1 und 10 ein wobei, bei 10 die Wahrscheinlichkeit sehr hoch ist.");
        levelGrow = Integer.parseInt(scanner.nextLine());
    }
    public static void playField(){
        System.out.println("new status from the forest:");
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(listForest.get(i*width+j));
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void playArray(){
        for (int i = 0; i < high*width; i++) {
            int randomNumber = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            listForest.add(allStatic[randomNumber]);
        }
    }
    public static void oneRound(){
        for (int i = 0; i < listForest.size(); i++) {
            int randomNumber = (int) Math.floor(Math.random() * (15 - 0 + 1) + 0);
            if (listForest.get(i).equals("B")){
                if (randomNumber< levelFire){
                    listForest.set(i,"F");
                }
            } else if (listForest.get(i).equals("F")) {
                listForest.set(i,"f");
                checkFire(i);
            } else if (listForest.get(i).equals("-")) {
                if (randomNumber< levelGrow) {
                    listForest.set(i,"w");
                }
            }else if (listForest.get(i).equals("f")) {
                listForest.set(i,"-");
            }else if (listForest.get(i).equals("w")) {
                listForest.set(i,"B");
            }
        }
    }
    static public void checkFire(int heightFire){
        try {
            if (listForest.get(heightFire+1).equals("B")){
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire-1).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire-width).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire-width-1).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire-width+1).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire+width).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire+width+1).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
        try {
            if (listForest.get(heightFire+width-1).equals("B")) {
                listForest.set(heightFire,"F");
            }
        }catch (Exception ex){}
    }
}