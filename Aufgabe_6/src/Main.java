import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie weit moechtest du rennen in Km?");
        int rennDistanz = Integer.parseInt(scanner.nextLine());
        String bereit="";
        double bahnenRunden=0;
        if (rennDistanz > 42){
            System.out.println("Das schaffst du nicht");
        }else {
            bahnenRunden = rennDistanz/0.4;
            System.out.println("Das sind "+bahnenRunden+" Runden. Bereit fuer den Lauf. mit yes Bestaetigen!!!!!");
            bereit = scanner.nextLine();
        }
        if (bereit.equals("yes")) {
            for (int i = 1; i <= bahnenRunden; ) {
                System.out.println("Du laeufst Runde"+i);
                i++;

            }
            System.out.println("Du hast es geschaft.");
        }
    }
}
