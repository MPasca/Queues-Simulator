import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.addListener(new StartListener());
    }

    private void getInput() throws ExceptionIncorrectInput{
        int noClients, noQueues, interval, minArriv, maxArriv, minServ, maxServ;
        noClients = view.getText("clients");
        noQueues = view.getText("queue");
        interval = view.getText("interval");
        minArriv = view.getText("min_arrival");
        maxArriv = view.getText("max_arrival");
        minServ = view.getText("min_service");
        maxServ = view.getText("max_service");

        if(minArriv > maxArriv) {
            throw new ExceptionIncorrectInput("minArriv maxArriv", "minimum can't be larger than maximum");
        }
        if(minServ > maxServ){
            throw new ExceptionIncorrectInput("minService maxService", "minimum can't be larger than maximum");
        }
        if(maxServ > interval){
            throw new ExceptionIncorrectInput("maxService simDuration", "The maximum duration of a service is larger than the entire duration of the simulation");
        }
        model = new Model(new Store(noClients, noQueues, interval, minArriv, maxArriv, minServ, maxServ));
    }

    class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                getInput();
            }catch(Exception error){
                error.printStackTrace();
            }
        }
    }
}


