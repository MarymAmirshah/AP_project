package account;

public abstract class Account {
    private String user_name;
    private String Name;
    private String Family;
    private String Email;
    private String PhoneNum;
    private int code;
    int ID=0;
    static int id=0;

    public Account(String user_name, String name, String family, String email, String phoneNum, int code) {
        this.user_name = user_name;
        Name = name;
        Family = family;
        Email = email;
        PhoneNum = phoneNum;
        this.code = code;
        id= ID++;
    }

    public int getId() {
        return id;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getName() {
        return Name;
    }

    public String getFamily() {
        return Family;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public int getCode() {
        return code;
    }
}
