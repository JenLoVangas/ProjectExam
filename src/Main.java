import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            pradzia();
            String input = sc.next();
            switch (input) {
                case "1" -> biudzetas.pridetiPajamuIrasa(sc);
                case "2" -> biudzetas.pridetiIslaiduIrasa(sc);
                case "3" -> biudzetas.gautiPajamuIrasa(sc);
                case "4" -> biudzetas.gautiIslaiduIrasa(sc);
                case "x" -> run = false;
                default -> System.out.println("Bloga ivestis...");
            }
        }
        sc.close();
    }

    static void pradzia() {
        System.out.println("______________________");
        System.out.println("Pasirinkite:");
        System.out.println(" [1] - prideti pajamu irasa");
        System.out.println(" [2] - prideti islaidu irasa");
        System.out.println(" [3] - gauti pajamu irasa");
        System.out.println(" [4] - gauti islaidu irasa");
        System.out.println(" [x] - pabaiga");
        System.out.println("______________________");
    }
    //good
}


