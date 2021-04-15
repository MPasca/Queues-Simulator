import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.print.*;

public class ViewLogs extends JPanel{
    private JTextArea area;
    private Border border = BorderFactory.createMatteBorder(1, 3, 1, 1, Color.decode("#f7f7ea"));
    private Font font = new Font("Courier New", Font.PLAIN,14);
    JButton clear = new JButton();

    public ViewLogs(){
        this.setBorder(border);
        area = new JTextArea();
        this.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(area);
        this.add(scroll, BorderLayout.CENTER);
    }

    public void write(String text){
        area.append(text);
    }
}
