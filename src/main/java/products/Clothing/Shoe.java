package products.Clothing;

public class Shoe extends Clothing{
    private int size;
    private ShoeType shoe;

    public Shoe(int code, String name, String company, double price, String description, String country, String material, int size, ShoeType shoe) {
        super(code, name, company, price, description, country, material);
        this.size = size;
        this.shoe = shoe;
    }

    public void setShoe(ShoeType shoe) {
        this.shoe = shoe;
    }

    public ShoeType getShoe() {
        return shoe;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public enum ShoeType
    { SANDAL,SPORT,SLIPPER }

    @Override
    public String toString() {
        return super.toString() +
                "size=" + size +
                ", shoe=" + shoe ;
    }
}

