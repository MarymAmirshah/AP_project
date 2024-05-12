package products.Furniture;

public class Fridge extends Furniture{
    private int capacity;
    private String brand;
    private boolean freezer;


    public Fridge(int code, String name, String company, double price, String description, int energy_consumption, boolean guarantee, int capacity, String brand, boolean freezer) {
        super(code, name, company, price, description, energy_consumption, guarantee);
        this.capacity = capacity;
        this.brand = brand;
        this.freezer = freezer;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFreezer(boolean freezer) {
        this.freezer = freezer;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isFreezer() {
        return freezer;
    }

    @Override
    public String toString() {
        return super.toString()+
                "capacity=" + capacity +
                ", brand='" + brand + '\'' +
                ", freezer=" + freezer ;
    }
}
