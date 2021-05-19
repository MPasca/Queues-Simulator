import javax.swing.*;
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

    private double avgServiceTime;
    private double avgWaitingTime;
    Scheduler scheduler;

    ViewLogs viewLogs;

    public Store(int noClients, int noQueues, int interval, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime){
        this.noClients = noClients;
        this.noQueues = noQueues;

        this.interval = interval;

        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;

        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;

        generateClients();
        avgServiceTime = 0;
        for(Client c: waitingList){
            avgServiceTime += c.getServiceTime();
        }

        avgServiceTime /= noClients;

        this.scheduler = new Scheduler(noClients, noQueues);

        this.viewLogs = new ViewLogs();
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
        avgServiceTime = 0;
        avgWaitingTime = 0;
        for(Client c: waitingList){
            avgServiceTime += c.getServiceTime();
        }
        avgServiceTime /= noClients;
        scheduler = new Scheduler(4, 2);
        interval = 30;

        this.viewLogs = new ViewLogs();
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
        while(clk <= interval){
            viewLogs.area.append("Time " + clk + '\n');
            viewLogs.area.append(printDetails());

            for(Client c: waitingList){
                if(c.getArrivalTime() == clk && !c.isProcessed()){
                    scheduler.dispatchClient(c);
                    avgWaitingTime += c.getWaitingTime();
                }
            }


            try {
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

        viewLogs.area.append("Average service time: " + avgServiceTime + '\n');
        avgWaitingTime = avgWaitingTime/this.noClients;
        viewLogs.area.append("Average waiting time: " + avgWaitingTime + '\n');

        try {
            logs.write("Average service time: " + avgServiceTime + '\n');

            logs.write("Average waiting time: " + avgWaitingTime + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    private String printDetails(){
        String toPrint = "Waiting list: ";
        for (Client c : this.waitingList) {
            if(!c.isProcessed()) {
                toPrint += c.toString() + "; ";
            }
        }

        toPrint += '\n';

        for(StoreQueue q: scheduler.getQueueList()){
            toPrint += "Queue " + (q.getID()+1) + ": " + q.toString() + '\n';
        }

        toPrint += "_____________________________________________________________\n";
        return toPrint;
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
            logs.write("Queue " + (q.getID()+1) + ": " + q.toString() + '\n');
        }

        logs.write("_____________________________________________________________\n");
    }

}
