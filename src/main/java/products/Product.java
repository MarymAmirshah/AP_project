package products;

import Rating.Feedback;

public abstract class Product implements Comparable{
    private int code;
    private String name;
    private String company;
    private double price;
    private boolean status;
    private String description;
    private double grade;
    private Feedback feedbacks ;
    private int num_seller=0; // number of sellers who rate thr product

    public Product(int code, String name, String company, double price, String description) {
        this.code = code;
        this.name = name;
        this.company = company;
        this.price = price;
        this.description = description;
        this.grade=0;
        // feedbacks = new Feedback();
    }

    public void setNum_seller(int num_seller) {
        this.num_seller = num_seller;
    }

    public int getNum_seller() {
        return num_seller;
    }

    public void setFeedbacks(Feedback feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Feedback getFeedbacks() {
        return feedbacks;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public double getGrade() {
        return grade;
    }

    public int compareTo(Object o)
    {
        Product p = (Product) o;
        if (this.name.compareTo(p.name)>0)
            return 1;
        if (this.name.compareTo(p.name)<0)
            return -1;
        else
        {
            if (this.grade > p.grade)
                return 1;
            if (this.grade < p.grade)
                return -1;
            else
            {
                if (this.price > p.price)
                    return 1;
                if (this.price < p.price)
                    return -1;
                else
                {
                    if (this.status)
                        return 1;
                    else if(p.status)
                        return -1;
                }
            }
        }
        return 0;
    }


    @Override
    public String toString() {
        return
                "code=" + code +
                        ", name='" + name + '\'' +
                        ", company='" + company + '\'' +
                        ", price=" + price +
                        ", status=" + status +
                        ", description='" + description + '\'' +
                        ", grade=" + grade +
                        ", feedbacks=" + feedbacks ;
    }
}


