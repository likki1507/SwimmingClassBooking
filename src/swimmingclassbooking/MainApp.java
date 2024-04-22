
package swimmingclassbooking;

import java.util.Scanner;


public class MainApp {

    public static Scanner user_input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("\n-----------------------------  Welcome to Panel : HJJS ----------------------------------- ");
        int choice;
        do {
            choice = menuFunctions();
            switch (choice) {
                case 1 -> SwimmingLessons.filterLessons();
                case 2 -> SwimmingLearners.registerNewLearner();
                case 3 -> SwimmingLessons.filterLessons();
                case 4 -> {
                       int bookingID = SwimmingBookings.inputBookingDataToBookClass();

                       if(bookingID != 0){
                           SwimmingBookings.cancelBooking(bookingID);
                           System.out.println("\nYour Booked class with booking ID '"+bookingID+"' has been cancelled now by you.");
                       }
                    }
                case 5 -> {
                            int bookingID = SwimmingBookings.inputBookingDataToBookClass();
                            if(bookingID != 0){
                                Constants.changeBooking = 1;
                                Constants.bkngId = bookingID;
                                SwimmingLessons.filterLessons();
                            }
                            
                           Constants.changeBooking = 0;
                           Constants.bkngId = 0;
                        }
           
                case 6 -> {
                            int bookingCode = SwimmingBookings.inputBookingDataToBookClass();;

                            if(bookingCode != 0){
                                SwimmingLessonRatings.addFeedbackForCoach(bookingCode);
                                System.out.println("\nThanks! Your feedback is important for us.");
                            }
                        }
                case 7 -> SwimmingBookings.viewBookingListOption();
                case 8 -> monthlyReports();
               
                case 9 ->{
                             System.out.println("\nProgram Exited\n\n");
                             System.exit(0);
                        }
                default -> System.out.println("\nPlease enter a valid choice (1-9)");
            }
        } while (choice != 9);
    }
    
    
    //menu Functions
    private static int menuFunctions(){
        System.out.println("\nMake a choice from below menu : ");
        System.out.println("1. View Timetable");             
        System.out.println("2. Register As a New Learner");
        System.out.println("3. Book a Swimming Class");        
        System.out.println("4. Cancel Already Booked Swimming Class");
        System.out.println("5. Update Already Booked Swimming Class");
        System.out.println("6. Attend Class and Give Feedback");
        System.out.println("7. View Bookings");
        System.out.println("8. Monthly Report Data ");
        System.out.println("9. Exit");
        
        String choice  = "";
        
        /* Validation for Menu Options */
        while (true) {
            System.out.print("\nEnter Correct Choice : ");
            choice = user_input.nextLine();
            if (choice.isEmpty()) {
                System.out.println("\nSelect Choice from above menu only : ");
            } else if (!validDigit(choice)) {
                System.out.println("\nMust be a digit. ");
            } else {
                break;
            }
        }
        return Integer.parseInt(choice);
    }
    
                     
    //option is valid digit ?
    public static boolean validDigit(String optn) {
        for (char c : optn.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    
    //Monthly Reports of Learner & Coach
    private static void monthlyReports(){
        System.out.println("\nMake a choice from below menu to retrieve report data : ");
        System.out.println("\n1. for Coach Report Data");
        System.out.println("2. for Learner Report Data");
        
        System.out.print("\nSelect your choice : ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        
        if (!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !validDigit(choice)) {
            System.out.println("Your choice of option is incorrect");
            return;
        }
        
        MonthlyReportIntermediator intermediator = new MonthlyReportIntermediator();
        intermediator.retrieveReports(choice);      
    }
    
}
