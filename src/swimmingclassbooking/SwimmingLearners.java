
package swimmingclassbooking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class SwimmingLearners {
    
     
    private int learnerID;
    private int gradeLevel;
    private int age;
    private String learnerName;
    private String learnerPhone;
    private String uniquePassword;
    private String gender;

    public static ArrayList <SwimmingLearners> swimmingLearnerData = new ArrayList<>();

    public SwimmingLearners(int learnerID, int gradeLevel, int age, String learnerName, String learnerPhone, String uniquePassword, String gender) {
        this.learnerID = learnerID;
        this.gradeLevel = gradeLevel;
        this.age = age;
        this.learnerName = learnerName;
        this.learnerPhone = learnerPhone;
        this.uniquePassword = uniquePassword;
        this.gender = gender;
    }

    public int getLearnerID() {
        return learnerID;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public int getAge() {
        return age;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public String getLearnerPhone() {
        return learnerPhone;
    }

    public String getUniquePassword() {
        return uniquePassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    
    public static ArrayList<SwimmingLearners> getSwimmingLearnerData() {
        SwimmingLearners learner1 = new SwimmingLearners(1,1,5,"Edward","0114 245 6545","pass","Male");
        SwimmingLearners learner2 = new SwimmingLearners(2,2,7,"Elsie","01793 729112","pass","Female");
        SwimmingLearners learner3 = new SwimmingLearners(3,4,8,"Wilkinson","0845 026 9148","pass","Male");
        SwimmingLearners learner4 = new SwimmingLearners(4,3,9,"Mark","01582 664412","pass","Male");
        SwimmingLearners learner5 = new SwimmingLearners(5,3,11,"Parker","0131 554 4494","pass","Male");
        SwimmingLearners learner6 = new SwimmingLearners(6,5,10,"Jacob","0131 229 9821","pass","Male");
        SwimmingLearners learner7 = new SwimmingLearners(7,1,6,"Martin","01322 668526","pass","Male");
        SwimmingLearners learner8 = new SwimmingLearners(8,2,7,"Archie","0114 233 6121","pass","Female");
        SwimmingLearners learner9 = new SwimmingLearners(9,4,8,"Harris","01227 766266","pass","Male");
        SwimmingLearners learner10 = new SwimmingLearners(10,1,9,"Eva","01202 587692","pass","Male");
        SwimmingLearners learner11 = new SwimmingLearners(11,2,4,"Richards","07710 994154","pass","Male");
        SwimmingLearners learner12 = new SwimmingLearners(12,3,7,"Stevens","01444 417050","pass","Male");
        SwimmingLearners learner13 = new SwimmingLearners(13,3,6,"Sabrina","01925 730893","pass","Female");
        SwimmingLearners learner14 = new SwimmingLearners(14,4,8,"Paul","01782 710551","pass","Male");
        SwimmingLearners learner15 = new SwimmingLearners(15,1,9,"Keith","01472 697000","pass","Male");
        
        SwimmingLearners.swimmingLearnerData.add(learner1);
        SwimmingLearners.swimmingLearnerData.add(learner2);
        SwimmingLearners.swimmingLearnerData.add(learner3);
        SwimmingLearners.swimmingLearnerData.add(learner4);
        SwimmingLearners.swimmingLearnerData.add(learner5);
        SwimmingLearners.swimmingLearnerData.add(learner6);
        SwimmingLearners.swimmingLearnerData.add(learner7);
        SwimmingLearners.swimmingLearnerData.add(learner8);
        SwimmingLearners.swimmingLearnerData.add(learner9);
        SwimmingLearners.swimmingLearnerData.add(learner10);
        SwimmingLearners.swimmingLearnerData.add(learner11);
        SwimmingLearners.swimmingLearnerData.add(learner12);
        SwimmingLearners.swimmingLearnerData.add(learner13);
        SwimmingLearners.swimmingLearnerData.add(learner14);
        SwimmingLearners.swimmingLearnerData.add(learner15);
        
        return swimmingLearnerData;
    }

    
        //New Learner
    public static void registerNewLearner(){
        Scanner sc = new Scanner(System.in);
        
        //Full Name
        System.out.print("\nPlease Enter Full Name : ");
        String firstName = sc.nextLine();
        
        if(firstName.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Enter Full Name : ");
                firstName = sc.nextLine();
            }while(firstName.equalsIgnoreCase(""));
        }
   
        //Secret Code
        System.out.print("\nPlease Enter Password : ");
        String secretCode = sc.nextLine();
        
        if(secretCode.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Enter Password : ");
                secretCode = sc.nextLine();
            }while(secretCode.equalsIgnoreCase(""));
        }
        
        //Grade Level
        System.out.print("\nPlease Enter Grade Level (1 - 5) : ");
        String grade = sc.nextLine();
         
        if(grade.equalsIgnoreCase("") || !MainApp.validDigit(grade)
                || (Integer.parseInt(grade) < Constants.MINIMUM_LEVEL || Integer.parseInt(grade) > Constants.MAXIMUM_LEVEL)){
            do{
                System.out.print("\nPlease Enter Valid Grade Level : ");
                grade = sc.nextLine();
            }while(grade.equalsIgnoreCase("") || !MainApp.validDigit(grade) 
                    || (Integer.parseInt(grade) < Constants.MINIMUM_LEVEL || Integer.parseInt(grade) > Constants.MAXIMUM_LEVEL));
        }
        
        //Contact
        System.out.print("\nPlease Enter Phone No : ");
        String contact = sc.nextLine();
        
        if(contact.equalsIgnoreCase("")){
            do{
                System.out.print("\nPlease Enter Phone No : ");
                contact = sc.nextLine();
            }while(contact.equalsIgnoreCase(""));
        }
        
        //Gender
        System.out.print("\nPlease Enter Gender : ");
        String gender = sc.nextLine();
        
        if(gender.equalsIgnoreCase("") || !(gender.equalsIgnoreCase("M") ||
                gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Male") 
                || gender.equalsIgnoreCase("Female") )){
            do{
                System.out.print("\nPlease Enter Valid Gender : ");
                gender = sc.nextLine();
            }while(gender.equalsIgnoreCase("") || !(gender.equalsIgnoreCase("M") ||
                    gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Male") 
                || gender.equalsIgnoreCase("Female")));
        }
           
        //Age
        System.out.print("\nPlease Enter Age : ");
        String age = sc.nextLine();
         
        if(age.equalsIgnoreCase("") || !MainApp.validDigit(age) || 
                Integer.parseInt(age) < Constants.MINIMUM_AGE || Integer.parseInt(age) > Constants.MAXIMUM_AGE){
            do{
                System.out.print("\nPlease Enter Valid Age : ");
                age = sc.nextLine();
            }while(age.equalsIgnoreCase("") || !MainApp.validDigit(age) 
                    || Integer.parseInt(age) < Constants.MINIMUM_AGE || Integer.parseInt(age) > Constants.MAXIMUM_AGE);
        }

        //RollNumber
        Random random = new Random();
        int uniqID = random.nextInt(900) + 100; 
        
        //Add New Learner
        SwimmingLearners obj = new SwimmingLearners(uniqID,Integer.parseInt(grade),Integer.parseInt(age),firstName,
                contact,secretCode,gender);
        SwimmingLearners.swimmingLearnerData.add(obj);
        System.out.println("\nNew Learner has been registered with Unique ID : "+uniqID);
    }
    
    
    
    //Display Learners List
    public static void viewLearnerList(){
        ArrayList<SwimmingLearners> ldata = SwimmingLearners.getSwimmingLearnerData();
        
        System.out.println("\n\n--------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-12s | %-12s  |\n",
                "Unique ID","Current Grade","Full Name", "Phone No", "Gender", "Age");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        Set<String> uniqueData = new HashSet<>(); 
        for(SwimmingLearners obj : ldata){
           if (!uniqueData.contains(String.valueOf(obj.getLearnerID()))){

                uniqueData.add(String.valueOf(obj.getLearnerID()));

                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-12s | %-12s  |\n",
                obj.getLearnerID(),obj.getGradeLevel(),obj.getLearnerName(), obj.getLearnerPhone(), 
                obj.getGender(), obj.getAge());
                System.out.println("--------------------------------------------------------------------------------------------------------");
           }
       }
    }
    
    
}
