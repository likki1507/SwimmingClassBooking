
package swimmingclassbooking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class SwimmingCoaches {
    
    private int coachID;
    private String coachName;
    private String phoneNo;
    private String gender;
    private int age;
    private String joinedAt;
    
    public static ArrayList <SwimmingCoaches> swimmingCoachData = new ArrayList<>();

    public SwimmingCoaches(int coachID, String coachName, String phoneNo, String gender, int age, String joinedAt) {
        this.coachID = coachID;
        this.coachName = coachName;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
        this.joinedAt = joinedAt;
    }

    public int getCoachID() {
        return coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public static ArrayList<SwimmingCoaches> getSwimmingCoachData() {
        SwimmingCoaches coach1 = new SwimmingCoaches (1,"Clarke","01472 361381","Male",41,"09May,2022");
        SwimmingCoaches coach2 = new SwimmingCoaches (2,"Neil","01634 827050","Male",36,"12June,2021");
        SwimmingCoaches coach3 = new SwimmingCoaches (3,"Jackson","01803 863490","Male",37,"28May,2020");
        SwimmingCoaches coach4 = new SwimmingCoaches (4,"Sophie","01274 561263","Male",42,"11July,2019");
        SwimmingCoaches coach5 = new SwimmingCoaches (5,"Sabrina","01322 284071","Female",31,"17Feb,2023");
        
        SwimmingCoaches.swimmingCoachData.add(coach1);
        SwimmingCoaches.swimmingCoachData.add(coach2);
        SwimmingCoaches.swimmingCoachData.add(coach3);
        SwimmingCoaches.swimmingCoachData.add(coach4);
        SwimmingCoaches.swimmingCoachData.add(coach5);
        
        return swimmingCoachData;
    }
    
    //View Coach List
    public static void viewCoachList(){
         ArrayList<SwimmingCoaches> swimmingCoachData = SwimmingCoaches.getSwimmingCoachData();
        
        System.out.println("\n\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-12s | %-12s | %-15s  |\n",
                "CoachUniqueID","Name", "PhoneNo", "Gender", "Age","Joined At");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        Set<String> uniqueData = new HashSet<>(); 
        for(SwimmingCoaches obj : swimmingCoachData){
           if (!uniqueData.contains(String.valueOf(obj.getCoachID()))){

                uniqueData.add(String.valueOf(obj.getCoachID()));

                System.out.printf("| %-15s | %-15s | %-15s | %-12s | %-12s | %-15s  |\n",
                        obj.getCoachID(),obj.getCoachName(), obj.getPhoneNo(),obj.getGender(), obj.getAge(), obj.getJoinedAt());
                System.out.println("--------------------------------------------------------------------------------------------------------");
           }
       }
    }
    
}
