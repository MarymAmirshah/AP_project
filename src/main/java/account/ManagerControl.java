package account;

import Controller.MySQL;
import Exeption.InvalidEmail;
import Rating.Feedback;
import products.Clothing.Clothes;
import products.Clothing.Clothing;
import products.Digit.DigitProduct;
import products.Eatable.Eatable;
import products.Furniture.Furniture;
import products.Product;
import products.ProductManager;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class ManagerControl {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
    public static ArrayList<Product> productRequest = new ArrayList<Product>();
    static ArrayList<Seller> sellerRequest = new ArrayList<Seller>();
    // check Exeption
    static String regex= "^[A-Za-z0-9+_.-]+@(.+)$";
    static Pattern pattern= compile (regex);

    static String Tregex= "\\d{11}$";
    static Pattern Tpattern = compile(Tregex);

    public static boolean find(String user, int pass) {
        boolean found = false;
        if (user.equals("admin") && pass==1111)
            found=true;
        return found;
    }

    //.................requests
    public static void SellerRequest(String user, String name, String family, String email, String phone, int pass, String company) throws IOException {
        //email control
        Matcher matcher;
        matcher= pattern.matcher(email);
        try {
            if (!matcher.matches())
            {
                throw new InvalidEmail();
            }
        } catch (InvalidEmail e) {
            e.printStackTrace();
        }
        // telephone control
        Matcher Tmatch;
        Tmatch = Tpattern.matcher(phone);
        try {
            if (!matcher.matches())
            {
                throw new InvalidEmail();
            }
        } catch (InvalidEmail e) {
            e.printStackTrace();
        }
        sellerRequest.add(new Seller(user, name, family, email, phone, pass, company));

        FileOutputStream seller_request = new FileOutputStream("E:\\uni project\\Data\\Account\\Seller\\seller_request.txt", true);
        Formatter F = new Formatter(seller_request);
        F.format("%s\n%s\n%s\n%s\n%s\n%d\n%f\n",user, name, family, email, phone, pass, company );
        F.flush();
        seller_request.close();
        F.close();
    }

    //.....................
    public static void SHsellerAcceptoin() {
        for (int i = 0; i < sellerRequest.size(); i++) {
            System.out.println(i + " :");
            System.out.println(sellerRequest.get(i));
        }}
    public static void sellerAcceptoin(int p , int code) throws IOException, SQLException {

            switch (p) {
                case 1:
                    sellerAccept(code);
                case 0:
                    sellerRequest.remove(code);
            }
            System.out.println("if you wanna break enter 0 else 1");

    }

    public static void sellerAccept(int i) throws IOException, SQLException {
        Seller seller1 = sellerRequest.get(i);
        SellerControl.sellers.add(seller1);
        //add to file
        FileOutputStream seller = new FileOutputStream("E:\\uni project\\Data\\Account\\Seller\\seller.txt", true);
        ObjectOutputStream obj = new ObjectOutputStream(seller);
        obj.writeObject(sellerRequest.get(i));
        obj.flush();
        seller.close();
        obj.close();
        //MySQL
        String SQLCom = String.format("INSERT INTO seller(code, name, family name, company name, user_name) values("
                +"%d,'%s','%s','%s','%s')",seller1.getId() , seller1.getName(),seller1.getFamily(),seller1.getCompanyName(),seller1.getUser_name());
        MySQL.getMySQL().Execute(SQLCom);
        String S = String.format("INSERT INTO emails(id,email) values("
                +"%d,'%s')",seller1.getId() , seller1.getEmail());
        MySQL.getMySQL().Execute(S);
        String Q = String.format("INSERT INTO emails(id , phone num) values("
                +"%d,'%s')", seller1.getId() , seller1.getPhoneNum());
        MySQL.getMySQL().Execute(Q);
    }

    public static void SHaddProduct()
    {
        for (int i = 0; i < productRequest.size(); i++) {
            System.out.println(i + " :");
            System.out.println(productRequest.get(i));
        }
    }
    public static void AddProduct(int p, int code) throws IOException {

            switch (p) {
                case 1:
                    ProductManager.products.add(productRequest.get(code));
                    Seller.products.add(productRequest.get(code));
                    Product t = productRequest.get(code);
                    if(t instanceof DigitProduct)
                    {
                        FileOutputStream digit = new FileOutputStream("E:\\uni project\\Data\\Product\\Digit\\digit.txt", true);
                        Formatter F = new Formatter(digit);
                        F.format("%d\n%s\n%f\n%s\n%d\n%d\n%s\n%f\n",code, t.getName(), t.getPrice(), t.getDescription(), ((DigitProduct) t).getMemory(), ((DigitProduct) t).getRam(), ((DigitProduct) t).getSystem(), ((DigitProduct) t).getWeight() );
                        F.flush();
                        digit.close();
                        F.close();
                    }
                    if(t instanceof Clothing)
                    {
                        FileOutputStream clothes = new FileOutputStream("E:\\uni project\\Data\\Product\\Digit\\digit.txt", true);
                        Formatter F = new Formatter(clothes);
                        F.format("%d\n%s\n%f\n%s\n%s\n%s\n",code, t.getName(), t.getPrice(), t.getDescription(), ((Clothing) t).getMaterial(),((Clothing) t).getCountry() );
                        F.flush();
                        clothes.close();
                        F.close();
                    }
                    if(t instanceof Eatable)
                    {
                        FileOutputStream eatable = new FileOutputStream("E:\\uni project\\Data\\Product\\Eatable\\eatable.txt", true);
                        Formatter F = new Formatter(eatable);
                        F.format("%d\n%s\n%f\n%s\n%s\n%s\n",code, t.getName(), t.getPrice(), t.getDescription(), ((Eatable) t).getPro(), ((Eatable) t).getExp() );
                        F.flush();
                        eatable.close();
                        F.close();
                    }
                    if(t instanceof Furniture)
                    {
                        FileOutputStream furniture = new FileOutputStream("E:\\uni project\\Data\\Product\\Furniture\\furniture.txt", true);
                        Formatter F = new Formatter(furniture);
                        F.format("%d\n%s\n%f\n%s\n%s\n",code, t.getName(), t.getPrice(), t.getDescription(),((Furniture) t).getEnergy_consumption() );
                        F.flush();
                        furniture.close();
                        F.close();
                    }

                case 2:
                    productRequest.remove(code);
            }
            System.out.println("if you wanna break enter 0 else 1");

    }

}
