
package swimmingclassbooking;

import java.util.ArrayList;


public class Receptionists {
    
    
    private int receptionistID;
    private String name;
    private String password;
    
    public static ArrayList <Receptionists> receptionistData = new ArrayList<>();

    public Receptionists(int receptionistID, String name, String password) {
        this.receptionistID = receptionistID;
        this.name = name;
        this.password = password;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Receptionists> getReceptionistData() {
        Receptionists obj = new Receptionists(501,"Reception","receptionCode");
        Receptionists.receptionistData.add(obj);
        return receptionistData;
    }
    
}
