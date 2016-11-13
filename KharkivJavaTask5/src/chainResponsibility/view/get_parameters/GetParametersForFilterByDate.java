package chainResponsibility.view.get_parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 * class for reading parameters for filter by date from console
 */
public class GetParametersForFilterByDate {

	private GetParameters getParameters;
	private List<String> listParams;
	private static final String ASK_BY_DATE = "By last change ?";
	private static final String ASK_THE_DATE = "Enter the range of date";
	private static final String FIRST_DATE = "first date";
	private static final String SECOND_DATE = "second date";

	/**
	 * initialize list of parameter names
	 */
	public GetParametersForFilterByDate() {
		listParams = new ArrayList<>();
		listParams.add(FIRST_DATE);
		listParams.add(SECOND_DATE);
		this.getParameters = new GetParameters(listParams);
	}

	/**
	 * reads parameters from console
	 * @return map of parameters, where key - parameter, entry - value
	 */
	public Map<String, Object> getParameters(){
		return getParameters.getParameters(ASK_BY_DATE, ASK_THE_DATE);
	}

	/**
	 *
	 * @return instance of getParameters
	 */
	public GetParameters getGetParameters() {
		return getParameters;
	}

	/**
	 *
	 * @return list of parameters names
	 */
	public List<String> getListParams() {
		return listParams;
	}

	/**
	 *
	 * @return question for user
	 */
	public static String getAskByDate() {
		return ASK_BY_DATE;
	}

	/**
	 *
	 * @return question for user
	 */
	public static String getAskTheDate() {
		return ASK_THE_DATE;
	}

	/**
	 *
	 * @return key in map
	 */
	public static String getFirstDate() {
		return FIRST_DATE;
	}

	/**
	 *
	 * @return key in map
	 */
	public static String getSecondDate() {
		return SECOND_DATE;
	}
}
