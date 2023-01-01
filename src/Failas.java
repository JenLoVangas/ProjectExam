import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Failas {
    static void issaugotiDuomenis(ArrayList<Irasas> irasai) {
        try {
            FileWriter wr = new FileWriter("data.csv");
            for (Irasas ir : irasai) {
                wr.write(ir.toString());
            }
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static ArrayList<Irasas> gautiDuomenis() {
        ArrayList<Irasas> irasai = new ArrayList<>();

        try {
            File file = new File("data.csv");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                String[] el = data.split(",");
                if (el[0].compareTo("P") == 0) {
                    irasai.add(new PajamuIrasas(Float.parseFloat(el[4]), el[2], LocalDateTime.parse(el[5]), Boolean.parseBoolean(el[3]), el[6]));
                } else {
                    irasai.add(new IslaiduIrasas(Float.parseFloat(el[4]), el[2], LocalDateTime.parse(el[5]), (el[3]), el[6]));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return irasai;
    }
}
