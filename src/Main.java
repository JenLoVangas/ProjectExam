import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        String input;
        while (run) {
            pradzia();
            input = sc.next();
            System.out.println("______________________");
            switch (input) {
                case "1" -> biudzetas.pridetiPajamuIrasa(sc);
                case "2" -> biudzetas.pridetiIslaiduIrasa(sc);
                case "3" -> biudzetas.atvaizduotiPajamuIrasa(sc);
                case "4" -> biudzetas.atvaizduotiIslaiduIrasa(sc);
                case "5" -> System.out.println("Balansas: " + biudzetas.balansas());
                case "6" -> biudzetas.atvaizduotiPajamuIrasus();
                case "7" -> biudzetas.atvaizduotiIslaiduIrasus();
                case "8" -> biudzetas.pasalintiPajamuIrasa(sc);
                case "9" -> biudzetas.pasalintiIslaiduIrasa(sc);
                case "10" -> biudzetas.redaguotiPajamuIrasa(sc);
                case "11" -> biudzetas.redaguotiIslaiduIrasa(sc);
                case "12" -> Failas.issaugotiDuomenis(biudzetas.getIrasai());
                case "13" -> biudzetas.setIrasai(Failas.gautiDuomenis());
                case "x" -> run = false;
                default -> System.out.println("Bloga įvestis...");
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
        System.out.println(" [5] - patikrinti balansa");
        System.out.println(" [6] - atspausdinti pajamu irasus");
        System.out.println(" [7] - atspausdinti islaidu irasus");
        System.out.println(" [8] - pasalinti pajamu irasa");
        System.out.println(" [9] - pasalinti islaidu irasa");
        System.out.println("[10] - redaguoti pajamu irasa");
        System.out.println("[11] - redaguoti islaidu irasa");
        System.out.println("[12] - issaugoti i sarasa");
        System.out.println("[13] - uzkrauti is saraso");
        System.out.println(" [x] - pabaiga");
        System.out.println("______________________");
    }
}


