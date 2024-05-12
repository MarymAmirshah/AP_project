package Rating;

public class Grade {
    private String buyerName;
    private int grade;
    private String product;

    public Grade(String buyerName, int grade, String product) {
        this.buyerName = buyerName;
        this.grade = grade;
        this.product = product;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public int getGrade() {
        return grade;
    }

    public String getProduct() {
        return product;
    }
}


