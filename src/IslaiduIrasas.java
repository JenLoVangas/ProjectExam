import java.time.LocalDateTime;

public class IslaiduIrasas extends Irasas {
    String islaiduKategorija;
    String atsiskaitymoBudas;


    public IslaiduIrasas(float suma, String islaiduKategorija, LocalDateTime dateTime, String atsiskaitymoBudas, String papildomaInfo) {
        super(suma, dateTime, papildomaInfo);
        this.islaiduKategorija = islaiduKategorija;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    @Override
    public String toString() {
        return "Id=" + getId() +
                ", islaiduKategorija=" + islaiduKategorija +
                ", atsiskaitymoBudas='" + atsiskaitymoBudas + '\'' +
                ", suma=" + suma +
                ", data=" + dateTime +
                ", papildomaInfo='" + papildomaInfo + '\'';
    }

    public String getDisplayString() {
        return String.format("%1$tY-%1$tm-%1$td %tT%nsuma: %1.2f%nkategorija: %s%natsiskaitymo budas: %s%npapildoma informacija: %s%n", dateTime, suma, islaiduKategorija, atsiskaitymoBudas, papildomaInfo);
    }
}
