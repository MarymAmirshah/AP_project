package Exeption;

public class InvalidEntry extends  RuntimeException{
    public InvalidEntry(String m) {
        super("Entry is not acceptable\t" + m);
    }
}
