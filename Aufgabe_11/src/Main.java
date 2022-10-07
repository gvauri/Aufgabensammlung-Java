import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double eingegebeneZahl = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Gebe eine ganze Zahl ein!");
            eingegebeneZahl = Double.parseDouble(scanner.nextLine());
            if (eingegebeneZahl % 1 == 0) {
                break;
            } else {
                System.out.println("error 300000");
            }
        }
        double sum = 0;
        while (true) {
            if (eingegebeneZahl != 0) {
                sum = sum + (eingegebeneZahl % 10);
                eingegebeneZahl = eingegebeneZahl / 10;
            }else {
                break;
            }
        }
        System.out.println("Die Quersumme ist:"+sum);
    }
}
