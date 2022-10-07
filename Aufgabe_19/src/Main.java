import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String[][]morseUbersetzung={
            {"a","  · −  "},
            {"b","  − · · ·  "},
            {"c","  − · − ·  "},
            {"d","  − · ·  "},
            {"e","  ·  "},
            {"f","  · · − ·  "},
            {"g","  − − ·  "},
            {"h","  · · · ·  "},
            {"i","  · ·  "},
            {"j","  · − − −  "},
            {"k","  − · −  "},
            {"l","  · − · ·  "},
            {"m","  − −  "},
            {"n","  − ·  "},
            {"o","  − − −  "},
            {"p","  · − − ·  "},
            {"q","  − − · −  "},
            {"r","  · − ·  "},
            {"s","  · · ·  "},
            {"t","  −  "},
            {"u","  · · −  "},
            {"v","  · · · −  "},
            {"w","  · − −  "},
            {"x","  − · · −  "},
            {"y","  − · − −  "},
            {"z","  − − · ·  "},
    };
    public static void main(String[] args) {
        String eingabeString = "";
        boolean checkEingabe = true;

        while (checkEingabe) {
            checkEingabe = false;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Gib einen Text ein: ");
                eingabeString = scanner.nextLine().toLowerCase();
            } catch (Exception ex) {
                System.out.println("Ungueltige Eingab!!!!! Error: " + ex.getMessage());
                checkEingabe = true;
            }
        }
        System.out.println("Deine Eingabe eist Uebersetzt in Morsecode: " + convertToMorse(eingabeString));


    }
    public static String convertToMorse(String eingabeString){
        String morseString="";
        for (int j = 0; j < eingabeString.length(); j++) {
            for (int i = 0; i < morseUbersetzung.length; i++) {
                if (String.valueOf(eingabeString.charAt(j)).equals(morseUbersetzung[i][0])){
                    morseString+=morseUbersetzung[i][1];
                }
            }
        }

        return morseString;
    }

}