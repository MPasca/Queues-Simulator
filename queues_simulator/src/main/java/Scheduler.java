import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<StoreQueue> queueList = new ArrayList<>();
    private int maxClients;
    private int maxQueues;
    private ArrayList<Thread> threadList = new ArrayList<>();

    public Scheduler(int maxClients, int maxQueues){
        this.maxClients = maxClients;
        this.maxQueues = maxQueues;

        for(int i = 0; i < this.maxQueues; i++){
            this.queueList.add(i, new StoreQueue(i, this.maxClients));

            this.threadList.add(i, new Thread(this.queueList.get(i)));
            this.threadList.get(i).start();
            /*try {
                this.threadList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    private StoreQueue findFavQueue(){
        StoreQueue favQueue = null;
        int length = -1;
        for(StoreQueue q: queueList){
            if(length == -1 || length > q.timeSpent()){
                length = q.timeSpent();
                favQueue = q;
            }else if(length == q.timeSpent() && favQueue.getClientList().size() > q.getClientList().size()){
                favQueue = q;
            }
        }

        return favQueue;
    }

    public void dispatchClient(Client newClient){
        newClient.setProcessed();
        findFavQueue().addClient(newClient);
        newClient.setWaitingTime(findFavQueue().timeSpent());
    }

    public List<StoreQueue> getQueueList() {
        return queueList;
    }

    public void killThreads(){
        for(StoreQueue q: queueList){
            q.setOpen(false);
        }
    }

    public String toString(){
        String toPrint = "";
        for(StoreQueue q: this.queueList){
            toPrint += "Queue " + q.getID() + ": " + q.toString() + '\n';
        }

        return toPrint;
    }
}
