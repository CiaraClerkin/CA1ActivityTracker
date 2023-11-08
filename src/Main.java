import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);


        //Menu Layout (subject to change)
        boolean exit = false;

        while(!exit)
        {
            System.out.println("Welcome to CA1 Activity Tracker, By Ciara and Stephen");
            System.out.println("");
            System.out.println("1. View Activites in order of:");
            System.out.println("2. View a subset of Activity");
            System.out.println("3. View overall performance");
            System.out.println("4. Binary Search");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            if(choice == 1) {
                System.out.println("1. Caldories Burned");
                System.out.println("2. Date");
                System.out.println("3. Duration");
                System.out.println("4. Type of Activity");
                System.out.println("5. Distance");
                System.out.println("");
                int choice1 = scanner.nextInt();

                if (choice1 == 1) {
                    orderBy(cCal, true);
                } else if (choice1 == 2) {
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.println("");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) { orderBy(cDate, true); }
                    else if (choice2 == 2) { orderBy(cDate, false); }

                } else if (choice1 == 3) {
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.println("");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) { orderBy(cDur, true); }
                    else if (choice2 == 2) { orderBy(cDur, false); }

                } else if (choice1 == 4) {
                    orderBy(cAct, true);
                } else if (choice1 == 5) {
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.println("");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) { orderBy(cDis, true); }
                    else if (choice2 == 2) { orderBy(cDis, false); }
                }
            }

            else if(choice == 2) {
                System.out.println("1. Activity Type");
                System.out.println("2. Above a Minimum Distance");
                System.out.println("3. Type of Intensity");
                System.out.println("4. Above a minimum duration");
                System.out.println("");
                int choice1 = scanner.nextInt();

                if (choice1 == 1) {
                    System.out.println("1. Cycling");
                    System.out.println("2. Running");
                    System.out.println("3. Swimming");
                    System.out.println("");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) { PrintAT("Cycling"); }
                    else if (choice2 == 2) { PrintAT("Running"); }
                    else if (choice2 == 3) { PrintAT("Swimming"); }

                } else if (choice1 == 2) {
                    System.out.println("Input Minimum Distance");
                    System.out.println("");
                    double minDistance = scanner.nextDouble();

                    minimumDistance(minDistance);

                } else if (choice1 == 3) {
                    System.out.println("1. Very Light");
                    System.out.println("2. Light");
                    System.out.println("3. Moderate");
                    System.out.println("4. Vigorous");
                    System.out.println("5. Very Vigorous");
                    System.out.println("");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) { viewIntensity(Intensity.VERY_LIGHT); }
                    else if (choice2 == 2) { viewIntensity(Intensity.LIGHT); }
                    else if (choice2 == 3) { viewIntensity(Intensity.MODERATE); }
                    else if (choice2 == 4) { viewIntensity(Intensity.VIGOROUS); }
                    else if (choice2 == 5) { viewIntensity(Intensity.VERY_VIGOROUS); }

                } else if (choice1 == 4) {
                    System.out.println("Input Minimum Duration");
                    System.out.println("");
                    double minDuration = scanner.nextDouble();

                    minimumDuration(minDuration);
                }
            }

            if(choice == 3)
            {
                System.out.println("1. Average distance per activity");
                System.out.println("2. Average calories burned");
                System.out.println("");
                int choice1 = scanner.nextInt();

                if (choice1 == 1)
                {
                    averageDistance();
                }
                else if (choice1 == 2)
                {
                    averageCalories();
                }

            }

            if(choice == 4)
            {
                System.out.println("Enter the activites name:");
                scanner.nextLine();
                String activityName = scanner.nextLine();
                binarySearchName(activityName);
            }
            if(choice == 5)
            {
                exit = true;
            }
            /*else
            {
                System.out.println("Please use a valid input");
            }*/

        }
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


         /* //test ordering by activity type
        Comparator<ActivityTracked> cAct = new ActivityComparator();
        Collections.sort(ActivitiesTracked, cAct);
        System.out.println("test ordering by activity type");
        PrintAT();

        //test ordering by date
        Comparator<ActivityTracked> cDate = new DateComparator();
        Collections.sort(ActivitiesTracked, cDate);
        //Collections.reverse();
        System.out.println("test ordering by date");
        PrintAT();

        //test ordering by activity duration
        DurationComparator cDur = new DurationComparator();
        Collections.sort(ActivitiesTracked, cDur);
        System.out.println("test ordering by activity duration");
        PrintAT();

        //test ordering by distance
        DistanceComparator cDis = new DistanceComparator();
        Collections.sort(ActivitiesTracked, cDis);
        System.out.println("test ordering by distance");
        PrintAT();

        System.out.println();

        //test binary search name
        Collections.sort(ActivitiesTracked, cAct);
        System.out.println("test binary search name");
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
        System.out.println("test date reverse order");
        PrintAT();*/
    }

    public static void PrintAT() {
        System.out.printf("%s\t%5s\t\t\t%s\t%s\t%s\t\t%s\t\t\t%s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burned");
        for (ActivityTracked at: ActivitiesTracked) {
            System.out.printf("%-13s\t%s\t\t%-4f\t%f\t%f\t\t\t\t%-13s\t\t%f\n", at.getActivity(), at.getDate(), at.getDuration(), at.getDistance(), at.getAvgHeartRate(), at.getIntensity(), at.getCaloriesBurned());
        }
        System.out.println();
    }

    public static void PrintAT(String activityType) {
        System.out.printf("%s\t%5s\t\t\t%s\t%s\t%s\t\t%s\t\t\t%s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burned");
        for (ActivityTracked at: ActivitiesTracked) {
            if (at.getActivity().equalsIgnoreCase(activityType)) {
                System.out.printf("%-13s\t%s\t\t%-4f\t%f\t%f\t\t\t\t%-13s\t\t%f\n", at.getActivity(), at.getDate(), at.getDuration(), at.getDistance(), at.getAvgHeartRate(), at.getIntensity(), at.getCaloriesBurned());
            }
        }
        System.out.println();
    }

    public static void minimumDistance(double minDistance)
    {
        System.out.printf("%s\t%5s\t\t\t%s\t%s\t%s\t\t%s\t\t\t%s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burned");
        for (ActivityTracked at: ActivitiesTracked) {
            if (at.getDistance() >= minDistance) {
                System.out.printf("%-13s\t%s\t\t%-4f\t%f\t%f\t\t\t\t%-13s\t\t%f\n", at.getActivity(), at.getDate(), at.getDuration(), at.getDistance(), at.getAvgHeartRate(), at.getIntensity(), at.getCaloriesBurned());
            }
        }
        System.out.println();
    }

    /*public static void minimum(double min, double ref)
    {
        for (ActivityTracked activity : ActivitiesTracked)
        {
            if (ref >= min)
            {
                System.out.println(activity);
            }
        }
    }*/

    public static void minimumDuration(double minDuration)
    {
        System.out.printf("%s\t%5s\t\t\t%s\t%s\t%s\t\t%s\t\t\t%s\n", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burned");
        for (ActivityTracked at: ActivitiesTracked) {
            if (at.getDuration() >= minDuration) {
                System.out.printf("%-13s\t%s\t\t%-4f\t%f\t%f\t\t\t\t%-13s\t\t%f\n", at.getActivity(), at.getDate(), at.getDuration(), at.getDistance(), at.getAvgHeartRate(), at.getIntensity(), at.getCaloriesBurned());
            }
        }
        System.out.println();
    }

    /*public static void activityType(String activityType)
    {
        for (ActivityTracked activity : ActivitiesTracked)
        {
            if (activity.getActivity().equalsIgnoreCase(activityType))
            {
                //System.out.println(activity);
            }
        }
    }*/

    public static Comparator<ActivityTracked> cAct = new ActivityComparator();
    public static Comparator<ActivityTracked> cDate = new DateComparator();
    public static DurationComparator cDur = new DurationComparator();
    public static DistanceComparator cDis = new DistanceComparator();
    public static Comparator<ActivityTracked> cCal = new CaloriesBurnedComparator();

    public static void orderBy(Comparator<ActivityTracked> cAT, boolean ascending) {
        Collections.sort(ActivitiesTracked, cAT);
        if (!ascending) {
            Collections.reverse(ActivitiesTracked);
        }
        PrintAT();
    }



    public static void viewIntensity(Intensity intensity)
    {
        for (ActivityTracked activity : ActivitiesTracked)
        {
            if (activity.getIntensity() == intensity)
            {
                System.out.println(activity);
            }
        }
    }

    public static void orderCaloriesBurned()
    {
        Collections.sort(ActivitiesTracked, cCal);
        PrintAT();
    }

    public static void averageDistance()
    {
        List<String> activityTypes = new ArrayList<>();
        List<Double> Distances = new ArrayList<>();
        List<Integer> Counter = new ArrayList<>();

        for (ActivityTracked activity : ActivitiesTracked)
        {
            String activityType = activity.getActivity();
            double distance = activity.getDistance();

            int index = activityTypes.indexOf(activityType);
            if (index == -1)
            {
                activityTypes.add(activityType);
                Distances.add(distance);
                Counter.add(1);
            }
            else
            {
                Distances.set(index, Distances.get(index) + distance);
                Counter.set(index, Counter.get(index) + 1);
            }
        }

        for (int i = 0; i < activityTypes.size(); i++)
        {
            String activityType = activityTypes.get(i);
            double totalDistance = Distances.get(i);
            int count = Counter.get(i);
            double averageDistance = totalDistance / count;

            System.out.println("Average distance for " + activityType + ": " + averageDistance + " Kilometres");
        }
    }

    public static void averageCalories()
    {
        double totalCalories = 0;
        int activityCount = ActivitiesTracked.size();
        for (ActivityTracked activity : ActivitiesTracked)
        {
            totalCalories += activity.getCaloriesBurned();
        }
        double averageCalories = totalCalories / activityCount;
        System.out.println("Average calories burned: " + averageCalories + " calories");
    }


    public static void binarySearchName (String activityName) {
        //Comparator<ActivityTracked> cAct = new ActivityComparator();
        Collections.sort(ActivitiesTracked, cAct);
        //PrintAT();

        ActivityTracked key = new ActivityTracked(activityName,"", 0, 0, 0);
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
