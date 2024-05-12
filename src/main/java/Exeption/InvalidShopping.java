package Exeption;

public class InvalidShopping extends RuntimeException{
    public InvalidShopping(String m) {
        super("Invalid Shopping!\n" +m);
    }
}
