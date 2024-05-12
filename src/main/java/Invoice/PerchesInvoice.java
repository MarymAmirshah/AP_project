package Invoice;

import products.Product;

import java.util.ArrayList;

public class PerchesInvoice {
    private int code;
    private String data;
    private double payment;
    private String Name;
    private boolean status;
    static ArrayList<Product> products;

    public PerchesInvoice(int code, String data, double payment, String name, boolean status) {
        this.code = code;
        this.data = data;
        this.payment = payment;
        Name = name;
        this.status = status;
        products= new ArrayList<Product>();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public double getPayment() {
        return payment;
    }

    public String getName() {
        return Name;
    }

    public boolean isStatus() {
        return status;
    }
}


