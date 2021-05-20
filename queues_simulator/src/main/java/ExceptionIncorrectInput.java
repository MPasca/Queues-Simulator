import javax.swing.*;

public class ExceptionIncorrectInput extends Exception{
    public ExceptionIncorrectInput(String wrongInput, String why, JFrame frame){
        super("Incorrect input: " + wrongInput + "; " + why);

        JOptionPane.showMessageDialog(frame, "Incorrect input: " + wrongInput + "; " + why);
    }
}
