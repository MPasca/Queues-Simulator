import java.util.ArrayList;
import java.util.List;

public class Queue implements Runnable{
    private List<Client> clientList = new ArrayList<>();

    private synchronized void addClient(Client newClient){
        clientList.add(newClient);
        notifyAll();
    }

    private synchronized void deleteClient(){
        clientList.remove(0);
        notifyAll();
    }
    public Queue(){}

    @Override
    public void run() {

    }
}
