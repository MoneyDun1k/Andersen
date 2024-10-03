import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

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
        setEventCode(eventCode);
        this.time = time;
        this.isPromo = isPromo;
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
    }

    public Ticket(String concertHall, int eventCode, long time) {
        this("DefaultID", concertHall, eventCode, time, false, 'A', 10.0);
    }

    public Ticket() {
        this("DefaultID", "DefaultHall", 100, Instant.now().getEpochSecond(), false, 'A', 10.0);
    }

    public String getId() {
        return id;
    }

    public void setEventCode(int eventCode) {
        if (eventCode >= 100 && eventCode <= 999) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException("Код события должен быть трёхзначным числом.");
        }
    }

    public void setStadiumSector(char stadiumSector) {
        if (stadiumSector == 'A' || stadiumSector == 'B' || stadiumSector == 'C') {
            this.stadiumSector = stadiumSector;
        } else {
            throw new IllegalArgumentException("Неверный сектор стадиона. Допустимы только 'A', 'B' или 'C'.");
        }
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        if (maxBackpackWeight > 0) {
            this.maxBackpackWeight = maxBackpackWeight;
        } else {
            throw new IllegalArgumentException("Вес рюкзака должен быть положительным.");
        }
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
    private Ticket[] tickets;
    private Map<String, Ticket> ticketMap;

    public TicketService() {
        tickets = new Ticket[10];
        ticketMap = new HashMap<>();
    }

    public void addTicket(Ticket ticket) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                tickets[i] = ticket;
                ticketMap.put(ticket.getId(), ticket);
                return;
            }
        }
        throw new IllegalArgumentException("Нет свободного места для нового билета.");
    }

    public Ticket getTicketById(String id) {
        return ticketMap.get(id);
    }

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        try {
            Ticket emptyTicket = new Ticket();
            ticketService.addTicket(emptyTicket);
            System.out.println("Empty Ticket: " + emptyTicket);

            Ticket fullTicket = new Ticket("T123", "BigHall", 101, Instant.now().getEpochSecond(), true, 'B', 5.5);
            ticketService.addTicket(fullTicket);
            System.out.println("Full Ticket: " + fullTicket);

            for (int i = 1; i <= 8; i++) {
                Ticket additionalTicket = new Ticket("T" + (789 + i), "Hall" + i, 100 + i, Instant.now().getEpochSecond() + i, false, 'A', 10.0);
                ticketService.addTicket(additionalTicket);
                System.out.println("Added Ticket: " + additionalTicket);
            }

            Ticket retrievedTicket = ticketService.getTicketById("T123");
            System.out.println("Retrieved Ticket by ID: " + retrievedTicket);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
