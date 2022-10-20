import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static char listZeichen[] = {'☺', '#', '♦', '♠', '♥', '♣', '♫', '☼', '©', '☻', '▲', '►', '▼', '◄', '&', '§', '$', '£'};
    static LinkedList<Character> listZeichenGeneratet = new LinkedList();
    static LinkedList<String> listcheck = new LinkedList();
    static int spielfeldGroesse[] = new int[2];
    static int eingaabenCheck[] = new int[4];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            listZeichenGeneratet.clear();
            boolean checkEingabe = true;

            while (checkEingabe) {
                checkEingabe = false;
                try {
                    randomList();
                    spielFeld();
                    while (true) {
                        insertGuess();

                        if (checkWinn() == listcheck.size()){
                            break;
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Ungueltige Eingabe!!!!! Error: " + ex.getMessage());
                    checkEingabe = true;
                    listZeichenGeneratet.clear();
                    listcheck.clear();
                }
            }

        }

    }

    public static void randomList() {
        System.out.println("Was für ein Spielfeld möchtest du? es gibt bis 6:6.");
        System.out.println("gebe z.B. 6:6 ein");
        String eingabegroesse = scanner.nextLine();
        if (eingabegroesse.equals("q")) {
            System.exit(0);
        }
        spielfeldGroesse[0] = Integer.parseInt(String.valueOf(eingabegroesse.charAt(0)));
        spielfeldGroesse[1] = Integer.parseInt(String.valueOf(eingabegroesse.charAt(2)));
        int groesse = spielfeldGroesse[1] * spielfeldGroesse[0] / 2;
        for (int i = 0; i < groesse; i++) {
            listZeichenGeneratet.add(listZeichen[i]);
            listZeichenGeneratet.add(listZeichen[i]);
            listcheck.add("unvisible");
            listcheck.add("unvisible");
            Collections.shuffle(listZeichenGeneratet);

        }
        System.out.println(listZeichenGeneratet);
    }


    public static void spielFeld() {
        for (int i = 0; i <= spielfeldGroesse[0]; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < spielfeldGroesse[1]; i++) {
            eineZeile(i);
        }
    }

    public static void eineZeile(int zeile) {
        System.out.print(zeile + 1 + "\t");
        for (int i = 0; i < spielfeldGroesse[0]; i++) {
            if (listcheck.get(i + zeile * spielfeldGroesse[0]).equals("unvisible")) {
                System.out.print("?" + "\t");
            } else if (listcheck.get(i + zeile * spielfeldGroesse[0]).equals("check")) {
                System.out.print(listZeichenGeneratet.get(i + zeile * spielfeldGroesse[1]) + "\t");
            } else if (listcheck.get(i + zeile * spielfeldGroesse[0]).equals("right")) {
                System.out.print("" + "\t");
            }
        }
        System.out.println();
    }

    public static void insertGuess() {
        System.out.println("Was möchtest du probieren.");
        System.out.println(" z.B. 3:3");
        System.out.println(" z.B. 1:2");
        String insert1 = scanner.nextLine();
        String insert2 = scanner.nextLine();
        eingaabenCheck[0] = Integer.parseInt(String.valueOf(insert1.charAt(0)));
        eingaabenCheck[1] = Integer.parseInt(String.valueOf(insert1.charAt(2)));
        eingaabenCheck[2] = Integer.parseInt(String.valueOf(insert2.charAt(0)));
        eingaabenCheck[3] = Integer.parseInt(String.valueOf(insert2.charAt(2)));
        checkInsertGuess();
    }

    public static void checkInsertGuess() {
        int insert1Position = 0;
        int insert2Position = 0;
        for (int j = 0; j <eingaabenCheck[1]; j++) {
            for (int i = 0; i < eingaabenCheck[0]; i++) {
                insert1Position = i + j*  spielfeldGroesse[0];
            }
        }
        listcheck.set(insert1Position, "check");
        for (int j = 0; j <eingaabenCheck[2]; j++) {
            for (int i = 0; i < eingaabenCheck[3]; i++) {
                insert2Position = j + i *  spielfeldGroesse[0];
            }
        }

        listcheck.set(insert2Position, "check");
        spielFeld();
        if (listZeichenGeneratet.get(insert1Position).equals(listZeichenGeneratet.get(insert2Position))) {
            listcheck.set(insert1Position, "right");
            listcheck.set(insert2Position, "right");
            System.out.println("richtig!!");
        } else {
            listcheck.set(insert1Position, "unvisible");
            listcheck.set(insert2Position, "unvisible");
            System.out.println("leider Falsch!!");
        }
        spielFeld();
    }
    public static int checkWinn(){
        int right=0;
        for (int i = 0; i < listcheck.size(); i++) {
            if (listcheck.get(i).equals("right")){
                right++;
            }
        }
        return right;
    }
}