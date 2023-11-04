import java.util.Comparator;

public class CaloriesBurnedComparator implements Comparator<ActivityTracked> {
    @Override
    public int compare(ActivityTracked at1, ActivityTracked at2) {
        return Double.compare(at1.getCaloriesBurned(), at2.getCaloriesBurned());
    }
}
