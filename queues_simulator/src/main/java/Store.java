import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Store implements Runnable{
    //private List<StoreQueue> queueList = new LinkedList<>();
    private List<Client> waitingList = new ArrayList<>();

    private int noClients;
    private int noQueues;

    private int interval;
    private int clk = 0;

    private int minArrivalTime;
    private int maxArrivalTime;

    private int minServiceTime;
    private int maxServiceTime;

    Scheduler scheduler;

    public Store(int noClients, int noQueues, int interval, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime){
        this.noClients = noClients;
        this.noQueues = noQueues;

        this.interval = interval;

        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;

        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;

        //generateClients();
        //generateQueues();
        this.scheduler = new Scheduler(noClients, noQueues);

    }

    public void generateTestClients(){
        waitingList.add(new Client(1, 2, 2));
        waitingList.add(new Client(2, 3, 3));
        waitingList.add(new Client(3, 3, 4));
        waitingList.add(new Client(4, 10, 2));
    }

    public Store(){
        generateTestClients();
        this.noQueues = 2;
        this.noClients = 4;
        scheduler = new Scheduler(4, 2);
        interval = 30;
    }

    public void printStoreComp(){
        System.out.println("noClients: " + noClients);
        System.out.println("noQueues: " + noQueues);
        System.out.println("Interval: " + interval + " seconds.");
        System.out.println("Arrival time: [" + minArrivalTime + ", " + maxArrivalTime + "]");
        System.out.println("Service time: [" + minServiceTime + ", " + maxServiceTime + "]");
    }

    public void generateClients(){
        int crtArrivalTime, crtServiceTime;
        for(int i = 1; i <= noClients; i++){
            crtArrivalTime = (int)(Math.random() * (maxArrivalTime - minArrivalTime + 1) + minArrivalTime);
            crtServiceTime = (int)(Math.random() * (maxServiceTime - minServiceTime + 1) + minServiceTime);

            waitingList.add(new Client(i, crtArrivalTime, crtServiceTime));
        }
    }

    public void run() {
        while(clk < interval){
            for(Client c: waitingList){
                if(c.getArrivalTime() == clk && !c.isProcessed()){
                    scheduler.dispatchClient(c);
                }
            }

            try {
                System.out.println("Write in logs.txt");
                printStore();
            } catch (IOException e) {
                e.printStackTrace();
            }

            clk++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        scheduler.killThreads();

        try {
            System.out.println("Close logs");
            logs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    FileWriter logs;
    {
        try {
            logs = new FileWriter("logs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printStore() throws IOException {

        logs.write("Time " + clk + '\n');
        String toPrint = "Waiting list: ";
        for (Client c : this.waitingList) {
            if(!c.isProcessed()) {
                toPrint += c.toString() + "; ";
            }
        }

        logs.write(toPrint + '\n');

        for(StoreQueue q: scheduler.getQueueList()){
            logs.write("Queue " + q.getID() + ": " + q.toString() + '\n');
        }

        logs.write("_____________________________________________________________\n");
    }
}
