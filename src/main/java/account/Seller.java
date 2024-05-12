package account;

import Invoice.SalesInvoice;
import products.Product;

import java.util.ArrayList;

public class Seller extends Account{
    private String companyName;
   public static ArrayList<Product> products = new ArrayList<Product>() ;
   public static ArrayList<SalesInvoice> factors;


    public Seller(String user_name, String name, String family, String email, String phoneNum, int code, String companyName) {
        super(user_name, name, family, email, phoneNum, code);
        this.companyName = companyName;
    }


    public void setFactors(ArrayList<SalesInvoice> factors) {
        this.factors = factors;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<SalesInvoice> getFactors() {
        return factors;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}


