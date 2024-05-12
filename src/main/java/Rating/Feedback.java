package Rating;

public class Feedback {
    private String buyerName;
    private String productName;
    private String feedback;
    private status status ;

    public Feedback(String buyerName, String productName, String feedback) {
        this.buyerName = buyerName;
        this.productName = productName;
        this.feedback = feedback;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setStatus(Feedback.status status) {
        this.status = status;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getProductName() {
        return productName;
    }

    public String getFeedback() {
        return feedback;
    }

    public Feedback.status getStatus() {
        return status;
    }

    enum status { ACCEPTED , WAITING_APPROVAL, NOT_ACCEPTED }
}
