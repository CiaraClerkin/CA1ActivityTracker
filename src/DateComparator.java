import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class DateComparator implements Comparator<ActivityTracked> {

    //private boolean ascending;

    //public DateComparator(boolean ascending) {this.ascending = ascending;}

    @Override
    public int compare(ActivityTracked at1, ActivityTracked at2) {
        /*DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime date1 = LocalDateTime.parse(at1.getDate(), dateFormat);
        LocalDateTime date2 = LocalDateTime.parse(at2.getDate(), dateFormat);*/

        String date1[] = at1.getDate().split("/");
        String date2[] = at2.getDate().split("/");


        //slashes are unnecessary, delete them
        String newDate1 = date1[2]+ "/" + date1[1] + "/" + date1[0];
        String newDate2 = date2[2]+ "/" + date2[1] + "/" + date2[0];

        return newDate1.compareTo(newDate2);

        //int output = date1.compareTo(date2);

        //if(!ascending) {
        //output = -output;
        //}



        //return output;
    }
}
