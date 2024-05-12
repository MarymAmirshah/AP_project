package products.Digit;

public class Laptop extends DigitProduct{
    private String model;
    private boolean gaming;

    public Laptop(int code, String name, String company, double price, String description, int memory, int ram, String system, int weight, String dimension, String model, boolean gaming) {
        super(code, name, company, price, description, memory, ram, system, weight, dimension);
        this.model = model;
        this.gaming = gaming;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setGaming(boolean gaming) {
        this.gaming = gaming;
    }

    public String getModel() {
        return model;
    }

    public boolean isGaming() {
        return gaming;
    }

    @Override
    public String toString() {
        return super.toString()+
                "model='" + model + '\'' +
                ", gaming=" + gaming ;
    }
}


