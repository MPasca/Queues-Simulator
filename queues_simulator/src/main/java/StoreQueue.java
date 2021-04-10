import java.util.LinkedList;
import java.util.Queue;

public class StoreQueue implements Runnable{
    private Queue<Client> clientList = new LinkedList<Client>();
    private Client crtClient = null;
    private int ID;

    public synchronized void addClient(Client newClient){
        clientList.add(newClient);

        if(crtClient == null){
            crtClient = clientList.poll();
        }
    }

    public void processClient(){
        if(crtClient == null || crtClient.getServiceTime() == 0){
            crtClient = clientList.poll();
        }

        if(crtClient != null){
            crtClient.decreaseServiceTime();
        }
    }

    public int timeSpent(){
        if(crtClient == null){
            return 0;
        }

        int duration = crtClient.getServiceTime();
        for(Client c: clientList){
            duration += c.getServiceTime();
        }

        return duration;
    }

    public StoreQueue(int ID){
        this.ID = ID;
    }

    public StoreQueue(){}

    public int getID(){
        return ID;
    }

    public Queue<Client> getClientList() {
        return clientList;
    }

    public Client getCrtClient(){
        return crtClient;
    }

    public String toString(){
        if(crtClient == null){
            return "closed";
        }

        String toPrint = "";

        if(crtClient.getServiceTime() != 0) {
            toPrint = crtClient.toString() + "; ";
        }
        for(Client c: clientList){
            toPrint += c.toString() + "; ";
        }

        return toPrint.equals("") ? "closed" : toPrint;
    }

    @Override
    public void run() {

    }
}
