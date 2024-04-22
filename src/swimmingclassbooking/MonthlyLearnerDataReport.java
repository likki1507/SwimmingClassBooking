
package swimmingclassbooking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class MonthlyLearnerDataReport implements MonthlyReportCommandInterface {
    
     
    @Override
    public void retrieve() {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nEnter Month No. : ");
        String inputMonth = sc.nextLine();
        String swimmingLessonMonth = "5";
        
        if(!MainApp.validDigit(inputMonth) || (Integer.parseInt(inputMonth) < 1 || Integer.parseInt(inputMonth) > 12)){
            System.out.println("\nMonth Num should be valid numeric between 1 to 12");
            return;
        }
         
        List<SwimmingBookings> SwimmingBookingObj = SwimmingBookings.getSwimmingBookingData();
        List<SwimmingLearners> swimmingLearnerData = SwimmingLearners.getSwimmingLearnerData();
        List<SwimmingLessons> lsdata = SwimmingLessons.getSwimmingLessonData();
        List<SwimmingCoaches> cdata = SwimmingCoaches.getSwimmingCoachData();
        
        System.out.println();

        HashMap<Integer, int[]> learnerBookings = new HashMap<>();
        
        Set<Integer> learnerUnqID = new HashSet<>(); 
        if(inputMonth.equalsIgnoreCase(swimmingLessonMonth)){
            
            for (int j = 0; j < SwimmingBookingObj.size(); j++) {
                for (int i = 0; i < swimmingLearnerData.size(); i++) {

                    int uniqueKey = swimmingLearnerData.get(i).getLearnerID() + SwimmingBookingObj.get(j).getBookignID();

                    if (!learnerUnqID.contains(uniqueKey)) {
                        learnerUnqID.add(uniqueKey);

                        if (swimmingLearnerData.get(i).getLearnerID() == SwimmingBookingObj.get(j).getLearnerID()) {

                            int uniqueCode = swimmingLearnerData.get(i).getLearnerID();
                            int[] lessonCounter = learnerBookings.getOrDefault(uniqueCode, new int[3]);

                            if (SwimmingBookingObj.get(j).getStatus().equalsIgnoreCase(Constants.BOOKING_BOOKED) 
                                    || SwimmingBookingObj.get(j).getStatus().equalsIgnoreCase(Constants.BOOKING_CHANGE)) {
                                lessonCounter[0]++;
                            }
                            if (SwimmingBookingObj.get(j).getStatus().equalsIgnoreCase(Constants.BOOKING_ATTEND)) {
                                lessonCounter[1]++;
                            }
                            if (SwimmingBookingObj.get(j).getStatus().equalsIgnoreCase(Constants.BOOKING_CANCEL)) {
                                lessonCounter[2]++;
                            }
                            learnerBookings.put(uniqueCode, lessonCounter);
                        }
                    }
                }
            }
        }

        
        if(!learnerBookings.isEmpty()){
            for (Map.Entry<Integer, int[]> entry : learnerBookings.entrySet()) {
                int unqID = entry.getKey();
                int[] lessonCounter = entry.getValue();

                //Learenr details
                String learnerFullname = "";
                int learnerLevel = 0;
                for (int i = 0; i < swimmingLearnerData.size(); i++) {
                   if(swimmingLearnerData.get(i).getLearnerID() == unqID){
                       learnerFullname = swimmingLearnerData.get(i).getLearnerName();
                       learnerLevel = swimmingLearnerData.get(i).getGradeLevel();
                       break;
                   }
                }

                System.out.println("\nLearner Name : "+learnerFullname);
                System.out.println("Current Grade Level : "+learnerLevel);
                System.out.println("Booked Classes : "+lessonCounter[0]);
                System.out.println("Cancelled Classes : "+lessonCounter[2]);
                System.out.println("Attended Classes : "+lessonCounter[1]);
                
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-13s | %-15s | %-12s | %-30s | %-15s | %-20s |\n",
                        "Booking ID", "Status",  "Lesson No", "Lesson Name", "Class Grade","Trained By");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (int j = 0; j < SwimmingBookingObj.size(); j++) {
                    
                    if(SwimmingBookingObj.get(j).getLearnerID() == unqID){

                        //Lesson Grade Level
                        int swimmingLessonLevel = 0;
                        int coachNo = 0;
                        String className = "";
                        String coachFullname = "";
                        for (SwimmingLessons SwimminglessonObj : lsdata) {
                            if(SwimminglessonObj.getLessonNo() == SwimmingBookingObj.get(j).getLessonID()){
                                swimmingLessonLevel = SwimminglessonObj.getGradeLevel();
                                className = SwimminglessonObj.getLessonName();
                                coachNo = SwimminglessonObj.getTrainedBy();
                                break;
                            }
                        }
                        for (SwimmingCoaches SwimmingCoachObj : cdata) {
                            if(SwimmingCoachObj.getCoachID() == coachNo){
                                coachFullname = SwimmingCoachObj.getCoachName();
                                break;
                            }
                        }
                        System.out.printf("| %-13s | %-15s | %-12s | %-30s | %-15s | %-20s |\n",
                                SwimmingBookingObj.get(j).getBookignID(), SwimmingBookingObj.get(j).getStatus(), 
                                 SwimmingBookingObj.get(j).getLessonID(),
                                className, swimmingLessonLevel, coachFullname);
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }

                }
              
                System.out.println();
            }
        }else{
             System.out.println("No Data Found");
        }
    }
}

