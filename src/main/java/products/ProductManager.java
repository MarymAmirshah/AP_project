package products;

import Controller.PrintPanel;
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

import java.util.ArrayList;

public class ProductManager {
    public static ArrayList<Product> products = new ArrayList<Product>();

    public static ArrayList<Product> getProducts() {
        return products;
    }
    static ArrayList<Product> all = ProductManager.getProducts();

    public static void search(String name)
    {
        int x = 0;
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equals(name)) {
                x = i;
                break;
            }
        }
        if (all.get(x) instanceof Mobile) {
            PrintPanel.PrintMobile((Mobile) all.get(x));
        } else if (all.get(x) instanceof Laptop) {
            PrintPanel.PrintLaptop((Laptop) all.get(x));
        } else if (all.get(x) instanceof Clothes) {
            PrintPanel.PrintCloth((Clothes) all.get(x));
        } else if (all.get(x) instanceof Shoe) {
            PrintPanel.PrintShoe((Shoe) all.get(x));
        } else if (all.get(x) instanceof Fridge) {
            PrintPanel.PrintFridge((Fridge) all.get(x));
        } else if (all.get(x) instanceof Stove) {
            PrintPanel.PrintStove((Stove) all.get(x));
        } else if (all.get(x) instanceof TV) {
            PrintPanel.PrintTV((TV) all.get(x));
        } else if (all.get(x) instanceof Eatable) {
            PrintPanel.PrintEatable((Eatable) all.get(x));
        }
    }
    public static ArrayList showAll(ArrayList<Product> all)
    {

        for (int i=0 ; i< all.size()-1 ; i++)
        {
            for (int j=1 ; j< all.size() ; j++)
            {
                if (all.get(i).compareTo(all.get(j))==-1)
                {
                    Product temp = all.get(j);
                    all.add(j , all.get(i));
                    all.add(i , temp);
                }
            }
        }
        return all;
    }
    public static void SortCategory(int s)
    {
        ArrayList<Product> all = ProductManager.getProducts();
        ArrayList<Product> especial = new ArrayList<>();

        switch (s) {
            case 1:
                for (int i = 0; i < all.size(); i++) {
                    if (all.get(i) instanceof DigitProduct)
                        especial.add(all.get(i));
                }
                ArrayList <Product> dig=showAll(especial);
                for (int z=0 ; z< dig.size();z++)
                   PrintPanel.PrintDigit((DigitProduct) dig.get(z));
                break;
            case 2:
                for (int i = 0; i < all.size(); i++) {
                    if (all.get(i) instanceof Clothing)
                        especial.add(all.get(i));
                }
                ArrayList <Product> clo=showAll(especial);
                for (int z=0 ; z< clo.size();z++)
                    PrintPanel.PrintClothing((Clothing) clo.get(z));
                break;
            case 3:
                for (int i = 0; i < all.size(); i++) {
                    if (all.get(i) instanceof Furniture)
                        especial.add(all.get(i));                }
                ArrayList <Product> fur=showAll(especial);
                for (int z=0 ; z< fur.size();z++)
                     PrintPanel.PrintFurniture((Furniture) fur.get(z));
                break;
            case 4:
                for (int i = 0; i < all.size(); i++) {
                    if (all.get(i) instanceof DigitProduct)
                        especial.add(all.get(i));
                }
                ArrayList <Product> eat=showAll(especial);
                for (int z=0 ; z< eat.size();z++)
                    PrintPanel.PrintEatable((Eatable) eat.get(z));
                break;
        }
    }

}
