package Controller;

import java.io.File;

public class FileControl {
    static void fileCreat()
    {
        File Data = new File("E:\\uni project\\Data");
        if(!Data.exists())
            Data.mkdir();
        File Product = new File("E:\\uni project\\Data\\Product");
        if(!Product.exists())
            Product.mkdir();
        File Account = new File("E:\\uni project\\Data\\Account");
        if(!Account.exists())
            Account.mkdir();
        File Invoice = new File("E:\\uni project\\Data\\Invoice");
        if(!Invoice.exists())
            Invoice.mkdir();
        File Clothing= new File("E:\\uni project\\Data\\Product\\Clothing");
        if(!Clothing.exists())
            Clothing.mkdir();
        File Digit= new File("E:\\uni project\\Data\\Product\\Digit");
        if(!Digit.exists())
            Digit.mkdir();
        File Eatable= new File("E:\\uni project\\Data\\Product\\Eatable");
        if(!Eatable.exists())
            Eatable.mkdir();
        File Furniture= new File("E:\\uni project\\Data\\Product\\Furniture");
        if(!Furniture.exists())
            Furniture.mkdir();
        File Buyer = new File("E:\\uni project\\Data\\Account\\Buyer");
        if(!Buyer.exists())
            Buyer.mkdir();
        File Seller = new File("E:\\uni project\\Data\\Account\\Seller");
        if(!Seller.exists())
            Seller.mkdir();
        File PerchesInvoice = new File("E:\\uni project\\Data\\Invoice\\PerchesInvoice");
        if(!PerchesInvoice.exists())
            PerchesInvoice.mkdir();
        File SalesInvoice = new File("E:\\uni project\\Data\\Invoice\\SalesInvoice");
        if(!SalesInvoice.exists())
            SalesInvoice.mkdir();

    }
}
