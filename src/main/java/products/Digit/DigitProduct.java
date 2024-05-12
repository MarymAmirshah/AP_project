package products.Digit;

import products.Product;

public class DigitProduct extends Product {
    private int memory;
    private int Ram;
    private String system;
    private int weight;
    private String dimension;


    public DigitProduct(int code, String name, String company, double price,  String description,  int memory, int ram, String system, int weight, String dimension) {
        super(code, name, company, price,  description);
        this.memory = memory;
        Ram = ram;
        this.system = system;
        this.weight = weight;
        this.dimension = dimension;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getMemory() {
        return memory;
    }

    public int getRam() {
        return Ram;
    }

    public String getSystem() {
        return system;
    }

    public int getWeight() {
        return weight;
    }

    public String getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return super.toString()+
                "memory=" + memory +
                ", Ram=" + Ram +
                ", system='" + system + '\'' +
                ", weight=" + weight +
                ", dimension='" + dimension + '\'' ;
    }


}
