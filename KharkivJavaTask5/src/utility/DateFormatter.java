package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Said_Sulaiman_Arsala on 11/4/2016.
 * format string to date
 */
public class DateFormatter {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/YYYY");

	/**
	 * format string to date
	 *
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date format(String dateString) throws ParseException {
		return simpleDateFormat.parse(dateString);
	}
}
