package products.Eatable;

import products.Product;

public class Eatable extends Product {
    private String pro;
    private String Exp;

    public Eatable(int code, String name, String company, double price, String description, String pro, String exp) {
        super(code, name, company, price, description);
        this.pro = pro;
        Exp = exp;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public String getPro() {
        return pro;
    }

    public String getExp() {
        return Exp;
    }

    @Override
    public String toString() {
        return super.toString()+
                "pro='" + pro + '\'' +
                ", Exp='" + Exp + '\'' ;
    }
}


