package products.Clothing;

import products.Product;

public class Clothing extends Product {
    private String country;
    private String material;

    public Clothing(int code, String name, String company, double price, String description, String country, String material) {
        super(code, name, company, price, description);
        this.country = country;
        this.material = material;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCountry() {
        return country;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString()+
                "country='" + country + '\'' +
                ", material='" + material + '\'' ;
    }
}

