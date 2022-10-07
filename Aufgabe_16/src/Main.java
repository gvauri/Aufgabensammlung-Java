import java.util.Scanner;

public class Main {
    static int[] listVocalTimesused=new int[9];
    static String[] listVocal={"a", "e", "i", "o", "u", "ä", "ö", "ü","è"};
    public static void main(String[] args) {
        String eingabeString = "";
        boolean checkEingabe = true;

        while (checkEingabe) {
            checkEingabe = false;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Deine Eingabe:");
                eingabeString = scanner.nextLine();

            } catch (Exception ex) {
                System.out.println("Ungueltige Eingab!!!!! Error: " + ex.getMessage());
                checkEingabe = true;
            }

        }
        ueberpruefung(eingabeString);
        print();

    }

    public static void ueberpruefung(String eingabeString) {
        for (int j = 0; j < eingabeString.length(); j++) {
            for (int i = 0; i < listVocal.length; i++) {
                if (String.valueOf(eingabeString.charAt(j)).equals(listVocal[i])){
                    listVocalTimesused[i]++;
                }
            }
        }
    }
    public static void print() {
        int anzVokale=0;

        for (int i = 0; i < listVocal.length; i++) {
            if (listVocalTimesused[i]>0) {
                System.out.println("Der Buchstabe '"+listVocal[i]+"' kommt "+listVocalTimesused[i]+" mal vor");
                anzVokale+=listVocalTimesused[i];
            }
        }
        System.out.println("Dein Text hat: "+anzVokale+" Vokale");
    }
}
