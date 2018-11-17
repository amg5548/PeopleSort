
import java.text.*;
import java.util.*;
import java.util.logging.*;

public class DateOfBirthComparator implements Comparator<People> {

    @Override
    public int compare(People p1, People p2) {
        try {

            Date date1 = new SimpleDateFormat("M/d/yyyy").parse(p1.getDateOfBirth());
            Date date2 = new SimpleDateFormat("M/d/yyyy").parse(p2.getDateOfBirth());

            return date1.compareTo(date2);

        } catch (ParseException ex) {
            Logger.getLogger(DateOfBirthComparator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
