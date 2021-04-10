public class Client {
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Client(int ID, int arrivalTime, int serviceTime){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getServiceTime(){
        return this.serviceTime;
    }
    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public void decreaseServiceTime(){
        this.serviceTime--;
    }

    public String toString(){
        return "(" + ID + ", " + arrivalTime + ", " + serviceTime + ")";
    }
}
