package exceptions;

/**
 * Created by Manuel on 27.11.2017.
 */
public class NotComparebleException extends ClassCastException {

    public static final String MESSAGE_1 = "Übergebenes Objekt kann nicht Verglichen werden";

    public NotComparebleException(String s){
        super(s);
    }

    public NotComparebleException(){
        super();
    }
}
