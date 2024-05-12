package Controller;

import Invoice.PerchesInvoice;
import Invoice.SalesInvoice;
import Rating.Feedback;
import account.*;
import account.Buyer;
import products.Clothing.Clothes;
import products.Clothing.Clothing;
import products.Clothing.Shoe;
import products.Digit.DigitProduct;
import products.Digit.Laptop;
import products.Digit.Mobile;
import products.Eatable.Eatable;
import products.Furniture.Fridge;
import products.Furniture.Furniture;
import products.Furniture.Stove;
import products.Furniture.TV;
import products.Product;
import products.ProductManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import Exeption.*;

public class Meno {
    Scanner x = new Scanner(System.in);

    public void Main_page() throws SQLException {
        System.out.println("WELCOME!!!");
        System.out.println("PLEASE ENTER num 1 for Control Panel.");
        System.out.println("PLEASE ENTER num 2 for List of Products.");
        System.out.println("PLEASE ENTER 0 to EXIT.");

        int pick =0;
        try {
            pick = x.nextInt();
        }
        catch (InputMismatchException ce){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",ce.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Scanner x = new Scanner(System.in);
            Main_page();
        }
        switch (pick) {
            case 1:
                try {
                    Control_Panel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Product_List();
                break;
            case 0:
                return;

        }
    }

    public void Control_Panel() throws IOException, SQLException {
        System.out.println("Press 1to Sign in.");
        System.out.println("Press 2to Login.");
        System.out.println("Press 0to go to main page.");
        int pick = 0 ;
        try{
            pick = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            Scanner x = new Scanner(System.in);
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Control_Panel();
        }

        switch (pick) {
            case 1:
                Sign_in();
                break;
            case 2:
                Login();
                break;
            case 0:
                Main_page();
                break;

        }
    }

    public void Product_List() throws SQLException {
        ArrayList<Product> all = ProductManager.getProducts();
        for (int i = 0; i < all.size(); i++)
            System.out.println(all.get(i).getCode() + " :" + all.get(i).getName());
        System.out.println("To categorise products press 1 and for searching press 2:");
        System.out.println("Press 0to go to main page.");
        int p = 0 ;
        try{
            p = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Product_List();
        }
        switch (p) {
            case 1:
                Categorise();
                break;
            case 2:
                Search();
                break;
            case 0:
                Main_page();
                break;
        }
    }

    public void Search() throws SQLException {
        ArrayList<Product> al = ProductManager.getProducts();
        System.out.println("Search product.");
        System.out.println("Search (1) or Press 0to go to main page.");
        int p = 0 ;
        try{
            p = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Search();
        }
        switch (p) {
            case 1:
               ArrayList<Product> w = ProductManager.showAll(al);
               for (int i=0 ; i<w.size() ; i++)
                  System.out.println(w.get(i).getCode() + " :" + w.get(i).getName());
                String name = x.next();
               ProductManager.search(name);
            case 0:
                Main_page();
                break;
        }


    }

    public void Categorise() throws SQLException {
        ArrayList<Product> all = ProductManager.getProducts();
        System.out.println("Choose category!");
        System.out.println("Digital products 1 , Clothing 2 , Furniture 3 , Eatable 4");
        System.out.println("Press 0to go to main page.");
        int category = 0;
        try{
            category = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Categorise();
        }
        if (category==0)
            Main_page();
        else
            ProductManager.SortCategory(category);
    }

    public void Login() throws IOException, SQLException {
        System.out.println("Press 1 if you are customer and 2 if you are seller or 3 for admin.");
        System.out.println("Press 0to go to Control panel.");
        System.out.println("Enter your user name and password:");
        int pick = 0 ;
        try{
            pick = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Login();
        }
        if (pick==0)
        {
            Control_Panel();
        }
        String user = x.next();
        int pass = x.nextInt();
        switch (pick) {
            case 1:
                if (BuyerControl.find(user, pass))
                    Buyer_panel(user);
                else {
                    System.out.println("EROR . Try again .");
                    Login();
                }
            case 2:
                if (SellerControl.find(user, pass))
                    Seller_panel(user);
                else {
                    System.out.println("EROR . Try again .");
                    Login();
                }
            case 3:
                if (ManagerControl.find(user, pass))
                    Manager_panel();
                else {
                    System.out.println("EROR . Try again .");
                    Login();
                }
        }

    }

    public void Sign_in() throws IOException, SQLException {
        System.out.println("Press 0to go to Control panel.");
        System.out.println("To login as customer enter1 , as seller enter 2");
        int enter =0;
        try{
            enter = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Control_Panel();
        }
        if (enter==0)
            Control_Panel();
        System.out.println("Enter your user name and password:");
        String user = x.next();
        int pass =0;
        try {
             pass = x.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",e.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Sign_in();
        }
        System.out.println("Enter your name and family , email , phone number:");
        String name = x.next();
        String family = x.next();
        String email = x.next();
        String phone = x.next();
        switch (enter) {
            case 1:
                System.out.println("Enter your budget:");
                double money = x.nextDouble();
                if (BuyerControl.RepeatUser(user)) {
                    try {
                        BuyerControl.register(user, name, family, email, phone, pass, money);
                    } catch (Exception e) {
                        e.printStackTrace();
                        String errorSt = String.format("INSERT INTO error(error)"
                                +"values '%s'",e.getMessage());
                        MySQL.getMySQL().Execute(errorSt);
                    }
                } else {
                    System.out.println("Repeated user name please try again.");
                    Login();
                }
                Main_page();
            case 2:
                System.out.println("Enter name of your company:");
                String company = x.next();
                ManagerControl.SellerRequest(user, name, family, email, phone, pass, company);
                Main_page();
        }
    }

    public void Buyer_panel(String user) throws SQLException {
        System.out.println("To edit your account enter1 and for shopping enter2 and rating 3");
        System.out.println("Press 0to go to main page.");
        int enter =0;
        try{
            enter = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Buyer_panel(user);
        }
        switch (enter) {
            case 1:
                Edit(user, 1);
                break;
            case 2:
                System.out.println("Enter the date.");
                String date = x.next();
                Shopping(user , date);
            case 3:
                Rating(user);
            case 0:
                Main_page();
                break;
        }
    }
    public void Rating(String user) throws SQLException {
        System.out.println("Enter code of product");
        int c=0;
        try {
            c= x.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",e.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            Rating(user);
        }
        ArrayList<Product> products = ProductManager.getProducts();
        for (int i = 0 ; i< products.size();i++)
        {
            if (products.get(i).getCode()==c)
            {
                System.out.println("Enter your grade to the product 1to5");
                int g= x.nextInt();
                products.get(i).setNum_seller(products.get(i).getNum_seller()+1);
                products.get(i).setGrade((products.get(i).getGrade()+g)/products.get(i).getNum_seller());
                System.out.println("Add your feedback.");
                String F= x.next();
                Feedback feedback= new Feedback(user , products.get(i).getName() , F);
                products.get(i).setFeedbacks( feedback);
                System.out.println("comments added successfully");
            }
        }
        Buyer_panel(user);
    }
    public void Shopping(String user, String date) throws SQLException {
        ArrayList<Product> products = ProductManager.getProducts();
        ArrayList<Buyer> buyers= BuyerControl.getConsumers();
        Random rand=new Random();
        int r=rand.nextInt(200)+1000;
        PerchesInvoice factor = new PerchesInvoice(r,date,0,user,false);
        int c=0;
        for (int i=0 ; i< buyers.size();i++)
        {
            if (buyers.get(i).getUser_name().equals(user))
                c=i;
        }
        while (true)
        {
            System.out.println("Enter code of product. and to end shopping 0.");
            int code =0;
            try {
                code = x.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                String errorSt = String.format("INSERT INTO error(error)"
                        +"values '%s'",e.getMessage());
                MySQL.getMySQL().Execute(errorSt);
            }
            if (code==0) break;
            for (int i=0 ; i<products.size() ; i++)
            {
                if (products.get(i).getCode() == code) {
                    try {
                        if (buyers.get(c).getMoney() < products.get(i).getPrice()) {
                            throw new lackMoney();
                        } else {
                            factor.setPayment(factor.getPayment() + products.get(i).getPrice());
                            buyers.get(c).setMoney(buyers.get(i).getMoney() - products.get(i).getPrice());
                        }
                    } catch (lackMoney e) {
                        e.printStackTrace();
                    }
                }
                else
                    try {
                        throw new InvalidProduct();
                    } catch (InvalidProduct e) {
                        e.printStackTrace();
                    }
            }
        }
        Buyer.factors.add(factor);
        Buyer_panel(user);
    }

    public void Seller_panel(String user) throws SQLException {
        System.out.println("To edit your account enter1");
        System.out.println("Adding product(2) and Editing product(3) and Request invoice(4) ");
        System.out.println("Press 0to go to main page.");
        int enter =0;
        try{
            enter = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",c.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            try {
                Control_Panel();
            } catch (IOException e) {
                e.printStackTrace();
                String error = String.format("INSERT INTO error(error)"
                        +"values '%s'",e.getMessage());
                MySQL.getMySQL().Execute(error);
            }
        }
        switch (enter) {
            case 1:
                Edit(user, 2);
                break;
            case 2:
                AddProduct(user);
                break;
            case 3:
                EditProduct();
                break;
            case 4:
                Random rand=new Random();
                int r=rand.nextInt(100)+500;
                System.out.println("enter date");
                String date= x.next();
                SalesInvoice factor = new SalesInvoice(r,date,user,false);
                Seller.factors.add(factor);
            case 0:
                Main_page();
                break;
        }
        Main_page();
    }

