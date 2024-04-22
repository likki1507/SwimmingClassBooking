
package swimmingclassbooking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SwimmingLessons {
    
    
    private int lessonNo;
    private String weekDay;
    private String lessonName;
    private int gradeLevel;
    private String classStartTime;
    private String classFinishTime;
    private String classDate;
    private int allowedMembers;
    private int trainedBy;

    public static ArrayList <SwimmingLessons> swimmingLessonData = new ArrayList<>();

    public SwimmingLessons(int lessonNo, String weekDay, String lessonName, int gradeLevel, String classStartTime, String classFinishTime, 
            String classDate, int allowedMembers, int trainedBy) {
        this.lessonNo = lessonNo;
        this.weekDay = weekDay;
        this.lessonName = lessonName;
        this.gradeLevel = gradeLevel;
        this.classStartTime = classStartTime;
        this.classFinishTime = classFinishTime;
        this.classDate = classDate;
        this.allowedMembers = allowedMembers;
        this.trainedBy = trainedBy;
    }

    public int getLessonNo() {
        return lessonNo;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public String getLessonName() {
        return lessonName;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public String getClassStartTime() {
        return classStartTime;
    }

    public String getClassFinishTime() {
        return classFinishTime;
    }

    public String getClassDate() {
        return classDate;
    }

    public int getAllowedMembers() {
        return allowedMembers;
    }

    public int getTrainedBy() {
        return trainedBy;
    }

    public static ArrayList<SwimmingLessons> getSwimmingLessonData() {
        SwimmingLessons s1 = new SwimmingLessons(1,"monday","Introduction to Water Skills",1,"4pm",
                "5pm","29-04-2024",Constants.ALLOWED_MEMBERS,1);
        SwimmingLessons s2 = new SwimmingLessons(2,"monday","Stroke Improvement",2,"5pm",
                "6pm","29-04-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s3 = new SwimmingLessons(3,"monday"," Stroke Refinement",3,"6pm",
                "7pm","29-04-2024",Constants.ALLOWED_MEMBERS,3);

        SwimmingLessons s4 = new SwimmingLessons(4,"wednesday","Introduction to Water Skills",5,"4pm",
                "5pm","01-05-2024",Constants.ALLOWED_MEMBERS,4);
        SwimmingLessons s5 = new SwimmingLessons(5,"wednesday","Stroke Improvement",4,"5pm",
                "6pm","01-05-2024",Constants.ALLOWED_MEMBERS,5);
        SwimmingLessons s6 = new SwimmingLessons(6,"wednesday"," Stroke Refinement",3,"6pm",
                "7pm","01-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s7 = new SwimmingLessons(7,"friday","Introduction to Water Skills",1,"4pm",
                "5pm","03-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s8 = new SwimmingLessons(8,"friday","Stroke Improvement",2,"5pm",
                "6pm","03-05-2024",Constants.ALLOWED_MEMBERS,3);
        SwimmingLessons s9 = new SwimmingLessons(9,"friday"," Stroke Refinement",3,"6pm",
                "7pm","03-05-2024",Constants.ALLOWED_MEMBERS,4);
        
        SwimmingLessons s10 = new SwimmingLessons(10,"saturday","Stroke Improvement",5,"2pm",
                "3pm","04-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s11 = new SwimmingLessons(11,"saturday"," Stroke Refinement",1,"3pm",
                "4pm","04-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s12 = new SwimmingLessons(12,"monday","Introduction to Water Skills",1,"4pm",
                "5pm","06-05-2024",Constants.ALLOWED_MEMBERS,5);
        SwimmingLessons s13 = new SwimmingLessons(13,"monday","Stroke Improvement",2,"5pm",
                "6pm","06-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s14 = new SwimmingLessons(14,"monday"," Stroke Refinement",3,"6pm",
                "7pm","06-05-2024",Constants.ALLOWED_MEMBERS,3);

        SwimmingLessons s15 = new SwimmingLessons(15,"wednesday","Introduction to Water Skills",5,"4pm",
                "5pm","08-05-2024",Constants.ALLOWED_MEMBERS,4);
        SwimmingLessons s16 = new SwimmingLessons(16,"wednesday","Stroke Improvement",4,"5pm",
                "6pm","08-05-2024",Constants.ALLOWED_MEMBERS,5);
        SwimmingLessons s17 = new SwimmingLessons(17,"wednesday"," Stroke Refinement",3,"6pm",
                "7pm","08-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s18 = new SwimmingLessons(18,"friday","Introduction to Water Skills",1,"4pm",
                "5pm","10-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s19 = new SwimmingLessons(19,"friday","Stroke Improvement",2,"5pm",
                "6pm","10-05-2024",Constants.ALLOWED_MEMBERS,3);
        SwimmingLessons s20 = new SwimmingLessons(20,"friday"," Stroke Refinement",3,"6pm",
                "7pm","10-05-2024",Constants.ALLOWED_MEMBERS,4);
        
        SwimmingLessons s21 = new SwimmingLessons(21,"saturday","Stroke Improvement",5,"2pm",
                "3pm","11-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s22 = new SwimmingLessons(22,"saturday"," Stroke Refinement",1,"3pm",
                "4pm","11-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s23 = new SwimmingLessons(23,"monday","Introduction to Water Skills",1,"4pm",
                "5pm","13-05-2024",Constants.ALLOWED_MEMBERS,1);
        SwimmingLessons s24 = new SwimmingLessons(24,"monday","Stroke Improvement",2,"5pm",
                "6pm","13-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s25 = new SwimmingLessons(25,"monday"," Stroke Refinement",3,"6pm",
                "7pm","13-05-2024",Constants.ALLOWED_MEMBERS,3);

        SwimmingLessons s26 = new SwimmingLessons(26,"wednesday","Introduction to Water Skills",5,"4pm",
                "5pm","15-05-2024",Constants.ALLOWED_MEMBERS,4);
        SwimmingLessons s27 = new SwimmingLessons(27,"wednesday","Stroke Improvement",4,"5pm",
                "6pm","15-05-2024",Constants.ALLOWED_MEMBERS,5);
        SwimmingLessons s28 = new SwimmingLessons(28,"wednesday"," Stroke Refinement",3,"6pm",
                "7pm","15-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s29 = new SwimmingLessons(29,"friday","Introduction to Water Skills",1,"4pm",
                "5pm","17-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s30 = new SwimmingLessons(30,"friday","Stroke Improvement",2,"5pm",
                "6pm","17-05-2024",Constants.ALLOWED_MEMBERS,3);
        SwimmingLessons s31 = new SwimmingLessons(31,"friday"," Stroke Refinement",3,"6pm",
                "7pm","17-05-2024",Constants.ALLOWED_MEMBERS,4);
        
        SwimmingLessons s32 = new SwimmingLessons(32,"saturday","Stroke Improvement",5,"2pm",
                "3pm","18-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s33 = new SwimmingLessons(33,"saturday"," Stroke Refinement",1,"3pm",
                "4pm","18-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s34 = new SwimmingLessons(34,"monday","Introduction to Water Skills",1,"4pm",
                "5pm","13-05-2024",Constants.ALLOWED_MEMBERS,1);
        SwimmingLessons s35 = new SwimmingLessons(35,"monday","Stroke Improvement",2,"5pm",
                "6pm","13-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s36 = new SwimmingLessons(36,"monday"," Stroke Refinement",3,"6pm",
                "7pm","13-05-2024",Constants.ALLOWED_MEMBERS,3);

        SwimmingLessons s37 = new SwimmingLessons(37,"wednesday","Introduction to Water Skills",5,"4pm",
                "5pm","15-05-2024",Constants.ALLOWED_MEMBERS,4);
        SwimmingLessons s38 = new SwimmingLessons(38,"wednesday","Stroke Improvement",4,"5pm",
                "6pm","15-05-2024",Constants.ALLOWED_MEMBERS,5);
        SwimmingLessons s39 = new SwimmingLessons(39,"wednesday"," Stroke Refinement",3,"6pm",
                "7pm","15-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons s40 = new SwimmingLessons(40,"friday","Introduction to Water Skills",1,"4pm",
                "5pm","17-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s41 = new SwimmingLessons(41,"friday","Stroke Improvement",2,"5pm",
                "6pm","17-05-2024",Constants.ALLOWED_MEMBERS,3);
        SwimmingLessons s42 = new SwimmingLessons(42,"friday"," Stroke Refinement",3,"6pm",
                "7pm","17-05-2024",Constants.ALLOWED_MEMBERS,4);
        
        SwimmingLessons s43 = new SwimmingLessons(43,"saturday","Stroke Improvement",5,"2pm",
                "3pm","18-05-2024",Constants.ALLOWED_MEMBERS,2);
        SwimmingLessons s44 = new SwimmingLessons(44,"saturday"," Stroke Refinement",1,"3pm",
                "4pm","18-05-2024",Constants.ALLOWED_MEMBERS,1);
        
        SwimmingLessons.swimmingLessonData.add(s1);
        SwimmingLessons.swimmingLessonData.add(s2);
        SwimmingLessons.swimmingLessonData.add(s3);
        SwimmingLessons.swimmingLessonData.add(s4);
        SwimmingLessons.swimmingLessonData.add(s5);
        SwimmingLessons.swimmingLessonData.add(s6);
        SwimmingLessons.swimmingLessonData.add(s7);
        SwimmingLessons.swimmingLessonData.add(s8);
        SwimmingLessons.swimmingLessonData.add(s9);
        SwimmingLessons.swimmingLessonData.add(s10);
        SwimmingLessons.swimmingLessonData.add(s11);
        SwimmingLessons.swimmingLessonData.add(s12);
        SwimmingLessons.swimmingLessonData.add(s13);
        SwimmingLessons.swimmingLessonData.add(s14);
        SwimmingLessons.swimmingLessonData.add(s15);
        SwimmingLessons.swimmingLessonData.add(s16);
        SwimmingLessons.swimmingLessonData.add(s17);
        SwimmingLessons.swimmingLessonData.add(s18);
        SwimmingLessons.swimmingLessonData.add(s19);
        SwimmingLessons.swimmingLessonData.add(s20);
        SwimmingLessons.swimmingLessonData.add(s21);
        SwimmingLessons.swimmingLessonData.add(s22);
        SwimmingLessons.swimmingLessonData.add(s23);
        SwimmingLessons.swimmingLessonData.add(s24);
        SwimmingLessons.swimmingLessonData.add(s25);
        SwimmingLessons.swimmingLessonData.add(s26);
        SwimmingLessons.swimmingLessonData.add(s27);
        SwimmingLessons.swimmingLessonData.add(s28);
        SwimmingLessons.swimmingLessonData.add(s29);
        SwimmingLessons.swimmingLessonData.add(s30);
        SwimmingLessons.swimmingLessonData.add(s31);
        SwimmingLessons.swimmingLessonData.add(s32);
        SwimmingLessons.swimmingLessonData.add(s33);
        SwimmingLessons.swimmingLessonData.add(s34);
        SwimmingLessons.swimmingLessonData.add(s35);
        SwimmingLessons.swimmingLessonData.add(s36);
        SwimmingLessons.swimmingLessonData.add(s37);
        SwimmingLessons.swimmingLessonData.add(s38);
        SwimmingLessons.swimmingLessonData.add(s39);
        SwimmingLessons.swimmingLessonData.add(s40);
        SwimmingLessons.swimmingLessonData.add(s41);
        SwimmingLessons.swimmingLessonData.add(s42);
        SwimmingLessons.swimmingLessonData.add(s43);
        SwimmingLessons.swimmingLessonData.add(s44);
        
        return swimmingLessonData;
    }

    public void setAllowedMembers(int allowedMembers) {
        this.allowedMembers = allowedMembers;
    }

    //Lesson Filter Options
    private static int lessonFilterOptions(){
        System.out.println("\nSelect any choice form below menu => ");
        System.out.println("1. According to Day ");             
        System.out.println("2. According to Grade Level");        
        System.out.println("3. According to Coach");
        System.out.println("4. All Lessons");
        System.out.println("5. Back To Main Menu");
        
        String choice  = "";
        
        /* Validation for Menu Options */
        while (true) {
            System.out.print("\nEnter Valid Option : ");
            choice = MainApp.user_input.nextLine();
            if (choice.isEmpty()) {
                System.out.println("\nPlease Select Choice. ");
            } else if (!MainApp.validDigit(choice)) {
                System.out.println("\nMust be a digit ");
            } else {
                break;
            }
        }
        return Integer.parseInt(choice);
    }
    
    
    //Filter Schedule
    public static void filterLessons(){
        Constants.filterTimetable = 1;
        int choice;
        do {
            choice = lessonFilterOptions();
            switch (choice) {
                case 1 -> {
                       System.out.println("\n(Mon / Wed / Fri / Sat)");
                        System.out.print("Enter Weekday of your choice : ");
                        String weekdayChoice = MainApp.user_input.nextLine();

                        if(weekdayChoice.equalsIgnoreCase("")){
                            do{
                                System.out.print("\nPlease Enter Valid Weekday of your choice : ");
                                weekdayChoice = MainApp.user_input.nextLine();
                            }while(weekdayChoice.equalsIgnoreCase(""));
                        }

                        if(!(weekdayChoice.equalsIgnoreCase("Mon") || weekdayChoice.equalsIgnoreCase("Wed") || weekdayChoice.equalsIgnoreCase("Fri") ||
                                weekdayChoice.equalsIgnoreCase("Sat") || weekdayChoice.equalsIgnoreCase("Monday") || weekdayChoice.equalsIgnoreCase("Wednesday") 
                                || weekdayChoice.equalsIgnoreCase("Friday") || weekdayChoice.equalsIgnoreCase("Saturday"))){
                            do{
                                System.out.print("\nPlease enter valid weekday : ");
                                weekdayChoice = MainApp.user_input.nextLine();
                            }while(!(weekdayChoice.equalsIgnoreCase("Mon") || weekdayChoice.equalsIgnoreCase("Wed") || 
                                    weekdayChoice.equalsIgnoreCase("Fri") ||
                                weekdayChoice.equalsIgnoreCase("Sat") || weekdayChoice.equalsIgnoreCase("Monday") || weekdayChoice.equalsIgnoreCase("Wednesday") 
                                || weekdayChoice.equalsIgnoreCase("Friday") || weekdayChoice.equalsIgnoreCase("Saturday")));
                        }
                        
                        if(weekdayChoice.equalsIgnoreCase("Mon")){
                            weekdayChoice = "Monday";
                        }else if(weekdayChoice.equalsIgnoreCase("Wed")){
                            weekdayChoice = "Wednesday";
                        }else if(weekdayChoice.equalsIgnoreCase("Fri")){
                            weekdayChoice = "Friday";
                        }else if(weekdayChoice.equalsIgnoreCase("Sat")){
                            weekdayChoice = "Saturday";
                        }

                        viewLessonDetails(0,weekdayChoice,0);
                }
                case 2 -> {
                        System.out.println("\n(1 to 5)");
                        System.out.print("Please Enter Grade Level : ");
                        String gradeChoice = MainApp.user_input.nextLine();

                        if(gradeChoice.equalsIgnoreCase("") || !MainApp.validDigit(gradeChoice) || (Integer.parseInt(gradeChoice) < 0 
                                || Integer.parseInt(gradeChoice) > 5)){
                            do{
                                System.out.print("\nPlease Enter Valid Grade Level (1 to 5) : ");
                                gradeChoice = MainApp.user_input.nextLine();
                            }while(gradeChoice.equalsIgnoreCase("") || !MainApp.validDigit(gradeChoice) || (Integer.parseInt(gradeChoice) < 0 
                                    || Integer.parseInt(gradeChoice) > 5));
                        }
                        viewLessonDetails(Integer.parseInt(gradeChoice),"",0);
                }
                case 3 -> {   
                        System.out.println("\nSelect any Coach ID from below list : ");
                        SwimmingCoaches.viewCoachList();
        
                        System.out.print("Please Enter Coach Unique ID : ");
                        String selectedCoach = MainApp.user_input.nextLine();

                        if(selectedCoach.equalsIgnoreCase("") || !MainApp.validDigit(selectedCoach)){
                            do{
                                System.out.print("\nEnter valid Coach Unique ID : ");
                                selectedCoach = MainApp.user_input.nextLine();
                            }while(selectedCoach.equalsIgnoreCase("") || !MainApp.validDigit(selectedCoach));
                        }
                        
                        boolean isValidated = VerifyFunctionality.isCorrecrCoachID(Integer.parseInt(selectedCoach));

                        if(selectedCoach.equalsIgnoreCase("") || !isValidated || !MainApp.validDigit(selectedCoach)){
                            do{
                                System.out.print("\nEnter Valid Coach Unique ID : ");
                                selectedCoach = MainApp.user_input.nextLine();
                                 isValidated = VerifyFunctionality.isCorrecrCoachID(Integer.parseInt(selectedCoach));
                            }while(selectedCoach.equalsIgnoreCase("") || !isValidated || !MainApp.validDigit(selectedCoach));
                        }
                            
                        viewLessonDetails(0,"",Integer.parseInt(selectedCoach));
                }
                case 4 -> {                        
                    viewLessonDetails(0,"",0);
                }
                case 5 -> { 
                            Constants.changeBooking = 0;
                            Constants.classBooking = 0;
                            Constants.bkngId = 0;
                            return;
                         }
                default -> System.out.println("\nPlease enter a valid choice (1-4)");
            }
        } while (choice != 5);
        
    }
    
     
    //View Lesson details
    public static void viewLessonDetails(int gradeLevel, String day, int coahcUnqD){
                                   
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-20s | %-10s |\n",
                "LessonNo","Lesson", "WeekDay", "GradeLevel","StartTime","FinishTime", "LessonDate","Trained By", "Vacancy");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                              
        List<SwimmingLessons> swimmingLessonData = SwimmingLessons.getSwimmingLessonData();
        List<SwimmingCoaches> swimmingCoachData =SwimmingCoaches.getSwimmingCoachData();
        
      
        Set<String> uniqueData = new HashSet<>(); 
        for(SwimmingLessons obj : swimmingLessonData){
            if (!uniqueData.contains(String.valueOf(obj.getLessonNo()))){
                
                String coachname = "";
                for(SwimmingCoaches swimmingCoachObj : swimmingCoachData){
                    if(obj.getTrainedBy() == swimmingCoachObj.getCoachID()){
                        coachname = swimmingCoachObj.getCoachName();
                        break;
                    }
                }
        
                uniqueData.add(String.valueOf(obj.getLessonNo()));
                if(!day.equalsIgnoreCase("") && obj.getWeekDay().equalsIgnoreCase(day)){
                     System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-20s | %-10s |\n", 
                    obj.getLessonNo(),obj.getLessonName(), obj.getWeekDay(),"Grade - "+obj.getGradeLevel(), 
                    obj.getClassStartTime(), obj.getClassFinishTime(),obj.getClassDate(), 
                     coachname, obj.getAllowedMembers());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if(gradeLevel != 0 && obj.getGradeLevel() == gradeLevel){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-20s | %-10s |\n", 
                    obj.getLessonNo(),obj.getLessonName(), obj.getWeekDay(),"Grade - "+obj.getGradeLevel(), 
                    obj.getClassStartTime(), obj.getClassFinishTime(),obj.getClassDate(), 
                     coachname, obj.getAllowedMembers());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if(coahcUnqD != 0 && obj.getTrainedBy() == coahcUnqD){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-20s | %-10s |\n", 
                    obj.getLessonNo(),obj.getLessonName(), obj.getWeekDay(),"Grade - "+obj.getGradeLevel(), 
                    obj.getClassStartTime(), obj.getClassFinishTime(),obj.getClassDate(), 
                     coachname, obj.getAllowedMembers());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
                if(coahcUnqD == 0 && day.equalsIgnoreCase("") && gradeLevel == 0){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s |  %-12s | %-15s | %-20s | %-10s |\n", 
                    obj.getLessonNo(),obj.getLessonName(), obj.getWeekDay(),"Grade - "+obj.getGradeLevel(), 
                    obj.getClassStartTime(), obj.getClassFinishTime(),obj.getClassDate(), 
                     coachname, obj.getAllowedMembers());
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
        }
        
      
        //if change class
        if(Constants.filterTimetable == 1){
            if(Constants.changeBooking == 1){
               SwimmingBookings.inputChangeBookingData();
            // If book class
            }else{
                 SwimmingBookings.bookingNewLesson();
            }
        }
    }
    
    
}
