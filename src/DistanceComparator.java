import java.util.Comparator;

public class DistanceComparator implements Comparator<ActivityTracked> {
    @Override
    public int compare(ActivityTracked at1, ActivityTracked at2) {
        return Double.compare(at1.getDistance(), at2.getDistance());
    }
}
