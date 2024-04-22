
package swimmingclassbooking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SwimmingBookings {
    
    private int bookignID;
    private int learnerID;
    private int lessonID;
    private String status;
    
    public static ArrayList <SwimmingBookings> swimmingBookingData = new ArrayList<>();

    public SwimmingBookings(int bookignID, int learnerID, int lessonID, String status) {
        this.bookignID = bookignID;
        this.learnerID = learnerID;
        this.lessonID = lessonID;
        this.status = status;
    }

    public int getBookignID() {
        return bookignID;
    }

    public int getLearnerID() {
        return learnerID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public String getStatus() {
        return status;
    }

    public static ArrayList<SwimmingBookings> getSwimmingBookingData() {
        return swimmingBookingData;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
      
    
    //View Bookings Options by user role
    public static void viewBookingListOption(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nChoose an option from below menu to view bookings : ");

        System.out.println("\n1. As a Learner");
        System.out.println("2. As a Receptionist");
        System.out.print("\nYour Choice : ");

        String role = sc.nextLine();
        
        if(role.isEmpty() || !MainApp.validDigit(role) || 
                !(role.equals("1") || role.equals("2"))){
            do{
                System.out.print("\nYour Choice : ");
                role = sc.nextLine();
            }while(role.isEmpty() || !MainApp.validDigit(role) || 
                !(role.equals("1") || role.equals("2")));
        }
         
        
         boolean asReceptionist = false;
         boolean asLearner = false;
         String learnerUnqID = "";
         
         if(role.equalsIgnoreCase("1")){
               
            System.out.println("\nYou have to select learner from below list to view bookings : ");
            SwimmingLearners.viewLearnerList();
            
            asLearner = true;
            System.out.print("\nEnter Learner Unique ID to proceed further : ");
            learnerUnqID = sc.nextLine();

            //Validations
            if(learnerUnqID.equalsIgnoreCase("") || !MainApp.validDigit(learnerUnqID)){
                do{
                    System.out.print("\nEnter Valid Unique ID : ");
                    learnerUnqID = sc.nextLine();
                }while(learnerUnqID.equalsIgnoreCase("") || !MainApp.validDigit(learnerUnqID));
            }

            boolean isVerfied = VerifyFunctionality.isCorrectLearnerID(Integer.parseInt(learnerUnqID));

            if(learnerUnqID.equalsIgnoreCase("") || !isVerfied || !MainApp.validDigit(learnerUnqID)){
                do{
                    System.out.print("\nEnter Valid Unique ID : ");
                    learnerUnqID = sc.nextLine();
                    isVerfied = VerifyFunctionality.isCorrectLearnerID(Integer.parseInt(learnerUnqID));
                }while(learnerUnqID.equalsIgnoreCase("") || !isVerfied || !MainApp.validDigit(learnerUnqID));
            }

            System.out.print("\nEnter Your Password : ");
            String learnerpassword = sc.nextLine();

             //Validations
            if(learnerpassword.equalsIgnoreCase("")){
                do{
                    System.out.print("\nPEnter Your Password : ");
                    learnerpassword = sc.nextLine();
                }while(learnerpassword.equalsIgnoreCase(""));
            }

            boolean isVerfiedCode = VerifyFunctionality.compareLearnerDetails(Integer.parseInt(learnerUnqID),learnerpassword);

            if(!isVerfiedCode){
                System.out.println("\nNo Account Registered with given Credentials");
                return;
            }
            viewBookingList(Integer.parseInt(learnerUnqID));

         }else{
            asReceptionist = true;
            System.out.print("\nEnter Your Password : ");
            String learnerpassword = sc.nextLine();

             //Validations
            if(learnerpassword.equalsIgnoreCase("")){
                do{
                    System.out.print("\nEnter Your Password : ");
                    learnerpassword = sc.nextLine();
                }while(learnerpassword.equalsIgnoreCase(""));
            }

            boolean isVerfiedCode = VerifyFunctionality.isCorrectReceptionistID(learnerpassword);

            if(!isVerfiedCode){
                System.out.println("\nNo Account Registered with given Credentials");
                return;
            }
            viewBookingList(0);
         }
    }
    
    
    //Display Booking
    public static void viewBookingList(int learnerUnqID){
        
        List<SwimmingLessons> swimmingLessondata = SwimmingLessons.getSwimmingLessonData();
        List<SwimmingLearners> swimmingLearnerdata = SwimmingLearners.getSwimmingLearnerData();
        List<SwimmingCoaches> swimmingCoachdata = SwimmingCoaches.getSwimmingCoachData();
        List<SwimmingBookings> swimmingbookingdata = SwimmingBookings.getSwimmingBookingData();
         
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-15s | %-12s | %-30s | %-10s | %-8s | %-17s | %-18s | %-17s |  %-17s |\n",
                "Booking ID",  "Status",   "Lesson NO", 
                "Lesson Name", "Slot","WeekDay","Class Level","Trained By","Booked By","Learner Grade");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Set<Integer> unique = new HashSet<>(); 
        for (SwimmingBookings obj : swimmingbookingdata) {
            if (!unique.contains(obj.getBookignID())){
                unique.add(obj.getBookignID());
                
                //Booking By
                String fullname ="";
                int currentGrade = 0;
                for (SwimmingLearners swimmingLessonObj : swimmingLearnerdata) {
                    if(swimmingLessonObj.getLearnerID() == obj.getLearnerID()){
                        fullname = swimmingLessonObj.getLearnerName();
                        currentGrade = swimmingLessonObj.getGradeLevel();
                        break;
                    }
                }
                
                //Lesson Grade Level
                int swimmingLessonGrade = 0;
                String lessonName = "";
                String trainedBy = "";
                String swimmingLessonSlot = "";
                String weekday = "";
                for (SwimmingLessons swimmingLessonObj : swimmingLessondata) {
                    if(swimmingLessonObj.getLessonNo() == obj.getLessonID()){
                        
                        for(SwimmingCoaches swimmingCoachObj : swimmingCoachdata){
                            if(swimmingCoachObj.getCoachID() == swimmingLessonObj.getTrainedBy()){
                                trainedBy = swimmingCoachObj.getCoachName();
                                break;
                            }
                        }
                        swimmingLessonGrade = swimmingLessonObj.getGradeLevel();
                        lessonName = swimmingLessonObj.getLessonName();
                        weekday = swimmingLessonObj.getWeekDay();
                        swimmingLessonSlot = swimmingLessonObj.getClassStartTime()+"-"+swimmingLessonObj.getClassFinishTime();
                        break;
                    }
                }
                //if learner      
                 if(learnerUnqID != 0 && obj.getLearnerID() == learnerUnqID){
                    System.out.printf("| %-12s | %-15s | %-12s | %-30s | %-10s | %-8s | %-17s | %-18s | %-17s |  %-17s |\n",
                   obj.getBookignID(),  obj.getStatus(),   obj.getLessonID(), 
                   lessonName, swimmingLessonSlot,weekday,swimmingLessonGrade,trainedBy,fullname,currentGrade);
                    
                // if staff
                }else if (learnerUnqID == 0){
                     System.out.printf("| %-12s | %-15s | %-12s | %-30s | %-10s | %-8s | %-17s | %-18s | %-17s |  %-17s |\n",
                   obj.getBookignID(),  obj.getStatus(),   obj.getLessonID(), 
                   lessonName, swimmingLessonSlot,weekday,swimmingLessonGrade,trainedBy,fullname,currentGrade);
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    
      
    //Input Booking Data
    public static int inputBookingDataToBookClass(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Booking ID to Update Already Booked Class : ");
        String bookingCode = sc.nextLine();
                            
        if(bookingCode.equalsIgnoreCase("") || !MainApp.validDigit(bookingCode)){
            do{
                System.out.print("\nEnter Your Booking ID : ");
                bookingCode = sc.nextLine();
            }while(bookingCode.equalsIgnoreCase("") || !MainApp.validDigit(bookingCode));
        }

        boolean isBookingCodeFound = VerifyFunctionality.retrieveBookingID(Integer.parseInt(bookingCode));
        if(!isBookingCodeFound){
             System.out.println("\nBooking ID entered by you is incorrect");
             return 0;
        }
     
        //Is Booking Same Lesson
        boolean isAttendedOrCancelled = VerifyFunctionality.alreadyAttndOrCancelledBooking(Integer.parseInt(bookingCode));
        if(isAttendedOrCancelled){
             System.out.println("\nBooking that you are trying to change has already been cancelled or attended");
             return 0;
        }
       return Integer.parseInt(bookingCode);
    }
    
    
   
    //New Lesson Booking
    public static void bookingNewLesson(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Yes to book a new class : ");
        String choice = sc.nextLine();

        if(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")){
            Constants.classBooking = 1;
            
            System.out.println("\nSelect any Learner from below list : ");
            SwimmingLearners.viewLearnerList();

            System.out.print("\nEnter Learner Unique ID to book class :");
            String learnerUnqID = sc.nextLine();

            //Validations
            if(learnerUnqID.equalsIgnoreCase("") || !MainApp.validDigit(learnerUnqID)){
                do{
                    System.out.print("\nEnter Valid Learner Unique ID : ");
                    learnerUnqID = sc.nextLine();
                }while(learnerUnqID.equalsIgnoreCase("") || !MainApp.validDigit(learnerUnqID));
            }

            boolean isVerfied = VerifyFunctionality.isCorrectLearnerID(Integer.parseInt(learnerUnqID));

            if(learnerUnqID.equalsIgnoreCase("") || !isVerfied || !MainApp.validDigit(learnerUnqID)){
                do{
                    System.out.print("\nEnter Valid Learner Unique ID : ");
                    learnerUnqID = sc.nextLine();
                     isVerfied = VerifyFunctionality.isCorrectLearnerID(Integer.parseInt(learnerUnqID));
                }while(learnerUnqID.equalsIgnoreCase("") || !isVerfied || !MainApp.validDigit(learnerUnqID));
            }

            System.out.print("\nEnter Password : ");
            String learnerpassword = sc.nextLine();

             //Validations
            if(learnerpassword.equalsIgnoreCase("")){
                do{
                    System.out.print("\nEnter Password : ");
                    learnerpassword = sc.nextLine();
                }while(learnerpassword.equalsIgnoreCase(""));
            }

            boolean isVerfiedCode = VerifyFunctionality.compareLearnerDetails(Integer.parseInt(learnerUnqID),learnerpassword);

            if(!isVerfiedCode){
                System.out.println("\nNo Account Registered with given Credentials");
                return;
            }

            System.out.print("\nEnter Lesson No that you wish to book :");
            String lessonUnqID = sc.nextLine();

            //Validations
            if(lessonUnqID.equalsIgnoreCase("") || !MainApp.validDigit(lessonUnqID)){
                do{
                    System.out.print("\nEnter Lesson No that you wish to book : ");
                    lessonUnqID = sc.nextLine();
                }while(lessonUnqID.equalsIgnoreCase("") || !MainApp.validDigit(lessonUnqID));
            }

            boolean isVerfiedSchedule = VerifyFunctionality.isCorrectLesson(Integer.parseInt(lessonUnqID));

            if(!isVerfiedSchedule || !MainApp.validDigit(lessonUnqID)){
                do{
                    System.out.print("\nEnter Lesson No that you wish to book : ");
                    lessonUnqID = sc.nextLine();
                     isVerfiedSchedule = VerifyFunctionality.isCorrectLearnerID(Integer.parseInt(lessonUnqID));
                }while(!isVerfiedSchedule || !MainApp.validDigit(lessonUnqID));
            }

            SwimmingBookings.newClassByLearner(Integer.parseInt(learnerUnqID),Integer.parseInt(lessonUnqID));
            return;

        }else{
            return;
        }
    }


    //Book new Class
    public static void newClassByLearner(int learnerUnqID, int lessonUnqID){
        
        Random random = new Random();
        int bookingID = random.nextInt(1000);
 
        //Seat Availability
        int numOfSeats = VerifyFunctionality.isAvaillableLessonSeat(lessonUnqID);
        if(numOfSeats <= 0){
            System.out.println("\nThe lesson you are trying to book has no seat availlable.");
            return;
        }

        //Duplicate Lesson
        boolean duplicateLesson = VerifyFunctionality.duplicateLessonBooking(lessonUnqID,learnerUnqID);
        if(duplicateLesson){
            System.out.println("\nYou are trying to book lesson which has been already booked by you.");
            return;
        }

        //Is Booking Higher / Lower Grade Level
        boolean matchCurrentGradeWithClassGrade = VerifyFunctionality.compareLessonGradeWithCurrentGrade(lessonUnqID,learnerUnqID);
        int currentGrade = VerifyFunctionality.retrieveLearnerGrade(learnerUnqID);
        if(matchCurrentGradeWithClassGrade){
            if((currentGrade) < 5){
                System.out.println("\nYou have to book lesson with grade level "+currentGrade+" or "+(currentGrade+1));
            }else{
                System.out.println("\nYou have to book lesson with grade level "+currentGrade);
            }
            return;
        }

        SwimmingBookings obj = new SwimmingBookings(bookingID, learnerUnqID,lessonUnqID,Constants.BOOKING_BOOKED);
        SwimmingBookings.swimmingBookingData.add(obj);
        
        //Update seats by subtracting by 1
        VerifyFunctionality.setNoOfSeatsOfLessons(lessonUnqID,0,1);
        Constants.classBooking = 0;
        Constants.filterTimetable = bookingID;
        System.out.println("\nClass has been booked by you with booking ID : "+bookingID);

    }
    
    

    //Update class Info
    public static void inputChangeBookingData(){
             
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Lesson No that you wish to change :");
        String lessonUnqID = sc.nextLine();

        //Validations
        if(lessonUnqID.equalsIgnoreCase("") || !MainApp.validDigit(lessonUnqID)){
            do{
                System.out.print("\nEnter Lesson No that you wish to change : ");
                lessonUnqID = sc.nextLine();
            }while(lessonUnqID.equalsIgnoreCase("") || !MainApp.validDigit(lessonUnqID));
        }

        boolean isVerfiedSchedule = VerifyFunctionality.isCorrectLesson(Integer.parseInt(lessonUnqID));

        if(!isVerfiedSchedule || !MainApp.validDigit(lessonUnqID)){
            do{
                System.out.print("\nEnter Lesson No that you wish to change : ");
                lessonUnqID = sc.nextLine();
                 isVerfiedSchedule = VerifyFunctionality.isCorrectLearnerID(Integer.parseInt(lessonUnqID));
            }while(!isVerfiedSchedule || !MainApp.validDigit(lessonUnqID));
        }
        
        SwimmingBookings.updateBooking(Integer.parseInt(lessonUnqID));
        Constants.changeBooking = 0;
        System.out.println("\nYour class has been changed by you");
        return;
    }
    
   
    
    //Update a Booking
    public static void updateBooking(int lessonUnqID){
        
        int learnerUnqID = VerifyFunctionality.retrieveLearnerID(Constants.bkngId);
         
        //Seat Available
        int numOfSeats = VerifyFunctionality.isAvaillableLessonSeat(lessonUnqID);
        if(numOfSeats <= 0){
            System.out.println("\nThe lesson you are trying to book has no seat availlable.");
            return;
        }

        //Is Booking Same Lesson
        boolean duplicateLesson = VerifyFunctionality.duplicateLessonBooking(lessonUnqID,learnerUnqID);
        if(duplicateLesson){
            System.out.println("\nYou are trying to book lesson which has been already booked by you.");
            return;
        }

        //Is Booking Higher / Lower Grade Level
        boolean matchCurrentGradeWithClassGrade = VerifyFunctionality.compareLessonGradeWithCurrentGrade(lessonUnqID,learnerUnqID);
        int currentGrade = VerifyFunctionality.retrieveLearnerGrade(learnerUnqID);
        if(matchCurrentGradeWithClassGrade){
            if((currentGrade) < 5){
                System.out.println("\nYou have to book lesson with grade "+currentGrade+" or "+(currentGrade+1));
                return;
            }else{
                System.out.println("\nYou have to book lesson with grade "+currentGrade);
                return;
            }
        }

        List<SwimmingBookings> swimmingbookingdata = SwimmingBookings.getSwimmingBookingData();
        
        int prevLessonUnqID = 0;
        for(SwimmingBookings obj : swimmingbookingdata){
            if(obj.getBookignID() == Constants.bkngId){
                prevLessonUnqID = obj.getLessonID();
                obj.setStatus(Constants.BOOKING_CHANGE);
                obj.setLessonID(lessonUnqID);
            }
        }
        
        //Update seats by adding by 1
        VerifyFunctionality.setNoOfSeatsOfLessons(prevLessonUnqID,1,0);
        
        //Update seats by subtracting by 1
        VerifyFunctionality.setNoOfSeatsOfLessons(lessonUnqID,0,1);
        
        Constants.bkngId = 0;
    }
    
    
    
    //Cancel a Booking
    public static void cancelBooking(int bookingCode){
        ArrayList<SwimmingBookings> swimmingbookingdata = SwimmingBookings.getSwimmingBookingData();
        int lessonUnqID = 0;
        for(SwimmingBookings obj : swimmingbookingdata){
            if(obj.getBookignID() == bookingCode){
                lessonUnqID = obj.getLessonID();
                obj.setStatus(Constants.BOOKING_CANCEL);
            }
        }
            
        //Update seats by subtracting by 1
        VerifyFunctionality.setNoOfSeatsOfLessons(lessonUnqID,1,0);
    }
    

  
}
