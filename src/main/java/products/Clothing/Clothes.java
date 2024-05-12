package products.Clothing;

public class Clothes extends Clothing {
    private int size;
    private ClothesType clothes;

    public Clothes(int code, String name, String company, double price, String description, String country, String material, int size, ClothesType clothes) {
        super(code, name, company, price, description, country, material);
        this.size = size;
        this.clothes = clothes;
    }

    public void setClothes(ClothesType clothes) {
        this.clothes = clothes;
    }

    public ClothesType getClothes() {
        return clothes;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public enum ClothesType {PANTS, TSHIRT, DRESS}

    @Override
    public String toString() {
        return super.toString() +
                "size=" + size +
                ", clothes=" + clothes;
    }
}
