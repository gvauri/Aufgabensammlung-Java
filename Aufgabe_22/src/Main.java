import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<String> calculationList = new LinkedList<String>();
    public static void main(String[] args) {
        while (true) {
            String eingabeString = "";
            boolean checkEingabe = true;

            while (checkEingabe) {
                checkEingabe = false;
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Gib eine korrekte Rechnung mit Zahlen ein: ");
                    eingabeString = scanner.nextLine();
                    if (eingabeString.equals("q")){
                        System.exit(0);
                    }
                    convertToInvoice(eingabeString);
                    System.out.println(calculator());
                } catch (Exception ex) {
                    System.out.println("Ungueltige Eingabe!!!!! Error: " + ex.getMessage());
                    checkEingabe = true;
                }
            }

        }
    }

    public static void convertToInvoice(String eingabeString) {
        String calculationWithoutSpace = deleteSpace(eingabeString);
        System.out.println(calculationWithoutSpace);
        fillupLists(calculationWithoutSpace);
    }

    public static String deleteSpace(String eingabeString) {
        String calculationWithoutSpace = "";
        for (int i = 0; i < eingabeString.length(); i++) {
            if (!String.valueOf(eingabeString.charAt(i)).equals(" ")) {
                calculationWithoutSpace += String.valueOf(eingabeString.charAt(i));
            }
        }
        return calculationWithoutSpace;
    }
    public static void  fillupLists(String calculationWithoutSpace){
        String number="";
        for (int i = 0; i < calculationWithoutSpace.length(); i++) {
            if (calculationList.get(i).equals("*")||
                    calculationList.get(i).equals("%")||
                    calculationList.get(i).equals("-")||
                    calculationList.get(i).equals("(")||
                    calculationList.get(i).equals(")")||
                    calculationList.get(i).equals("/"))  {

                calculationList.add(number);
                calculationList.add(String.valueOf(calculationWithoutSpace.charAt(i)));
                number="";

            }else {

                    number+=String.valueOf(calculationWithoutSpace.charAt(i));

            }
            
        }
        calculationList.add(number);

    }
    public static int  calculator(){
        LinkedList<Integer> numberList = new LinkedList<Integer>();
        LinkedList<String> operatorList = new LinkedList<String>();
        for (int i = 0; i < calculationList.size(); i++) {
            System.out.println(calculationList.get(i));
            if (calculationList.get(i).equals("+")||
                    calculationList.get(i).equals("*")||
                    calculationList.get(i).equals("%")||
                    calculationList.get(i).equals("-")||
                    calculationList.get(i).equals("(")||
                    calculationList.get(i).equals(")")||
                    calculationList.get(i).equals("/")) {

                operatorList.add(calculationList.get(i));
            }else {

                    numberList.add(Integer.parseInt(calculationList.get(i)));

            }
        }

        for (int i = 0; i <operatorList.size(); i++) {
            int number=0;
            switch (operatorList.get(i)){
                case "*":
                    number = numberList.get(i) *numberList.get(i+1);
                    numberList.set(i,number);
                    operatorList.remove(i);
                    numberList.remove(i+1);
                    i=0;
                    break;
                case "/":
                    number = numberList.get(i) /numberList.get(i+1);
                    numberList.set(i,number);
                    operatorList.remove(i);
                    numberList.remove(i+1);
                    i=0;
                    break;
                case "%":
                    number = numberList.get(i) %numberList.get(i+1);
                    numberList.set(i,number);
                    operatorList.remove(i);
                    numberList.remove(i+1);
                    i=0;
                    break;
            }
        }
        for (int i = 0; i <operatorList.size(); i++) {
            int number=0;
            switch (operatorList.get(i)){
                case "+":
                    number = numberList.get(i) +numberList.get(i+1);
                    numberList.set(i,number);
                    operatorList.remove(i);
                    numberList.remove(i+1);
                    i=0;
                    break;
                case "-":
                    number = numberList.get(i) -numberList.get(i+1);
                    numberList.set(i,number);
                    operatorList.remove(i);
                    numberList.remove(i+1);
                    i=0;
                    break;
            }
        }
        calculationList.clear();
        return numberList.get(0);

    }
}
