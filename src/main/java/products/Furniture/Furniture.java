package products.Furniture;

import products.Product;

public class Furniture extends Product {
    private int Energy_consumption;
    private boolean guarantee;

    public Furniture(int code, String name, String company, double price, String description, int energy_consumption, boolean guarantee) {
        super(code, name, company, price, description);
        Energy_consumption = energy_consumption;
        this.guarantee = guarantee;
    }

    public void setEnergy_consumption(int energy_consumption) {
        Energy_consumption = energy_consumption;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public int getEnergy_consumption() {
        return Energy_consumption;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    @Override
    public String toString() {
        return super.toString()+"{" +
                "Energy_consumption=" + Energy_consumption +
                ", guarantee=" + guarantee +
                '}';
    }
}


