import java.util.Comparator;

public class DateComparator implements Comparator<ActivityTracked> {
    @Override
    public int compare(ActivityTracked at1, ActivityTracked at2) {
        return at1.getDate().compareTo(at2.getDate());
    }
}
