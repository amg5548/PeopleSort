
import java.util.*;

public class LastNameComparator implements Comparator<People> {

    @Override
    public int compare(People p1, People p2) {
        return p1.getLastName().compareTo(p2.getLastName());
    }
}
