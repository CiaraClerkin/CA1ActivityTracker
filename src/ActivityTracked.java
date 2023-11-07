public class ActivityTracked {
    private String activity;
    private String date;
    private double duration;
    private double distance;
    private double avgHeartRate;
    private Intensity intensity;
    private double caloriesBurned;

    public ActivityTracked(String activity, String date, double duration, double distance, double avgHeartRate) {
        this.activity = activity;
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        this.avgHeartRate = avgHeartRate;
        setIntensity();
        //setCaloriesBurned();
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
        return caloriesBurned;
    }

    public Intensity getIntensity()
    {
        setIntensity();
        return intensity;
    }


    private void setIntensity() {
        double[] kilometres = null;

        if (activity.equalsIgnoreCase("swimming")) {
            kilometres = new double[]{0.5, 1.25, 2, 2.75, 3.5};
        } else if (activity.equalsIgnoreCase("running")) {
            kilometres = new double[]{4.0, 8.0, 12.0, 16.0, 24.0};
        } else if (activity.equalsIgnoreCase("cycling")) {
            kilometres = new double[]{8.0, 16.0, 25.0, 33.0, 40.0};
        }

        double speed = distance / (duration / 60);
        if (kilometres != null)
        {
            if (speed < kilometres[0])
            {
                intensity = Intensity.VERY_LIGHT;
            }
            else if (speed >= kilometres[0] && speed < kilometres[1])
            {
                intensity = Intensity.LIGHT;
            }
            else if (speed >= kilometres[1] && speed < kilometres[2])
            {
                intensity = Intensity.MODERATE;
            }
            else if (speed >= kilometres[2] && speed < kilometres[3])
            {
                intensity = Intensity.VIGOROUS;
            }
            else if (speed >= kilometres[3])
            {
                intensity = Intensity.VERY_VIGOROUS;
            }
        }
    }

    public void setCaloriesBurned() {
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

        caloriesBurned = intenseValue * duration;
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
