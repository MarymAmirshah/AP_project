package account;

public class Manager{
    private static Manager singel =null;
    public static Manager getInstance()
    {
        if (singel== null)
            singel= new Manager();
        return singel;
    }

    private String user_name;
    private String Name;
    private String Family;
    private String Email;
    private int PhoneNum;
    private int pass;

    public Manager()
    {
        this.user_name="admin";
        this.Name="Maryam";
        this.Family="Amirshah";
        this.Email="gfjk@ldl";
        this.PhoneNum=123456100;
        this.pass=1111;

    }
}

