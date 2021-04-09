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

}
