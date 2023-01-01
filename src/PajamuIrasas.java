import java.time.LocalDateTime;

public class PajamuIrasas {
    int id;
    static int counter = 0;
    float suma;
    String pajamuKategorija;
    LocalDateTime dateTime;
    boolean pozymisArIBanka;
    String papildomaInfo;

    public PajamuIrasas(float suma, String pajamuKategorija, LocalDateTime dateTime, boolean pozymisArIBanka, String papildomaInfo) {
        this.id = ++counter;
        this.suma = suma;
        this.pajamuKategorija = pajamuKategorija;
        this.dateTime = dateTime;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    String getDisplayString() {
        return String.format("%1$tY-%1$tm-%1$td %tT%nsuma: %1.2f%nkategorija: %s%nar i banka: %s%npapildoma informacija: %s%n", dateTime, suma, pajamuKategorija, pozymisArIBanka, papildomaInfo);
    }
}
