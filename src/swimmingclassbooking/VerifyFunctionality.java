
package swimmingclassbooking;

import java.util.List;


public class VerifyFunctionality {
    
    //retrieve learner id 
    public static int retrieveLearnerID(int bookingID){      
        int learnerUnqiD = 0;
        List<SwimmingBookings> swimmingBookingData = SwimmingBookings.getSwimmingBookingData();
        for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getBookignID()== bookingID){
                learnerUnqiD = obj.getLearnerID();
                break;
            }
        }
        return learnerUnqiD;
    }
    
         
    //retrieve booking id
    public static boolean retrieveBookingID(int bookingCode){
        boolean retrieve = false;
        
        List<SwimmingBookings> swimmingBookingData = SwimmingBookings.getSwimmingBookingData();
        for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getBookignID() == bookingCode){
                retrieve = true;
                break;
            }
        }
        
        return retrieve;
    }
    
    
    //duplicate booking by learner
    public static boolean duplicateLessonBooking(int lessonUnID, int learnerUnqID){      
        boolean duplicate = false;
        List<SwimmingBookings> swimmingBookingData = SwimmingBookings.getSwimmingBookingData();
        for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getLearnerID() == learnerUnqID&& obj.getLessonID()== lessonUnID){
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }
    
    
    //booking cancelled or attended already
    public static boolean alreadyAttndOrCancelledBooking(int bookingCode){      
        boolean already = false;
        List<SwimmingBookings> swimmingBookingData = SwimmingBookings.getSwimmingBookingData();
        for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getBookignID() == bookingCode){
                if(obj.getStatus().equalsIgnoreCase(Constants.BOOKING_ATTEND) || obj.getStatus().equalsIgnoreCase(Constants.BOOKING_CANCEL)){
                    already = true;
                    break;
                 }
            }
        }
        return already;
    }
    
    
    //Lesson seats available or not
    public static int isAvaillableLessonSeat(int lessonUnID){      
        int allowedMembers = 0;
       List<SwimmingLessons> swimmingLessondata = SwimmingLessons.getSwimmingLessonData();
         for(SwimmingLessons obj : swimmingLessondata){
            if(obj.getLessonNo() == lessonUnID){
                int seats = obj.getAllowedMembers();
                allowedMembers = seats;
                break;
            }
        }
         return allowedMembers;
    }
    
    
    
    //is correct receptionist
    public static boolean isCorrectReceptionistID(String receptionistPass){
            
        boolean isValidated = false;
        List<Receptionists> receptionistData = Receptionists.getReceptionistData();
        
        for(Receptionists obj : receptionistData){
            if(obj.getPassword().equalsIgnoreCase(receptionistPass)){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    // is lesson grade higher than current level of learner
    public static boolean compareLessonGradeWithCurrentGrade(int lessonUnID, int rollNo){
        boolean isHigher = false;
       
        //Learner Current Grade
        List<SwimmingLearners> swimmingLearnerdata = SwimmingLearners.getSwimmingLearnerData();
        int level = 0;
        for(SwimmingLearners obj : swimmingLearnerdata){
            if(obj.getLearnerID() == rollNo){
                level = obj.getGradeLevel();
                break;
            }
        }

        //Lesson Grade
        List<SwimmingLessons> swimmingLessons = SwimmingLessons.getSwimmingLessonData();
        int lessonGrade = 0;
        for(SwimmingLessons obj : swimmingLessons){
            if(obj.getLessonNo() == lessonUnID){
                lessonGrade = obj.getGradeLevel();
                break;
            }
        }
        
        int allowed = level + 1;
        if(lessonGrade < level || lessonGrade > allowed){
            isHigher = true;
        }
        
        return isHigher;
    }

    
    //coach id correct or not
    public static boolean isCorrecrCoachID(int coachNo){
            
        boolean isValidated = false;
        List<SwimmingCoaches> swimmingCoachesdata = SwimmingCoaches.getSwimmingCoachData();
        
        for(SwimmingCoaches obj : swimmingCoachesdata){
            if(obj.getCoachID() == coachNo){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //learer unique id correct or not
    public static boolean isCorrectLearnerID(int learnerUnqID){
            
        boolean compared = false;
        List<SwimmingLearners> swimmingLessondata = SwimmingLearners.getSwimmingLearnerData();
        
        for(SwimmingLearners obj : swimmingLessondata){
            if(obj.getLearnerID() == learnerUnqID){
                compared = true;
                break;
            }
        }
        return compared;
    }
    
    
    //comapre learner details
    public static boolean compareLearnerDetails(int learnerUnqID, String unqPass){
            
        boolean compared = false;
        List<SwimmingLearners> swimmingLessondata = SwimmingLearners.getSwimmingLearnerData();
        
        for(SwimmingLearners obj : swimmingLessondata){
            if(obj.getLearnerID() == learnerUnqID && obj.getUniquePassword().equalsIgnoreCase(unqPass)){
                compared = true;
                break;
            }
        }
        return compared;
    }

    
    //is Correct Lesson ID
    public static boolean isCorrectLesson(int lessonUnID){
            
        boolean isValidated = false;
        List<SwimmingLessons> swimmingLessondata = SwimmingLessons.getSwimmingLessonData();
        
        for(SwimmingLessons obj : swimmingLessondata){
            if(obj.getLessonNo() == lessonUnID){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }


    //Number of seats of lessons - update
    public static void setNoOfSeatsOfLessons(int lessonUnID, int add, int minus){
         List<SwimmingLessons> swimmingLessondata = SwimmingLessons.getSwimmingLessonData();
         for(SwimmingLessons obj : swimmingLessondata){
            if(obj.getLessonNo() == lessonUnID){
                int allowedMembers = obj.getAllowedMembers();
                if(add != 0){
                    obj.setAllowedMembers(allowedMembers+1);
                }
                if(minus != 0){
                    obj.setAllowedMembers(allowedMembers-1);
                }
                break;
            }
        }
    }
    

    //get user role
    public static int getUserRole(int bookingCode){      
        int learnerUnqID = 0;
        List<SwimmingBookings> swimmingBookingData = SwimmingBookings.getSwimmingBookingData();
        for(SwimmingBookings obj : swimmingBookingData){
            if(obj.getBookignID()== bookingCode){
                learnerUnqID = obj.getLearnerID();
                break;
            }
        }
        return learnerUnqID;
    }
    
    
     
    //current level of learner
    public static int retrieveLearnerGrade(int learnerUnqID){
        int level = 0;

        List<SwimmingLearners> swimmingLessondata = SwimmingLearners.getSwimmingLearnerData();
        for(SwimmingLearners obj : swimmingLessondata){
            if(obj.getLearnerID() == learnerUnqID){
                level = obj.getGradeLevel();
                break;
            }
        }

        return level;
    }
    

    // increase learenr grade level to one grade level higher
    public static void incLearnerGradeLevel(int rollNo){
        List<SwimmingLearners> swimmingLearnerData = SwimmingLearners.getSwimmingLearnerData();
        for(SwimmingLearners obj : swimmingLearnerData){
            if(obj.getLearnerID() == rollNo){
                int grade = obj.getGradeLevel();
                obj.setGradeLevel(grade+1);
                break;
            }
        }
    }

}
