public class Client {
    private int ID;
    private int waitingTime;
    private int arrivalTime;
    private int serviceTime;
    private boolean isProcessed;

    public Client(int ID, int arrivalTime, int serviceTime){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.isProcessed = false;
        this.waitingTime = 0;
    }

    public Client(){}

    public int getServiceTime(){
        return this.serviceTime;
    }
    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public void setWaitingTime(int waitingTime){
        this.waitingTime = waitingTime;
    }
    public int getWaitingTime(){
        return this.waitingTime;
    }

    public void setProcessed(){
        this.isProcessed = true;
    }

    public boolean isProcessed(){
        return isProcessed;
    }

    public void decreaseServiceTime(){
        this.serviceTime--;
    }

    public String toString(){
        return "(" + this.ID + ", " + this.arrivalTime + ", " + this.serviceTime + ")";
    }
}
