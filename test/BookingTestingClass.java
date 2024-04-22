
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import swimmingclassbooking.Constants;
import swimmingclassbooking.SwimmingBookings;
import swimmingclassbooking.SwimmingLearners;
import swimmingclassbooking.SwimmingLessons;


public class BookingTestingClass {
    


    @Test
    public void case1_registerNewLearner() {
        //Add New Learner
        SwimmingLearners obj = new SwimmingLearners(985,3,6,"Jenny",
                "0114 258 6133","Jenny@34","Female");
        SwimmingLearners.swimmingLearnerData.add(obj);
        assertTrue(!SwimmingLearners.swimmingLearnerData.isEmpty());

    }
    
    
    @Test
    public void case2_bookClass(){
        int learnerUnqID = 1;
        int lessonUnqID = 1;
        SwimmingBookings.newClassByLearner(learnerUnqID, lessonUnqID);
        assertTrue(!SwimmingBookings.swimmingBookingData.isEmpty());
    }
    
        
    
    @Test
    public void case3_duplicateBooking(){
        int learnerUnqID = 1;
        int lessonUnqID = 1;
        SwimmingBookings.newClassByLearner(learnerUnqID, lessonUnqID);
        assertTrue(!SwimmingBookings.swimmingBookingData.isEmpty());
    }
    
    
    
    @Test
    public void case4_cancelClass(){

        int bookingID = Constants.filterTimetable;
        SwimmingBookings.cancelBooking(bookingID);
        ArrayList<SwimmingBookings> swimmingbookingdata = SwimmingBookings.getSwimmingBookingData();
        String status = "";
        for(SwimmingBookings obj : swimmingbookingdata){
            if(obj.getBookignID() == bookingID){
                status = obj.getStatus();
                break;
            }
        }
        assertTrue(status.equalsIgnoreCase(Constants.BOOKING_CANCEL));
    }
    

    
    
    @Test
    public void case5_filterByDay(){
        String day = "wednesday";
        SwimmingLessons.viewLessonDetails(0,day,0);
        assertTrue(!SwimmingLessons.swimmingLessonData.isEmpty());
    }
    
    
    
    
}
