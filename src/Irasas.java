import java.time.LocalDateTime;

public class Irasas {
    private final int id;
    private static int counter = 0;
    float suma;
    LocalDateTime dateTime;
    String papildomaInfo;


    public Irasas(float suma, LocalDateTime dateTime, String papildomaInfo) {
        this.id = ++counter;
        this.suma = suma;
        this.dateTime = dateTime;
        this.papildomaInfo = papildomaInfo;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Irasas temp)) {
            return false;
        }
        return getId() == temp.getId();
    }
}
