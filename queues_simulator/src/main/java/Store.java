import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Queue> queueList = new ArrayList<>();
    private List<Client>clientList = new ArrayList<>();

    private int noClients;
    private int noQueues;
    private int simInterval;

    private int minArrivalTime;
    private int maxArrivalTime;

    private int minServiceTime;
    private int maxServiceTime;

    public Store(int noClients, int noQueues, int simInterval, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime){
        this.noClients = noClients;
        this.noQueues = noQueues;
        this.simInterval = simInterval;

        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;

        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;
    }

    public Store(){}
}
