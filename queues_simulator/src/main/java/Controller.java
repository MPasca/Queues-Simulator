import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view = new View();

    public Controller(){
        view.addListener(new StartListener());
    }

    private void startSimulation() throws ExceptionIncorrectInput{
        int noClients, noQueues, interval, minArriv, maxArriv, minServ, maxServ;
        noClients = view.getText("clients");
        noQueues = view.getText("queue");
        interval = view.getText("interval");
        minArriv = view.getText("min_arrival");
        maxArriv = view.getText("max_arrival");
        minServ = view.getText("min_service");
        maxServ = view.getText("max_service");

        if(minArriv > maxArriv) {
            throw new ExceptionIncorrectInput("minArriv maxArriv", "minimum can't be larger than maximum", view.newFrame);
        }
        if(minServ > maxServ){
            throw new ExceptionIncorrectInput("minService maxService", "minimum can't be larger than maximum", view.newFrame);
        }
        if(maxServ > interval){
            throw new ExceptionIncorrectInput("maxService simDuration", "The maximum duration of a service is larger than the entire duration of the simulation", view.newFrame);
        }

        view.newFrame.setVisible(false);

        Store store = new Store(noClients, noQueues, interval, minArriv, maxArriv, minServ, maxServ);
        Thread simThread = new Thread(store);
        simThread.start();
        try {
            simThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                startSimulation();
            }catch(Exception error){
                error.printStackTrace();
            }
        }
    }
}


