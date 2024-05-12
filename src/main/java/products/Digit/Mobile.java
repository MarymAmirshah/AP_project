package products.Digit;

public class Mobile extends DigitProduct{
    private int SIMcards;
    private int camera;

    public Mobile(int code, String name, String company, double price, String description, int memory, int ram, String system, int weight, String dimension, int SIMcards, int camera) {
        super(code, name, company, price, description, memory, ram, system, weight, dimension);
        this.SIMcards = SIMcards;
        this.camera = camera;
    }

    public void setSIMcards(int SIMcards) {
        this.SIMcards = SIMcards;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getSIMcards() {
        return SIMcards;
    }

    public int getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return super.toString() +
                "SIMcards=" + SIMcards +
                ", camera=" + camera ;
    }
}

