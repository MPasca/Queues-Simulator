public class ExceptionIncorrectInput extends Exception{
    public ExceptionIncorrectInput(String wrongInput, String why){
        super("Incorrect input: " + wrongInput + "; " + why);
    }
}
