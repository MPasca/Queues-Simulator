import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class View {
    JFrame newFrame = new JFrame("Queue simulator");

    JPanel panelClients = new JPanel(new FlowLayout());
    JLabel lblClients = new JLabel("Number of clients:");
    JTextField txtClients = new JTextField(5);

    JPanel panelQueues = new JPanel(new FlowLayout());
    JLabel lblQueues = new JLabel("Number of queues:");
    JTextField txtQueues = new JTextField(5);

    JPanel panelInterval = new JPanel(new GridLayout(2, 2));

    JLabel lblMinInterval  = new JLabel("Min:");
    JTextField txtMinInterval = new JTextField(5);
    JLabel lblMaxInterval = new JLabel("Max:");
    JTextField txtMaxInterval = new JTextField(5);

    JPanel panelArrival = new JPanel(new GridLayout(2, 2));

    JLabel lblMinArrival = new JLabel("Minimum arrival time:");
    JTextField txtMinArrival = new JTextField(5);
    JLabel lblMaxArrival = new JLabel("Maximum arrival time:");
    JTextField txtMaxArrival = new JTextField(5);

    JPanel panelService = new JPanel(new GridLayout(2, 2));

    JLabel lblMinService = new JLabel("Minimum service time:");
    JTextField txtMinService = new JTextField(5);
    JLabel lblMaxService = new JLabel("Maximum service time:");
    JTextField txtMaxService = new JTextField(5);

    JButton btnStart = new JButton("Start simulation");

    JPanel mainPanel = new JPanel();


    public View(){
        Font chosenFont = new Font("Courier New", Font.PLAIN,14);
        Font chosenBoldFont = new Font("Courier New", Font.BOLD,14);
        Border border = BorderFactory.createMatteBorder(1, 3, 1, 1, Color.decode("#f7f7ea"));
        EmptyBorder spacingBorder = new EmptyBorder(20, 20, 20, 20);

        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(500, 600);

// ------------------ Panel Clients

        panelClients.setBackground(Color.decode("#161616"));
        lblClients.setFont(chosenBoldFont);
        lblClients.setForeground(Color.decode("#efeb0b"));
        txtClients.setFont(chosenFont);
        panelClients.add(lblClients);
        panelClients.add(txtClients);

        panelClients.setBorder(BorderFactory.createTitledBorder(border, "Clients", TitledBorder.TOP, TitledBorder.DEFAULT_JUSTIFICATION, chosenFont, Color.decode("#f7f7ea")));
        panelClients.setPreferredSize(new Dimension(100, 20));

// ------------------ Panel Queues

        panelQueues.setBackground(Color.decode("#161616"));
        lblQueues.setFont(chosenBoldFont);
        lblQueues.setForeground(Color.decode("#efeb0b"));
        txtQueues.setFont(chosenFont);
        panelQueues.add(lblQueues);
        panelQueues.add(txtQueues);

        panelQueues.setBorder(BorderFactory.createTitledBorder(border, "Queues", TitledBorder.TOP, TitledBorder.DEFAULT_JUSTIFICATION, chosenFont, Color.decode("#f7f7ea")));
        panelQueues.setPreferredSize(new Dimension(100, 20));

// ------------------ Panel Interval

        panelInterval.setBackground(Color.decode("#161616"));

        lblMinInterval.setFont(chosenFont);
        lblMinInterval.setForeground(Color.decode("#efeb0b"));
        txtMinInterval.setFont(chosenFont);

        lblMaxInterval.setFont(chosenFont);
        lblMaxInterval.setForeground(Color.decode("#efeb0b"));
        txtMaxInterval.setFont(chosenFont);

        panelInterval.setBackground(Color.decode("#161616"));
        panelInterval.add(lblMinInterval);
        panelInterval.add(txtMinInterval);

        panelInterval.add(lblMaxInterval);
        panelInterval.add(txtMaxInterval);
        
        panelInterval.setBorder(BorderFactory.createTitledBorder(border, "Interval", TitledBorder.TOP, TitledBorder.DEFAULT_JUSTIFICATION, chosenFont, Color.decode("#f7f7ea")));

// ------------------ Panel Arrival

        panelArrival.setBackground(Color.decode("#161616"));

        lblMinArrival.setFont(chosenFont);
        lblMinArrival.setForeground(Color.decode("#efeb0b"));
        txtMinArrival.setFont(chosenFont);

        lblMaxArrival.setFont(chosenFont);
        lblMaxArrival.setForeground(Color.decode("#efeb0b"));
        txtMaxArrival.setFont(chosenFont);

        panelArrival.setBackground(Color.decode("#161616"));
        panelArrival.add(lblMinArrival);
        panelArrival.add(txtMinArrival);
        panelArrival.add(lblMaxArrival);
        panelArrival.add(txtMaxArrival);

        panelArrival.setBorder(BorderFactory.createTitledBorder(border, "Arrival", TitledBorder.TOP, TitledBorder.DEFAULT_JUSTIFICATION, chosenFont, Color.decode("#f7f7ea")));

// ------------------ Panel Service

        panelService.setBackground(Color.decode("#161616"));

        lblMinService.setFont(chosenFont);
        lblMinService.setForeground(Color.decode("#efeb0b"));
        txtMinService.setFont(chosenFont);

        lblMaxService.setFont(chosenFont);
        lblMaxService.setForeground(Color.decode("#efeb0b"));
        txtMaxService.setFont(chosenFont);

        panelService.setBackground(Color.decode("#161616"));
        panelService.add(lblMinService);
        panelService.add(txtMinService);
        panelService.add(lblMaxService);
        panelService.add(txtMaxService);
        
        panelService.setBorder(BorderFactory.createTitledBorder(border, "Service", TitledBorder.TOP, TitledBorder.DEFAULT_JUSTIFICATION, chosenFont, Color.decode("#f7f7ea")));

// ------------------ Main Panel

        btnStart.setBackground(Color.decode("#efeb0b"));
        btnStart.setFont(new Font("Courier New", Font.BOLD,20));
        btnStart.setBorder(spacingBorder);
        btnStart.setPreferredSize(new Dimension(50, 30));

        mainPanel.setBackground(Color.decode("#161616"));

        mainPanel.add(panelClients);
        //mainPanel.add(sep);
        mainPanel.add(panelQueues);
        //mainPanel.add(sep);
        mainPanel.add(panelInterval);
        //mainPanel.add(sep);
        mainPanel.add(panelArrival);
        //mainPanel.add(sep);
        mainPanel.add(panelService);
        //mainPanel.add(sep);
        mainPanel.add(btnStart);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setBorder(spacingBorder);

        newFrame.setContentPane(mainPanel);
        newFrame.setVisible(true);
    }
}
