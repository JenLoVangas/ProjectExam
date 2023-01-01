import java.util.Scanner;

import static java.lang.Integer.*;

public class Patikrinimai {

    public static float suma(Scanner sc) {
        float suma;
        do {
            while (!sc.hasNextFloat()) {
                System.out.println("Iveskite skaiciu");
                sc.next();
            }
            suma = sc.nextFloat();
            if(suma<0){
                System.out.println("Iveskite teigema suma");
            }
        } while (suma <= 0);
        System.out.println("Ivesta suma yra " + suma);
        return suma;
    }

    public static boolean banko(Scanner sc) {

        while (!sc.hasNext("[01]")) {
            System.out.println("Bloga ivestis...");
            System.out.println("Pasirinkite:");
            System.out.println("[0] - Ne");
            System.out.println("[1] - Taip");
            sc.nextLine();
        }

        boolean b = parseInt(sc.nextLine()) == 1;

        String pasirinkimas;
        if (b) pasirinkimas = "Taip";
        else pasirinkimas = "Ne";

        System.out.println("Pasirinkote: " + pasirinkimas);

        return b;
    }


}
