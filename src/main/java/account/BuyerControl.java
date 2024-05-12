package account;

import Controller.Meno;
import Controller.MySQL;
import Exeption.InvalidEmail;
import Exeption.InvalidTelephone;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class BuyerControl {
    static ArrayList<Buyer> consumers = new ArrayList<Buyer>();
    // check Exeption
    static String regex= "^[A-Za-z0-9+_.-]+@(.+)$";
    static Pattern pattern= compile (regex);

    static String Tregex= "\\d{11}$";
    static Pattern Tpattern = compile(Tregex);


    public BuyerControl(ArrayList<Buyer> consumers) {
        this.consumers = consumers;
    }

    public static void register(String user, String name, String family, String email, String phone, int pass,double money) throws IOException, SQLException {
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
                throw new InvalidTelephone();
            }
        } catch (InvalidTelephone e) {
            e.printStackTrace();

        }
        Buyer b=new Buyer(user, name, family, email, phone, pass, money);
        consumers.add(b);

        FileOutputStream buyer = new FileOutputStream("E:\\uni project\\Data\\Account\\Buyer\\buyer.txt", true);
        Formatter F = new Formatter(buyer);
        F.format("%s\n%s\n%s\n%s\n%s\n%d\n%f\n",user, name, family, email, phone, pass, money );
        F.flush();
        buyer.close();
        F.close();

        String SQLCom = String.format("INSERT INTO customer(code , name,family name,money,user_name) values ("
        +"%d,'%s','%s',%f,'%s')",b.getId(),name,family,money,user);
        MySQL.getMySQL().Execute(SQLCom);
        String S = String.format("INSERT INTO emails(id, email) values("
                +"%d,'%s')" , b.getId(),email);
        MySQL.getMySQL().Execute(S);
        String Q = String.format("INSERT INTO emails(id , phone num) values ("
                +"%d,'%s')",b.getId() , phone);
        MySQL.getMySQL().Execute(Q);
    }
    public static boolean RepeatUser(String user)
    {
        boolean r= true;
        for (int i=0;i< consumers.size();i++)
        {
            if (consumers.get(i).getUser_name().equals(user))
            {
                r=false;
                break;
            }
        }
        return r;
    }

    public static ArrayList<Buyer> getConsumers() {
        return consumers;
    }

    public static boolean find(String user , int pass)
    {
        boolean found= false;
        for (int i=0 ; i<consumers.size(); i++ )
        {
            if (consumers.get(i).getUser_name().equals(user))
            {
                if (consumers.get(i).getCode()==pass)
                { found=true;
                    break;}
            }
        }
        return found;
    }
    public static void edit(String user , String name,String family,String email , String phone) throws SQLException {
        String sql;
        for (int i=0 ; i<consumers.size(); i++ )
        {
            if (consumers.get(i).getUser_name().equals(user))
            {
                consumers.get(i).setName(name);
                sql = String.format("UPDATE costumer SET name = '%s' WHERE code = %d",name, consumers.get(i).getId());
                MySQL.getMySQL().Execute(sql);
                consumers.get(i).setFamily(family);
                sql = String.format("UPDATE costumer SET family name = '%s' WHERE code = %d",family, consumers.get(i).getId());
                MySQL.getMySQL().Execute(sql);
                consumers.get(i).setEmail(email);
                sql = String.format("UPDATE emails SET email = '%s' WHERE id = %d",email, consumers.get(i).getId());
                MySQL.getMySQL().Execute(sql);
                consumers.get(i).setPhoneNum(phone);
                sql = String.format("UPDATE number SET phone num = '%s' WHERE id = %d",phone, consumers.get(i).getId());
                MySQL.getMySQL().Execute(sql);
            }}
    }
}


