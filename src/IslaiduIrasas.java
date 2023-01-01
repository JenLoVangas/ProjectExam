import java.time.LocalDateTime;

public class IslaiduIrasas {
    int id;
    static int counter = 0;
    float suma;
    String islaiduKategorija;
    LocalDateTime dateTime;
    String atsiskaitymoBudas;
    String papildomaInfo;

    public IslaiduIrasas(float suma, String islaiduKategorija, LocalDateTime dateTime, String atsiskaitymoBudas, String papildomaInfo) {
        this.id = ++counter;
        this.suma = suma;
        this.islaiduKategorija = islaiduKategorija;
        this.dateTime = dateTime;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        this.papildomaInfo = papildomaInfo;
    }

    public String getDisplayString() {
        return String.format("%1$tY-%1$tm-%1$td %tT%nsuma: %1.2f%nkategorija: %s%natsiskaitymo budas: %s%npapildoma informacija: %s%n", dateTime, suma, islaiduKategorija, atsiskaitymoBudas, papildomaInfo);
    }
}
