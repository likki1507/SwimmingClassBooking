
package swimmingclassbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SwimmingLessonRatings {
    
    
    private int bookingID;
    private int learnerID;
    private int numOfRating;
    private String feedbackToCoach;
    private int feedbackGivenTo;
    
    
     public static ArrayList <SwimmingLessonRatings> swimmigLessonRatingData = new ArrayList<>();

    public SwimmingLessonRatings(int bookingID, int learnerID, int numOfRating, String feedbackToCoach, int feedbackGivenTo) {
        this.bookingID = bookingID;
        this.learnerID = learnerID;
        this.numOfRating = numOfRating;
        this.feedbackToCoach = feedbackToCoach;
        this.feedbackGivenTo = feedbackGivenTo;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getLearnerID() {
        return learnerID;
    }

    public int getNumOfRating() {
        return numOfRating;
    }

    public String getFeedbackToCoach() {
        return feedbackToCoach;
    }

    public int getFeedbackGivenTo() {
        return feedbackGivenTo;
    }

    public static ArrayList<SwimmingLessonRatings> getSwimmigLessonRatingData() {
        return swimmigLessonRatingData;
    }
     
     
    //Feedback for coach
    public static void addFeedbackForCoach(int bookingID){
        
        int learnerunqID = 0;
        int lessonUnqID = 0;
        int coachNum = 0;
        List<SwimmingBookings> swimmingBookingData = SwimmingBookings.getSwimmingBookingData();
        List<SwimmingLessons> swimmingLessonData = SwimmingLessons.getSwimmingLessonData();
        List<SwimmingLearners> swimmingLearneswimmingRaringdata = SwimmingLearners.getSwimmingLearnerData();
        
        
        for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getBookignID() == bookingID){
                learnerunqID = obj.getLearnerID();
                lessonUnqID = obj.getLessonID();
                break;
            }
        }
        for(SwimmingLessons lobj : swimmingLessonData){
            if(lobj.getLessonNo() == lessonUnqID){
                coachNum = lobj.getTrainedBy();
                break;
            }
        }
        
        //Feedback
        Scanner sc = new Scanner(System.in);

        System.out.print("\nWrite Feedback for Coach : ");
        String feedbback = sc.nextLine();
        
         if(feedbback.equalsIgnoreCase("")){
            do{
                System.out.print("\nWrite Feedback for Coach : ");
                feedbback = sc.nextLine();
            }while(feedbback.equalsIgnoreCase(""));
        }
         
        //Take Rating
        System.out.print("\nEnter Rating between 1 to 5 : ");
        String numOfRating = sc.nextLine();
        
        if(numOfRating.equalsIgnoreCase("") || !MainApp.validDigit(numOfRating) || 
                (Integer.parseInt(numOfRating) < Constants.MINIMUM_RATING || Integer.parseInt(numOfRating) > Constants.MAXIMUM_RATING)){
            do{
                System.out.print("\nPlease Enter Valid Rating between 1 to 5 : ");
                numOfRating = sc.nextLine();
            }while(numOfRating.equalsIgnoreCase("") || !MainApp.validDigit(numOfRating) || 
                (Integer.parseInt(numOfRating) < Constants.MINIMUM_RATING || Integer.parseInt(numOfRating) > Constants.MAXIMUM_RATING));
        }
        
        SwimmingLessonRatings o = new SwimmingLessonRatings(bookingID,learnerunqID,Integer.parseInt(numOfRating),
                feedbback,coachNum);
        SwimmingLessonRatings.swimmigLessonRatingData.add(o);
        
         for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getBookignID() == bookingID){
                obj.setStatus(Constants.BOOKING_ATTEND);
                break;
            }
        }
         
        //Update seats by adding by 1
        VerifyFunctionality.setNoOfSeatsOfLessons(lessonUnqID,1,0);
        
           //Get Learner Grade
        int currentGrade = VerifyFunctionality.retrieveLearnerGrade(learnerunqID);
        
        for(SwimmingLearners obj2 : swimmingLearneswimmingRaringdata){
            if(obj2.getLearnerID() == learnerunqID){
                currentGrade = obj2.getGradeLevel();
                break;
            }
        }
        
        //Get Class Grade
        List<SwimmingLessons> swimmingLessondata = SwimmingLessons.getSwimmingLessonData();
        int classLevel = 0;
        for(SwimmingLessons obj : swimmingLessondata){
            if(obj.getLessonNo() == lessonUnqID){
                classLevel = obj.getGradeLevel();
                break;
            }
        }
        
        boolean isUpdated = false;
        
        if(classLevel > currentGrade){
            isUpdated = true;
        }
        
        if(isUpdated){
            VerifyFunctionality.incLearnerGradeLevel(learnerunqID);
        }
       
        return;
    }
    
     
    
}
