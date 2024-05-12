package account;

import Invoice.PerchesInvoice;
import products.Product;

import java.util.ArrayList;

public class Buyer extends Account{
    double money;
    private ArrayList<Product> cart ;
   public static ArrayList<PerchesInvoice> factors;


    public Buyer(String user_name, String name, String family, String email, String phoneNum, int code, double money) {
        super(user_name, name, family, email, phoneNum, code);
        this.money = money;
        factors= new ArrayList<PerchesInvoice>();
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public void setFactors(ArrayList<PerchesInvoice> factors) {
        this.factors = factors;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public ArrayList<PerchesInvoice> getFactors() {
        return factors;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
