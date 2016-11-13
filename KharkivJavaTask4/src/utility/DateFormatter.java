package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arsalan
 * format string to date
 */
public class DateFormatter {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
