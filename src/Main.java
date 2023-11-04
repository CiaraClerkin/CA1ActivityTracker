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
        double duration;
        String date;
        double distance;
        double avgHeartRate;

        StringTokenizer st = new StringTokenizer(line, ",");

        activity = st.nextToken();
        duration = Double.parseDouble(st.nextToken().trim());
        date = st.nextToken();
        distance = Double.parseDouble(st.nextToken().trim());
        avgHeartRate = Double.parseDouble(st.nextToken().trim());

        return new ActivityTracked(activity, duration, date, distance, avgHeartRate);
    }

    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");

        ArrayList<ActivityTracked> ActivitiesTracked = new ArrayList<ActivityTracked>();
        readFile("ActivitiesTracked.csv", ActivitiesTracked);

        //test if csv reading works
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }

        System.out.println();

        //test ordering by activity type
        Comparator<ActivityTracked> cAct = new ActivityComparator();
        Collections.sort(ActivitiesTracked, cAct);
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }

        System.out.println();

        //test ordering by date
        Comparator<ActivityTracked> cDate = new DateComparator();
        Collections.sort(ActivitiesTracked, cDate);
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }

        System.out.println();

        //test ordering by activity duration
        DurationComparator cDur = new DurationComparator();
        Collections.sort(ActivitiesTracked, cDur);
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }

        System.out.println();

        //test ordering by distance
        DistanceComparator cDis = new DistanceComparator();
        Collections.sort(ActivitiesTracked, cDis);
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }

        System.out.println();

        //test binary search name
        Collections.sort(ActivitiesTracked, cAct);
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }

        ActivityTracked key = new ActivityTracked("Running", 0, "", 0, 0);
        //key.setDate("2023/06/12");

        int index = Collections.binarySearch(ActivitiesTracked, key, cAct);
        //System.out.println(index);

        if (index >= 0) {
            System.out.println("Found " + ActivitiesTracked.get(index) + " at index " + index);
        }
        else {
            System.out.println("Not found in list");
        }

    }
}
