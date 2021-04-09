public class Client {
    private int ID;
    private int arrivalTime;
    private int serviceTime;
    private int timeSpent;

    public Client(int ID, int arrivalTime, int serviceTime){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.timeSpent = 0;
    }

    public Client(){}

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getTimeSpent(){
        return this.timeSpent;
    }
}
