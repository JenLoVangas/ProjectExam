import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {
    private final ArrayList<Irasas> irasai = new ArrayList<>();

    public void pridetiIrasa(Irasas irasas) {
        irasai.add(irasas);
    }

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
        pridetiIrasa(p);

        System.out.println("Pridetas irasas");
    }

    public void pridetiIslaiduIrasa(Scanner sc) {
        System.out.println("Iveskite suma");
        float suma = Patikrinimai.suma(sc);

        System.out.println("Iveskite kategorija");
        sc.nextLine();
        String islaiduKategorija = sc.nextLine();

        System.out.println("Iveskite Atsiskaitymo buda");
        String atsiskaitymoBudas = sc.next();

        System.out.println("Iveskite papildoma informacija");
        sc.nextLine();
        String papildomaInfo = sc.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();

        IslaiduIrasas i = new IslaiduIrasas(suma, islaiduKategorija, dateTime, atsiskaitymoBudas, papildomaInfo);
        pridetiIrasa(i);

        System.out.println("Pridetas irasas");
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasus() {
        ArrayList<PajamuIrasas> list = new ArrayList<>();
        for (Irasas i : irasai) {
            if (i instanceof PajamuIrasas) {
                list.add((PajamuIrasas) i);
            }
        }
        return list;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
        ArrayList<IslaiduIrasas> list = new ArrayList<>();
        for (Irasas i : irasai) {
            if (i instanceof IslaiduIrasas) {
                list.add((IslaiduIrasas) i);
            }
        }
        return list;
    }

    public void atvaizduotiPajamuIrasa(Scanner sc) {
        PajamuIrasas irasas = gautiPajamuIrasa(sc);
        if (irasas != null) System.out.println(irasas.getDisplayString());
    }

    public PajamuIrasas gautiPajamuIrasa(Scanner sc) {
        int id = getItem(sc);
        Irasas irasas = irasai.get(id);
        if (id != -1 && irasas instanceof PajamuIrasas) {
            return (PajamuIrasas) irasas;
        }
        System.out.println("Irasas nerastas");
        return null;
    }

    public void atvaizduotiIslaiduIrasa(Scanner sc) {
        IslaiduIrasas irasas = gautiIslaiduIrasa(sc);
        if (irasas != null) System.out.println(irasas.getDisplayString());
    }

    public IslaiduIrasas gautiIslaiduIrasa(Scanner sc) {
        int id = getItem(sc);
        Irasas irasas = irasai.get(id);
        if (id != -1 && irasas instanceof IslaiduIrasas) {
            return (IslaiduIrasas) irasas;
        }
        System.out.println("Irasas nerastas");
        return null;
    }

    public float balansas() {
        float suma = 0;
        for (PajamuIrasas p : gautiPajamuIrasus()) {
            suma += p.suma;
        }

        for (IslaiduIrasas i : gautiIslaiduIrasus()) {
            suma -= i.suma;
        }

        return suma;
    }

    public void atvaizduotiPajamuIrasus() {
        ArrayList<PajamuIrasas> pajamos = gautiPajamuIrasus();
        if (pajamos.size() == 0) {
            System.out.println("Irasu nerasta");
            return;
        }

        for (PajamuIrasas p : pajamos) {
            System.out.println(p.getDisplayString());
        }
    }

    public void atvaizduotiIslaiduIrasus() {
        ArrayList<IslaiduIrasas> islaidos = gautiIslaiduIrasus();
        if (islaidos.size() == 0) {
            System.out.println("Irasu nerasta");
            return;
        }

        for (IslaiduIrasas p : islaidos) {
            System.out.println(p.getDisplayString());
        }
    }

    public void pasalintiPajamuIrasa(Scanner sc) {
        int id = getItem(sc);
        if (id != -1 && irasai.get(id) instanceof PajamuIrasas) {
            irasai.remove(id);
            System.out.println(id + " irasas pasalintas");
        } else {
            System.out.println("Irasas nerastas");
        }
    }

    public void pasalintiIslaiduIrasa(Scanner sc) {
        int id = getItem(sc);
        if (id != -1 && irasai.get(id) instanceof IslaiduIrasas) {
            irasai.remove(id);
            System.out.println(id + " irasas pasalintas");
        } else {
            System.out.println("Irasas nerastas");
        }
    }

    public void redaguotiPajamuIrasa(Scanner sc) {
        PajamuIrasas item = gautiPajamuIrasa(sc);
        if (item == null) return;

        String input = processChange(sc, "Suma: " + item.suma);
        if (input != null) {
            item.suma = Float.parseFloat(input);
        }

        input = processChange(sc, "Kategorija: " + item.pajamuKategorija);
        if (input != null) {
            item.pajamuKategorija = input;
        }

        input = processChange(sc, "Ar i banka: " + item.pozymisArIBanka);
        if (input != null) {
            item.pozymisArIBanka = Integer.parseInt(input) == 1;
        }

        input = processChange(sc, "Papildoma informacija: " + item.papildomaInfo);
        if (input != null) {
            item.papildomaInfo = input;
        }
    }

    public void redaguotiIslaiduIrasa(Scanner sc) {
        IslaiduIrasas item = gautiIslaiduIrasa(sc);
        if (item == null) return;

        String input = processChange(sc, "Suma: " + item.suma);
        if (input != null) {
            item.suma = Float.parseFloat(input);
        }

        input = processChange(sc, "Kategorija: " + item.islaiduKategorija);
        if (input != null) {
            item.islaiduKategorija = input;
        }

        input = processChange(sc, "Ar i banka: " + item.atsiskaitymoBudas);
        if (input != null) {
            item.atsiskaitymoBudas = input;
        }

        input = processChange(sc, "Papildoma informacija: " + item.papildomaInfo);
        if (input != null) {
            item.papildomaInfo = input;
        }
    }

    private String processChange(Scanner sc, String message) {
        System.out.println(message + " [1] – redaguoti, [2] – toliau.");
        String input = sc.next();
        if (input.compareTo("1") == 0) {
            System.out.println("Įveskite naują reikšmę.");
            return sc.next();
        }
        return null;
    }

    private int getItem(Scanner sc) {
        System.out.println("Iveskite id");

        int pId = Integer.parseInt(sc.next());

        for (int i = 0; i < irasai.size(); i++) {
            if (irasai.get(i).getId() == pId) {
                return i;
            }
        }
        return -1;

    }

//Uzduotis: KlasėBiudzetas turi turėti metodąatnaujintiIrasa(Irasas irasas) {...}, kuris suranda įrašą sąraše ir jį atnaujina.
//Bet uzduoti nenurodyta panaudoti si metoda.

    private void atnaujintiIrasa(Irasas irasas) {
        for (int i = 0; i < irasai.size(); i++) {
            if (irasai.get(i).equals(irasas)) {
                irasai.set(i, irasas);
            }
        }
    }
}
