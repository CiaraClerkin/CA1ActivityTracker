public class ActivityTracked {
    private String activity;
    private double duration;
    private String date;
    private double distance;
    private double avgHeartRate;
    private Intensity intensity;
    private double caloriesBurned;

    public ActivityTracked(String activity, double duration, String date, double distance, double avgHeartRate) {
        this.activity = activity;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.avgHeartRate = avgHeartRate;
        //this.caloriesBurned = getCaloriesBurned();
    }

    public ActivityTracked() {

    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAvgHeartRate() {
        return avgHeartRate;
    }

    public void setAvgHeartRate(double avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }


    public double getCaloriesBurned() {
        double[] swimming = new double[]{5, 6.3, 7.6, 8.9, 10.2};
        double[] running = new double[]{4.1, 7.2, 10, 15.4, 20.8};
        double[] cycling = new double[]{2, 5, 7, 13, 15};
        double[] current = new double[5];


        if (activity.equalsIgnoreCase("swimming")) {
            current = swimming;
        }
        else if (activity.equalsIgnoreCase("running")) {
            current = running;
        }
        else {
            current = cycling;
        }

        double intenseValue = 0;

        switch (intensity) {
            case VERY_LIGHT -> intenseValue = current[0];
            case LIGHT -> intenseValue = current[1];
            case MODERATE -> intenseValue = current[2];
            case VIGOROUS -> intenseValue = current[3];
            case VERY_VIGOROUS -> intenseValue = current[4];
        }

        return intenseValue * duration;
    }

    @Override
    public String toString() {
        return "ActivityTracked{" +
                "activity='" + activity + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", avgHeartRate=" + avgHeartRate +
                '}';
    }
}
