
package swimmingclassbooking;


public class MonthlyReportIntermediator {
 
     private MonthlyReportCommandInterface reportCommandInterfaceObj;

    public void setReportCommand(MonthlyReportCommandInterface reportCommandInterfaceObj) {
        this.reportCommandInterfaceObj = reportCommandInterfaceObj;
    }

    public void retrieveReports(String choice) {
        if (choice.equalsIgnoreCase("1")) {
            setReportCommand(new MonthlyCoachDataReport());
        } else if (choice.equalsIgnoreCase("2")) {
            setReportCommand(new MonthlyLearnerDataReport());
        }

        if (reportCommandInterfaceObj != null) {
            reportCommandInterfaceObj.retrieve();
        }
    }
    
}
