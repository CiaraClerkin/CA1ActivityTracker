import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void readFile(String fileName, ArrayList<ActivityTracked> activities) throws IOException {
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            ActivityTracked at = parseLine(line);
            activities.add(at);
        }
    }

    // creates ActivityTracked instances based on csv file
    public static ActivityTracked parseLine(String line) {
        String activity;
        String date;
        double duration;
        double distance;
        double avgHeartRate;

        StringTokenizer st = new StringTokenizer(line, ",");

        activity = st.nextToken();
        date = st.nextToken();
        duration = Double.parseDouble(st.nextToken().trim());
        distance = Double.parseDouble(st.nextToken().trim());
        avgHeartRate = Double.parseDouble(st.nextToken().trim());

        return new ActivityTracked(activity, date, duration, distance, avgHeartRate);
    }

    public static ArrayList<ActivityTracked> ActivitiesTracked = new ArrayList<ActivityTracked>();

    public static void main(String[] args) throws IOException {
        readFile("ActivitiesTracked.csv", ActivitiesTracked);
        //test if csv reading works
        PrintAT();


        //Menu Layout (subject to change)
        //view activities in order by:
            //calories burned (descending, no option)
            //date
                //ascending
                //descending
            //activity duration
                //ascending
                //descending
            //type of activity
            //distance
                //ascending
                //descending
        //view a subset of activity
            //activity type
                //Cycling
                //Running
                //Swimming
            //above a minimum distance
                //input minimum distance
            //type of energy expended
                //Very Light
                //Light
                //Moderate
                //Vigorous
                //Very vigorous
            //above a minimum duration
                //input minimum duration


        //test ordering by activity type
        Comparator<ActivityTracked> cAct = new ActivityComparator();
        Collections.sort(ActivitiesTracked, cAct);
        PrintAT();

        //test ordering by date
        Comparator<ActivityTracked> cDate = new DateComparator();
        Collections.sort(ActivitiesTracked, cDate);
        PrintAT();

        //test ordering by activity duration
        DurationComparator cDur = new DurationComparator();
        Collections.sort(ActivitiesTracked, cDur);
        PrintAT();

        //test ordering by distance
        DistanceComparator cDis = new DistanceComparator();
        Collections.sort(ActivitiesTracked, cDis);
        PrintAT();

        System.out.println();

        //test binary search name
        Collections.sort(ActivitiesTracked, cAct);
        PrintAT();

        ActivityTracked key = new ActivityTracked("Running","", 0, 0, 0);
        //key.setDate("2023/06/12");

        int index = Collections.binarySearch(ActivitiesTracked, key, cAct);
        //System.out.println(index);

        if (index >= 0) {
            System.out.println("Found " + ActivitiesTracked.get(index) + " at index " + index);
        }
        else {
            System.out.println("Not found in list");
        }

        System.out.println();

        //test date reverse order
        Collections.sort(ActivitiesTracked, cDate);
        Collections.reverse(ActivitiesTracked);
        PrintAT();
    }

    public static void PrintAT() {
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }
        System.out.println();
    }
}
