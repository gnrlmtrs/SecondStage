package exceptions;

public class IncorrectMarkException extends Exception {
    private String message;
    private int mark;

    public IncorrectMarkException(String message, int mark){
        super(message);
        this.message = message;
        this.mark = mark;
    }

    @Override
    public String getMessage(){
        return "Mark: " + mark + " is not correct.";
    }

}
