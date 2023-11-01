import java.util.Comparator;

public class ActivityComparator implements Comparator<ActivityTracked> {
    @Override
    public int compare(ActivityTracked at1, ActivityTracked at2) {
        return at1.getActivity().compareTo(at2.getActivity());
    }
}
