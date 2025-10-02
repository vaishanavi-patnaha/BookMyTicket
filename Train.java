public class Train {
    private int train_id;
    private String name;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;



    public Train(int train_id, String name, String source, String destination, int totalSeats) {
        this.train_id = train_id;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;

    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public boolean bookSeats(int count){
        if(count<=availableSeats){
            availableSeats-=count;
            return true;
        }
        return false;
    }
    public void cancel(int count){
        availableSeats+=count;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Train{" +
                 train_id +" | "+
                 name + " | " + source + "->" + destination +
                  "Seats Available"+
                 availableSeats +
                '}';
    }
}
