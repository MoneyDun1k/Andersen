import java.time.Instant;

class Ticket {
    private String id;
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;

    public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxBackpackWeight) {
        this.id = id;
        this.concertHall = concertHall;
        if (eventCode >= 100 && eventCode <= 999) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException("Код события должен быть трёхзначным числом.");
        }
        this.time = time;
        this.isPromo = isPromo;
        if (stadiumSector == 'A' || stadiumSector == 'B' || stadiumSector == 'C') {
            this.stadiumSector = stadiumSector;
        } else {
            throw new IllegalArgumentException("Неверный сектор стадиона. Допустимы только 'A', 'B' или 'C'.");
        }
        if (maxBackpackWeight > 0) {
            this.maxBackpackWeight = maxBackpackWeight;
        } else {
            throw new IllegalArgumentException("Вес рюкзака должен быть положительным.");
        }
    }

    public Ticket(String concertHall, int eventCode, long time) {
        this.concertHall = concertHall;
        if (eventCode >= 100 && eventCode <= 999) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException("Код события должен быть трёхзначным числом.");
        }
        this.time = time;
        this.isPromo = false;
    }

    public Ticket() {
        this.time = Instant.now().getEpochSecond();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                '}';
    }
}

class TicketService {
    public static void main(String[] args) {
        try {
            Ticket emptyTicket = new Ticket();
            System.out.println("Empty Ticket: " + emptyTicket);

            Ticket fullTicket = new Ticket("T123", "BigHall", 101, Instant.now().getEpochSecond(), true, 'B', 5.5);
            System.out.println("Full Ticket: " + fullTicket);

            Ticket limitedTicket = new Ticket("MediumHall", 123, Instant.now().getEpochSecond());
            System.out.println("Limited Ticket: " + limitedTicket);

            Ticket invalidTicket = new Ticket("MediumHall", 90, Instant.now().getEpochSecond());
            System.out.println("Invalid Ticket: " + limitedTicket);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
