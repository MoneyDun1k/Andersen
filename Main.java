import java.time.Instant;

class Ticket {
    private String id;
    private String concertHall;
    private short eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;
    private double price;
    public Ticket(String id, String concertHall, short eventCode, long time, boolean isPromo, char stadiumSector, double maxBackpackWeight, double price) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.price = price;
    }

    public Ticket(String concertHall, short eventCode, long time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = false;
    }


    public String getId() {

        return id;
    }
    public void setId(String id) {

        this.id = id;
    }

    public String getConcertHall() {

        return concertHall;
    }

    public Ticket() {
        this.time = Instant.now().getEpochSecond();
    }

    public void setConcertHall(String concertHall) {
        this.concertHall = concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(short eventCode) {
        this.eventCode = eventCode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }
}

class TicketService {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        System.out.println("Empty Ticket: " + emptyTicket);

        Ticket fullTicket = new Ticket("T123", "BigHall", (short) 101, Instant.now().getEpochSecond(), true, 'B', 5.5, 100.0);
        System.out.println("Full Ticket: " + fullTicket);

        Ticket limitedTicket = new Ticket("MediumHall", (short) 102, Instant.now().getEpochSecond());
        System.out.println("Limited Ticket: " + limitedTicket);
    }
}
