package products.Furniture;

public class Stove extends Furniture{
    private int flame;
    private String material;
    private boolean oven;

    public Stove(int code, String name, String company, double price, String description, int energy_consumption, boolean guarantee, int flame, String material, boolean oven) {
        super(code, name, company, price, description, energy_consumption, guarantee);
        this.flame = flame;
        this.material = material;
        this.oven = oven;
    }

    public void setFlame(int flame) {
        this.flame = flame;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }

    public int getFlame() {
        return flame;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isOven() {
        return oven;
    }

    @Override
    public String toString() {
        return super.toString() +
                "flame=" + flame +
                ", material='" + material + '\'' +
                ", oven=" + oven ;
    }
}


