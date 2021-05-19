import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.print.*;

public class ViewLogs{
    public JFrame logsFrame = new JFrame();

    public JPanel panelLogs = new JPanel();
    public JTextArea area;

    private Border border = BorderFactory.createMatteBorder(1, 3, 1, 1, Color.decode("#000000"));
    private Font font = new Font("Courier New", Font.PLAIN,12);
    JButton clear = new JButton();

    public ViewLogs(){
        logsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logsFrame.setSize(600, 500);

        panelLogs.setBorder(border);
        area = new JTextArea();
        area.setFont(font);
        area.setForeground(Color.decode("#000000"));

        panelLogs.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(area);

        panelLogs.add(scroll, BorderLayout.CENTER);

        logsFrame.add(panelLogs);
        logsFrame.setVisible(true);
    }

}
