public class Client {
    private int ID;
    private int arrivalTime;
    private int serviceTime;
    private boolean isProcessed;

    public Client(int ID, int arrivalTime, int serviceTime){
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.isProcessed = false;
    }

    public Client(){}

    public int getServiceTime(){
        return this.serviceTime;
    }
    public int getArrivalTime(){
        return this.arrivalTime;
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
