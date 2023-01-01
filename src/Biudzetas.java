import java.time.LocalDateTime;
import java.util.Scanner;

public class Biudzetas {
    private final PajamuIrasas[] pajamos = new PajamuIrasas[100];
    private int pajamuIndex = 0;
    private final IslaiduIrasas[] islaidos = new IslaiduIrasas[100];
    private int islaiduIndex = 0;

    public void pridetiPajamuIrasa(Scanner sc) {
        System.out.println("Iveskite suma");
        float suma = Patikrinimai.suma(sc);

        System.out.println("Iveskite kategorija");
        sc.nextLine();
        String pajamuKategorija = sc.nextLine();

        System.out.println("Ar i banka?");
        System.out.println("Pasirinkite:");
        System.out.println("[0] - Ne");
        System.out.println("[1] - Taip");
        boolean pozymisArIBanka = Patikrinimai.banko(sc);

        System.out.println("Iveskite papildoma informacija");
        String papildomaInfo = sc.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();

        pajamos[pajamuIndex] = new PajamuIrasas(suma, pajamuKategorija, dateTime, pozymisArIBanka, papildomaInfo);
        pajamuIndex++;

        System.out.println("Pridetas pajamu irasas");
    }

    public void pridetiIslaiduIrasa(Scanner sc) {
        System.out.println("Iveskite suma");
        float suma = Patikrinimai.suma(sc);

        System.out.println("Iveskite kategorija");
        sc.nextLine();
        String islaiduKategorija = sc.nextLine();

        System.out.println("Iveskite Atsiskaitymo buda");
        String atsiskaitymoBudas = sc.nextLine();

        System.out.println("Iveskite papildoma informacija");
        String papildomaInfo = sc.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();

        islaidos[islaiduIndex] = new IslaiduIrasas(suma, islaiduKategorija, dateTime, atsiskaitymoBudas, papildomaInfo);
        islaiduIndex++;

        System.out.println("Pridetas islaidu irasas");
    }

    public void gautiPajamuIrasa(Scanner sc) {
        System.out.println("Iveskite index");
        String index = sc.next();
        int i = Integer.parseInt(index);
        if (i > 100 || pajamos[i] == null) {
            System.out.println("Irasas nerastas");
            return;
        }
        System.out.println(pajamos[i].getDisplayString());
    }

    public void gautiIslaiduIrasa(Scanner sc) {
        System.out.println("Iveskite index");
        String index = sc.next();
        int i = Integer.parseInt(index);
        if (i > 100 || islaidos[i] == null) {
            System.out.println("Irasas nerastas");
            return;
        }
        System.out.println(islaidos[i].getDisplayString());
    }
}
