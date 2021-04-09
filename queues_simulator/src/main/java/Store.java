import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Queue> queueList = new ArrayList<>();
    private List<Client>clientList = new ArrayList<>();

    private int noClients;
    private int noQueues;

    private int interval;

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

        clientList = this.generateClients(noClients, minArrivalTime, maxArrivalTime, minServiceTime, maxServiceTime);
    }

    public Store(){}

    public void printStoreComp(){
        System.out.println("noClients: " + noClients);
        System.out.println("noQueues: " + noQueues);
        System.out.println("Interval: " + interval + " seconds.");
        System.out.println("Arrival time: [" + minArrivalTime + ", " + maxArrivalTime + "]");
        System.out.println("Service time: [" + minServiceTime + ", " + maxServiceTime + "]");
    }

    public List<Client> generateClients(int noClients, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime){
        List<Client> newClientList = new ArrayList<>();

        for(int i = 0; i < noClients; i++){
            Client auxClient = new Client();
            auxClient.setID(i);
            auxClient.setArrivalTime((int)(Math.random() * (maxArrivalTime - minArrivalTime + 1) + minArrivalTime));
            auxClient.setServiceTime((int)(Math.random() * (maxServiceTime - minServiceTime + 1) + minServiceTime));

            newClientList.add(auxClient);
        }

        return newClientList;
    }
}
