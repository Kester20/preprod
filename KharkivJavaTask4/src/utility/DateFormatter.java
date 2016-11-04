package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * format string to date
 */
public class DateFormatter {

    /**
     * format string to date
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date format(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
