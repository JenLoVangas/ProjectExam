import java.time.LocalDateTime;

public class PajamuIrasas extends Irasas {
    String pajamuKategorija;
    boolean pozymisArIBanka;

    public PajamuIrasas(float suma, String pajamuKategorija, LocalDateTime dateTime, boolean pozymisArIBanka, String papildomaInfo) {
        super(suma, dateTime, papildomaInfo);
        this.pajamuKategorija = pajamuKategorija;
        this.pozymisArIBanka = pozymisArIBanka;
    }

    @Override
    public String toString() {
        return "P," + getId() +
                "," + pajamuKategorija +
                "," + pozymisArIBanka +
                "," + suma +
                "," + dateTime +
                "," + papildomaInfo + "\n";
    }

    String getDisplayString() {
        return String.format("%1$tY-%1$tm-%1$td %tT%nsuma: %1.2f%nkategorija: %s%nar i banka: %s%npapildoma informacija: %s%n", dateTime, suma, pajamuKategorija, pozymisArIBanka, papildomaInfo);
    }
}
