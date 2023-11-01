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

        for (ActivityTracked at: ActivitiesTracked) {
            System.out.println(at);
        }
    }
}
