import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Wie hoch soll die Tannenbaum Krone werden?");
        int hoeheBaumKrone = myScanner.nextInt();

        System.out.println("Wie breit soll der Stamm werden?");
        int breiteStamm = myScanner.nextInt();

        System.out.println("Wie hoch soll der Stamm werden?");
        int hoeheStamm = myScanner.nextInt();


        int breiteleerschlag = hoeheBaumKrone;
        baumKrone(breiteleerschlag, hoeheBaumKrone);

        baumStamm(hoeheStamm,breiteStamm,breiteleerschlag);
    }

    public static void eineZeile(int lehrschlaege, int anzSterne) {
        for (int a = 0; lehrschlaege > a; ++a) {
            System.out.print(" ");
        }
        for (int i = 0; anzSterne>i; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void baumStamm(int laengeBaumstamm,int breiteBaumstamm, int breiteleerschlag) {
        for (int j = 0; j <  laengeBaumstamm; j++) {
            eineZeile(breiteleerschlag - 1 - breiteBaumstamm/2,breiteBaumstamm);
        }
    }

    public static void baumKrone(int breiteleerschlag, int hoeheBaumKrone) {
        for (int i = 1; i < hoeheBaumKrone + 1; i++) {

            eineZeile(breiteleerschlag - i,i*2-1);

        }
    }
}
