package chainResponsibility.view.get_parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan
 * class for reading parameters for filter by size from console
 */
public class GetParametersForFilterBySize {

	private GetParameters getParameters;
	private List<String> listParams;
	private static final String ASK_BY_SIZE = "By size ?";
	private static final String ASK_THE_SIZE = "Enter the range of size";
	private static final String FIRST_SIZE = "first size";
	private static final String SECOND_SIZE = "second size";

	/**
	 * initialize list of parameter names
	 */
	public GetParametersForFilterBySize() {
		listParams = new ArrayList<>();
		listParams.add(FIRST_SIZE);
		listParams.add(SECOND_SIZE);
		this.getParameters = new GetParameters(listParams);
	}

	/**
	 * reads parameters from console
	 * @return map of parameters, where key - parameter, entry - value
	 */
	public Map<String, Object> getParameters() {
		return getParameters.getParameters(ASK_BY_SIZE, ASK_THE_SIZE);
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
	public static String getAskBySize() {
		return ASK_BY_SIZE;
	}

	/**
	 *
	 * @return question for user
	 */
	public static String getAskTheSize() {
		return ASK_THE_SIZE;
	}

	/**
	 *
	 * @return key in map
	 */
	public static String getFirstSize() {
		return FIRST_SIZE;
	}

	/**
	 *
	 * @return key in map
	 */
	public static String getSecondSize() {
		return SECOND_SIZE;
	}
}
