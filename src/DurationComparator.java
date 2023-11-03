import java.util.Comparator;

public class DurationComparator implements Comparator<ActivityTracked> {
    @Override
    public int compare(ActivityTracked at1, ActivityTracked at2) {
        return Double.compare(at1.getDuration(), at2.getDuration());
    }
}
