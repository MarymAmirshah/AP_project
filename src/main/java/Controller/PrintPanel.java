package Controller;

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

public class PrintPanel {
    static public void PrintDigit(DigitProduct x)
    {
        System.out.println(((DigitProduct)x).toString());
    }
    static public void PrintClothing(Clothing x)
    {
        System.out.println(x.toString());
    }
    static public void PrintFurniture(Furniture x)
    {
        System.out.println(x.toString());
    }
    static public void PrintEatable(Eatable x)
    {
        System.out.println(x.toString());
    }
    static  public void PrintMobile(Mobile x)
    {
        System.out.println(x.toString());
    }
    static  public void PrintLaptop(Laptop x)
    {
        System.out.println(x.toString());
    }
    static public void PrintCloth(Clothes x)
    {
        System.out.println(x.toString());
    }
    static public void PrintShoe(Shoe x)
    {
        System.out.println(x.toString());
    }
    static public void PrintFridge(Fridge x)
    {
        System.out.println(x.toString());
    }
    static public void PrintTV(TV x)
    {
        System.out.println(x.toString());
    }
    static public void PrintStove(Stove x)
    {
        System.out.println(x.toString());
    }

}
