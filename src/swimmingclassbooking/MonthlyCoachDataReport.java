
package swimmingclassbooking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class MonthlyCoachDataReport implements MonthlyReportCommandInterface {
    
    @Override
    public void retrieve(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Month No. : ");
        String inputMonthNum = sc.nextLine();
        
         if(!MainApp.validDigit(inputMonthNum) || (Integer.parseInt(inputMonthNum) < 1 || Integer.parseInt(inputMonthNum) > 12)){
            System.out.println("\nMonth Num should be valid numeric between 1 to 12");
            return;
        }
        
        List<SwimmingLessonRatings> SwimmingRatingdata = SwimmingLessonRatings.getSwimmigLessonRatingData();
        List<SwimmingLessons> SwimmingLessondata = SwimmingLessons.getSwimmingLessonData();
        List<SwimmingCoaches> SwimmingCoachdata = SwimmingCoaches.getSwimmingCoachData();
        
        HashMap<Integer, Integer> swimmingRatings = new HashMap<>();
        HashMap<Integer, Integer> allRecords = new HashMap<>();
        HashMap<Integer, Double> retrieveResult = new HashMap<>();
       
        System.out.println();
       
        for (SwimmingLessonRatings obj : SwimmingRatingdata){
            for (SwimmingLessons lessonObj : SwimmingLessondata){
                
                 //Parse date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                
                String monthNumber = "";
                try {
                    LocalDateTime parsedDateTime = LocalDate.parse(lessonObj.getClassDate(), formatter).atStartOfDay();
                    monthNumber = parsedDateTime.format(DateTimeFormatter.ofPattern("M"));

                } catch (DateTimeParseException e) {
                    System.out.println("Error parsing datetime: " + e.getMessage());
                }
                    
                 
                if(lessonObj.getTrainedBy()== obj.getFeedbackGivenTo() && monthNumber.equalsIgnoreCase(inputMonthNum)){
                    int givenRating = obj.getNumOfRating();

                    swimmingRatings.put(lessonObj.getTrainedBy(), swimmingRatings.getOrDefault(lessonObj.getTrainedBy(), 0) + givenRating);
                    allRecords.put(lessonObj.getTrainedBy(), allRecords.getOrDefault(lessonObj.getTrainedBy(), 0) + 1);
                }
            }
        }

        for (Integer coachNo : swimmingRatings.keySet()) {
            int ratings = swimmingRatings.get(coachNo);
            int rows = allRecords.get(coachNo);

            if (rows > 0) {
                double avgResult = (double) ratings / rows;
                double decimalPoints = Math.round(avgResult * 10.0) / 10.0; 
                retrieveResult.put(coachNo, decimalPoints);
            }
        }
        if(!retrieveResult.isEmpty()){
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-12s | %-15s | %-10s | %-10s | %-18s |\n", "CoachNo","FirstName",
                    "Contact","Gender","Age", "AverageRating");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            for (Integer coachNo : retrieveResult.keySet()) {
                double averageRating = retrieveResult.get(coachNo);
                
                String contact = "";
                String gender = "";
                String coachFullname = "";
                int age = 0;
                
                for (SwimmingCoaches swimmingCoachObj : SwimmingCoachdata) {
                    if(coachNo == swimmingCoachObj.getCoachID()){
                        coachFullname = swimmingCoachObj.getCoachName();
                        contact = swimmingCoachObj.getPhoneNo();
                        gender = swimmingCoachObj.getGender();
                        age = swimmingCoachObj.getAge();
                        break;
                    }
                }
                System.out.printf("| %-10s | %-12s | %-15s | %-10s | %-10s | %-18s |\n", coachNo,coachFullname,
                    contact,gender,age, averageRating);
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------");

        }else{
            System.out.println("No Data Found");
        }
    }
}
