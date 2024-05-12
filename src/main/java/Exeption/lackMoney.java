package Exeption;

public class lackMoney extends InvalidShopping{
    public lackMoney() { //meno >> Shopping
        super("your balance is not enough.");
    }
}
