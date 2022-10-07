import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int laengeLinie=0;
        boolean checkEingabe=true;

        while (checkEingabe){
            checkEingabe=false;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wie lange soll die Linie werden?");
                laengeLinie = scanner.nextInt();

            }catch (Exception ex){
                System.out.println("Ungueltige Eingab!!!!! Error: "+ex.getMessage());
                checkEingabe=true;
            }

        }
        diagonaleLinieErstellen(laengeLinie);

    }

    public static void eineZeile(int anzSterneVor, int anzSterneHin) {
        for (int a = 0; anzSterneVor > a; ++a) {
            System.out.print("*");
        }
        System.out.print(" ");
        for (int i = 0; anzSterneHin>i; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void diagonaleLinieErstellen(int laengeLinie) {
        for (int j = 0; j <  laengeLinie; j++) {
            eineZeile(j,laengeLinie-j-1);
        }
    }

}