    public void EditProduct() {
        System.out.println("Enter product code , item , new item");
    }

    public void AddProduct(String user) throws SQLException {
        System.out.println("Choose category: Digital(1) Clothing(2) Furniture(3) Eatable(4)");
        int c =0;
        try{
            c = x.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("invalid input");
            String errorSt = String.format("INSERT INTO error(error)"
                    +"values '%s'",e.getMessage());
            MySQL.getMySQL().Execute(errorSt);
            try {
                Control_Panel();
            } catch (IOException ex) {
                ex.printStackTrace();
                String error = String.format("INSERT INTO error(error)"
                        +"values '%s'",ex.getMessage());
                MySQL.getMySQL().Execute(error);
            }
        }
        System.out.println(" code,  name,  company,  price, description");
        int code = x.nextInt();
        String name = x.next();
        String company = x.next();
        double price = x.nextDouble();
        String description = x.next();
        switch (c) {
            //...........digits
            case 1:
                System.out.println("memory, ram, system,weight, dimension");
                int memory = x.nextInt();
                int ram = x.nextInt();
                String system = x.next();
                int weight = x.nextInt();
                String dimention = x.next();
                System.out.println("Mobile(1) , Laptop(2)");
                int Digit =0;
                try{
                    Digit = x.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("invalid input");
                    x = new Scanner(System.in);
                    try {
                        Control_Panel();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                switch (Digit) {
                    case 1:
                        System.out.println(" SIMcards, camera");
                        int SIM = x.nextInt();
                        int camera = x.nextInt();
                        ManagerControl.productRequest.add(new Mobile(code, name, company, price, description, memory, ram, system, weight, dimention, SIM, camera));
                    case 2:
                        System.out.println("model,if gaming(1) or not(2)");
                        String model = x.next();
                        int gaming = x.nextInt();
                        switch (gaming) {
                            case 1:
                                ManagerControl.productRequest.add(new Laptop(code, name, company, price, description, memory, ram, system, weight, dimention, model, true));
                            case 2:
                                ManagerControl.productRequest.add(new Laptop(code, name, company, price, description, memory, ram, system, weight, dimention, model, false));

                        }
                }
                //..........cloths
            case 2:
                System.out.println("country, material");
                String country = x.next();
                String material = x.next();
                System.out.println("Clothes(1) , Shoe(2)");
                int cloth = x.nextInt();
                switch (cloth) {
                    case 1:
                        System.out.println("size,type:PANTS , TSHIRT , DRESS");
                        int Csize = x.nextInt();
                        Clothes.ClothesType Ctype = Clothes.ClothesType.valueOf(x.next());
                        ManagerControl.productRequest.add(new Clothes(code, name, company, price, description, country, material, Csize, Ctype));
                    case 2:
                        System.out.println("size,type:SANDAL,SPORT,SLIPPER");
                        int Ssize = x.nextInt();
                        Shoe.ShoeType Stype = Shoe.ShoeType.valueOf(x.next());
                        ManagerControl.productRequest.add(new Shoe(code, name, company, price, description, country, material, Ssize, Stype));

                }
                //..........furniture
            case 3:
                System.out.println("energy_consumption,guarantee(1) or not(2)");
                int energy_consumption = x.nextInt();
                int G = x.nextInt();
                boolean guarantee = false;
                if (G == 1) {
                    guarantee = true;
                }
                System.out.println("TV(1) , Fridge(2) , Stove(3)");
                int furniture = x.nextInt();
                switch (furniture) {
                    case 1:
                        System.out.println("resolution, size");
                        String resolution = x.next();
                        int size = x.nextInt();
                        ManagerControl.productRequest.add(new TV(code, name, company, price, description, energy_consumption, guarantee, resolution, size));
                    case 2:
                        System.out.println("capacity, brand, freezer(1) or not(2)");
                        int capacity = x.nextInt();
                        String brand = x.next();
                        int F = x.nextInt();
                        boolean freezer = false;
                        if (F == 1) {
                            freezer = true;
                        }
                        ManagerControl.productRequest.add(new Fridge(code, name, company, price, description, energy_consumption, guarantee, capacity, brand, freezer));
                    case 3:
                        System.out.println("flame, material, oven(1) or not(2)");
                        int flame = x.nextInt();
                        String materia = x.next();
                        int o = x.nextInt();
                        boolean oven = false;
                        if (o == 1) {
                            oven = true;
                        }
                        ManagerControl.productRequest.add(new Stove(code, name, company, price, description, energy_consumption, guarantee, flame, materia, oven));

                }
                //..........eat
            case 4:
                System.out.println("pro, exp");
                String pro = x.next();
                String exp = x.next();
                ManagerControl.productRequest.add(new Eatable(code, name, company, price, description, pro, exp));


        }
        Seller_panel(user);
    }

    public  void  Manager_panel() throws IOException, SQLException {
        System.out.println("See adding seller requests 1 and adding product requests 2");
        System.out.println("To go back to login page enter 0");
        int e =0;
        try{
            e = x.nextInt();
        }
        catch (InputMismatchException c){
            System.out.println("invalid input");
            x = new Scanner(System.in);
            Control_Panel();
        }        switch (e) {
            case 1:
                ManagerControl.SHsellerAcceptoin();
                System.out.println("Enter request code.");
                System.out.println("Accept 1  ;  Reject 0");
                int cod = x.nextInt();
                int p2 = x.nextInt();
                ManagerControl.sellerAcceptoin(p2,cod);
                break;
            case 2:
                ManagerControl.SHaddProduct();
                System.out.println("Enter request code.");
                System.out.println("Accept 1  ;  Reject 0 ");
                int code = x.nextInt();
                int p = x.nextInt();
                ManagerControl.AddProduct(p,code);
                break;
            case 0:
                Login();
                break;
        }
    }

    public void Edit(String user, int n) throws SQLException {
        System.out.println("Enter your new name and family,email and phone number.");
        String name = x.next();
        String family = x.next();
        String email = x.next();
        String phone = x.next();
        switch (n) {
            case 1:
                BuyerControl.edit(user, name, family, email, phone);
            case 2:
                SellerControl.edit(user, name, family, email, phone);
        }
    }
}
