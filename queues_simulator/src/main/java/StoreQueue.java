import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StoreQueue implements Runnable{
    private BlockingQueue<Client> clientList;
    private AtomicInteger waitingTime = new AtomicInteger(0);
    private int maxClients;
    Client crtClient = null;
    private int ID;

    private boolean isOpen = true;

    public StoreQueue(int ID, int maxClients){
        this.ID = ID;
        this.maxClients = maxClients;
        this.clientList = new ArrayBlockingQueue<>(maxClients);
        this.isOpen = true;
    }

    public void addClient(Client newClient){
        this.clientList.add(newClient);
        this.isOpen = true;

        this.waitingTime.addAndGet(newClient.getServiceTime());
    }

    public int timeSpent(){
        return waitingTime.get();
    }

    public int getID(){
        return ID;
    }

    public Queue<Client> getClientList() {
        return this.clientList;
    }

    public String toString(){
        if(this.clientList == null){
            return "closed";
        }

        String toPrint = "";

        for(Client c: this.clientList){
            toPrint += c.toString() + "; ";
        }

        return toPrint.equals("") ? "closed" : toPrint;
    }

    public boolean isOpen(){
        return this.isOpen;
    }

    public void setOpen(boolean status){
        this.isOpen = status;
    }

    @Override
    public void run() {
        while(isOpen()) {
            try {
                if(!this.clientList.isEmpty()) {
                    if(crtClient == null) {
                        crtClient = this.clientList.peek();
                    }

                    System.out.println("Queue #" + ID);
                    System.out.println("Currently processing client: " + crtClient.toString());

                    Thread.sleep( 1000);

                    this.crtClient.decreaseServiceTime();
                    this.waitingTime.decrementAndGet();
                    if(this.crtClient.getServiceTime() == 0){
                        this.crtClient = null;
                        this.clientList.poll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
