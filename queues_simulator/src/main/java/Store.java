import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Store {
    private List<StoreQueue> queueList = new LinkedList<>();
    private List<Client> waitingList = new ArrayList<>();

    private int noClients;
    private int noQueues;

    private int interval;
    private int clk = 0;

    private int minArrivalTime;
    private int maxArrivalTime;

    private int minServiceTime;
    private int maxServiceTime;

    public Store(int noClients, int noQueues, int interval, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime){
        this.noClients = noClients;
        this.noQueues = noQueues;

        this.interval = interval;

        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;

        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;

        //generateClients();
        generateQueues();
    }

    public void generateTestClients(){
        waitingList.add(new Client(1, 2, 2));
        waitingList.add(new Client(2, 3, 3));
        waitingList.add(new Client(3, 3, 4));
        waitingList.add(new Client(4, 10, 2));
    }

    public Store(){
        generateTestClients();
        generateQueues();

        interval = 30;
    }

    public void printStoreComp(){
        System.out.println("noClients: " + noClients);
        System.out.println("noQueues: " + noQueues);
        System.out.println("Interval: " + interval + " seconds.");
        System.out.println("Arrival time: [" + minArrivalTime + ", " + maxArrivalTime + "]");
        System.out.println("Service time: [" + minServiceTime + ", " + maxServiceTime + "]");
    }

    public void generateQueues(){
        for(int i = 1; i <= 2; i++){
            queueList.add(new StoreQueue(i));
        }
    }

    public void generateClients(){

        int crtArrivalTime = 0, crtServiceTime = 0;
        for(int i = 1; i <= noClients; i++){
            crtArrivalTime = (int)(Math.random() * (maxArrivalTime - minArrivalTime + 1) + minArrivalTime);
            crtServiceTime = (int)(Math.random() * (maxServiceTime - minServiceTime + 1) + minServiceTime);

            waitingList.add(new Client(i, crtArrivalTime, crtServiceTime));
        }
    }

    private StoreQueue addToQueue(){
        StoreQueue favQueue = new StoreQueue();
        int length = -1;
        for(StoreQueue q: queueList){
            if(length == -1 || length > q.timeSpent()){
                length = q.timeSpent();
                favQueue = q;
            }
        }

        return favQueue;
    }

    public void startSimulation(){
        while(clk < interval){
            for(Client c: waitingList){
                if(c.getArrivalTime() == clk){
                    addToQueue().addClient(c);
                }
            }

            for(StoreQueue q: queueList){
                waitingList.removeAll(q.getClientList());
                waitingList.remove(q.getCrtClient());
            }

            printStore();

            for(StoreQueue q: queueList){
                q.processClient();
            }
            clk++;
        }
    }
    
    private void printStore(){
        System.out.println("Time " + clk);
        String toPrint = "Waiting list: ";
        for(Client c: waitingList){
            toPrint += c.toString() + "; ";
        }

        System.out.println(toPrint);

        for(StoreQueue q: queueList){
            System.out.println("Queue " + q.getID() + ": " + q.toString());
        }

        System.out.println("_____________________________________________________________");
    }
}
