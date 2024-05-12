package products.Furniture;

public class TV extends Furniture{
    private String resolution;
    private int size;

    public TV(int code, String name, String company, double price, String description, int energy_consumption, boolean guarantee, String resolution, int size) {
        super(code, name, company, price, description, energy_consumption, guarantee);
        this.resolution = resolution;
        this.size = size;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() +
                "resolution='" + resolution + '\'' +
                ", size=" + size ;
    }
}

