package account;

import java.util.ArrayList;

public class SellerControl {
    static ArrayList<Seller> sellers = new ArrayList<Seller>();

    public SellerControl(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public static boolean find(String user, int pass) {
        boolean found = false;
        for (int i = 0; i < sellers.size(); i++) {
            if (sellers.get(i).getUser_name().equals(user)) {
                if (sellers.get(i).getCode() == pass) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public static void edit(String user, String name, String family, String email, String phone) {
        for (int i = 0; i < sellers.size(); i++) {
            if (sellers.get(i).getUser_name().equals(user)) {
                sellers.get(i).setName(name);
                sellers.get(i).setFamily(family);
                sellers.get(i).setEmail(email);
                sellers.get(i).setPhoneNum(phone);
            }
        }
    }
}

