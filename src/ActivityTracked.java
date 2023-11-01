public class ActivityTracked {
    private String activity;
    private double duration;
    private String date;
    private double distance;
    private double avgHeartRate;
    private double intensity;

    public ActivityTracked(String activity, double duration, String date, double distance, double avgHeartRate) {
        this.activity = activity;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.avgHeartRate = avgHeartRate;
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


    public double caloriesBurned() {
        return intensity * duration;
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
