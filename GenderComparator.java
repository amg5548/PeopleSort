
import java.util.*;

public class GenderComparator implements Comparator<People> {

    @Override
    public int compare(People p1, People p2) {
        if ("Male".equals(p1.getGender()) && "Female".equals(p2.getGender())) {
            return 1;
        }
        if ("Female".equals(p1.getGender()) && "Male".equals(p2.getGender())) {
            return -1;
        }
        return 0;
    }
}
