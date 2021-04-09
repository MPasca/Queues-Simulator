import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Client> clientList = new ArrayList<>();

    private void addClient(Client newClient){
        clientList.add(newClient);
    }

    public Queue(){}
}
