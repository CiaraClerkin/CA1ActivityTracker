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

    public static ActivityTracked parseLine(String line) {
        String activity;
        double duration;
        String date;
        double distance;
        double avgHeartRate;

        int comma1 = line.indexOf(",");
        int comma2 = line.indexOf(",", comma1+1);
        int comma3 = line.indexOf(",", comma2+1);
        int comma4 = line.indexOf(",", comma3+1);

        activity = line.substring(0, comma1);
        duration = Double.parseDouble(line.substring(comma1+1, comma2).trim());
        date = line.substring(comma2+1, comma3);
        distance = Double.parseDouble(line.substring(comma3+1, comma4));
        avgHeartRate = Double.parseDouble(line.substring(comma4+1).trim());

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
