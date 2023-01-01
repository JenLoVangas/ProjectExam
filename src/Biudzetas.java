import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Biudzetas {
    private final ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
    private final ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();

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
        sc.nextLine();
        String papildomaInfo = sc.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();

        PajamuIrasas p = new PajamuIrasas(suma, pajamuKategorija, dateTime, pozymisArIBanka, papildomaInfo);
        pajamos.add(p);

        System.out.println("Pridetas irasas");
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

        IslaiduIrasas i = new IslaiduIrasas(suma, islaiduKategorija, dateTime, atsiskaitymoBudas, papildomaInfo);
        islaidos.add(i);

        System.out.println("Pridetas irasas");
    }

    public void gautiPajamuIrasa(Scanner sc) {
        System.out.println("Iveskite id");
        String id = sc.next();
        int pId = Integer.parseInt(id);
        int i = 0;
        while (i < pajamos.size()) {
            if (pajamos.get(i).id == pId) {
                PajamuIrasas p = pajamos.get(i);
                System.out.println(p.getDisplayString());
                return;
            }
            i++;
        }
        System.out.println("Irasas nerastas.");
    }

    public void gautiIslaiduIrasa(Scanner sc) {
        System.out.println("Iveskite id");
        String id = sc.next();
        int pId = Integer.parseInt(id);
        int i = 0;
        while (i < islaidos.size()) {
            if (islaidos.get(i).id == pId) {
                IslaiduIrasas p = islaidos.get(i);
                System.out.println(p.getDisplayString());
                return;
            }
            i++;
        }
        System.out.println("Irasas nerastas.");
    }

    public float balansas() {
        float suma = 0;
        for (PajamuIrasas p : pajamos) {
            suma += p.suma;
        }

        for (IslaiduIrasas i : islaidos) {
            suma -= i.suma;
        }

        return suma;
    }

    public void atvaizduotiPajamuIrasus() {
        if (pajamos.size() == 0) {
            System.out.println("Irasu nerasta");
            return;
        }

        for (PajamuIrasas p : pajamos) {
            System.out.println(p.getDisplayString());
        }
    }

    public void atvaizduotiIslaiduIrasus() {
        if (islaidos.size() == 0) {
            System.out.println("Irasu nerasta");
            return;
        }

        for (IslaiduIrasas p : islaidos) {
            System.out.println(p.getDisplayString());
        }
    }

    public void pasalintiPajamuIrasa(Scanner sc) {
        System.out.println("Iveskite id");
        String id = sc.next();
        int pId = Integer.parseInt(id);
        for (int i = 0; i < pajamos.size(); i++) {
            if (pajamos.get(i).id == pId) {
                pajamos.remove(i);
                System.out.println(pId + " irasas pasalintas");
                return;
            }
        }
    }

    public void pasalintiIslaiduIrasa(Scanner sc) {
        System.out.println("Iveskite id");
        String id = sc.next();
        int pId = Integer.parseInt(id);
        for (int i = 0; i < islaidos.size(); i++) {
            if (islaidos.get(i).id == pId) {
                System.out.println(pId + " irasas pasalintas");
                islaidos.remove(i);
                System.out.println(pId + " irasas pasalintas");
                return;
            }
        }
    }
}
